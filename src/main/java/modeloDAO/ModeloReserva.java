package modeloDAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modeloDTO.Reserva;

public class ModeloReserva extends Conector{
	public boolean insertarReserva(Reserva reserva) {
		String st = "INSERT INTO reservas (id_parcela,id_clientes,fecha_ingreso,fecha_salida) VALUES (?,?,?,?)";

		try {
			PreparedStatement pst = super.connection.prepareStatement(st);

			pst.setInt(1, reserva.getParcela().getId());
			pst.setInt(2, reserva.getCliente().getId());
			pst.setDate(3, new Date(reserva.getFecha_ingreso().getTime()));
			pst.setDate(4, new Date(reserva.getFecha_salida().getTime()));

			pst.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}
	
	public boolean eliminarReserva(Reserva reserva) {
		String st = "DELETE FROM reservas WHERE id_parcela=? and id_clientes=? and fecha_ingreso=? and fecha_salida=?";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);

			pst.setInt(1, reserva.getParcela().getId());
			pst.setInt(2, reserva.getCliente().getId());
			pst.setDate(3, new Date(reserva.getFecha_ingreso().getTime()));
			pst.setDate(4, new Date(reserva.getFecha_salida().getTime()));

			pst.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public Reserva getReserva(int id_cliente) {
		String st = "SELECT * FROM reservas WHERE id_cliente=?";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setInt(1, id_cliente);
			
			ResultSet rs = pst.executeQuery();
			rs.next();
			
			Reserva reserva = rellernarReserva(rs);
			
			return reserva;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	private Reserva rellernarReserva(ResultSet rs) throws SQLException {
		ModeloCliente modeloCliente = new ModeloCliente();
		ModeloParcela modeloParcela = new ModeloParcela();
		
		modeloCliente.conectar();
		modeloParcela.conectar();
		
		Reserva reserva = new Reserva();
		
		reserva.setCliente(modeloCliente.getCliente(rs.getInt("id_cliente")));
		reserva.setParcela(modeloParcela.getParcela(rs.getInt("id_parcela")));
		reserva.setFecha_ingreso(rs.getDate("fecha_ingreso"));
		reserva.setFecha_salida(rs.getDate("fecha_salida"));
		
		modeloCliente.cerrar();
		modeloParcela.cerrar();
		return reserva;
	}
	
	public ArrayList<Reserva> getAllReservas() {
		String st = "SEELCT * FROM reservas";
		ArrayList<Reserva> reservas = new ArrayList<>();
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				reservas.add(rellernarReserva(rs));
			}
			
			return reservas;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
