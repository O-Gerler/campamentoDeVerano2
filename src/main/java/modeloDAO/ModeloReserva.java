package modeloDAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modeloDTO.Reserva;

public class ModeloReserva extends Conector{
	public boolean insertarReserva(Reserva reserva) {
		String st = "INSERT INTO reservas (id_parcela,id_usuario,fecha_ingreso,fecha_salida,ocupado) VALUES (?,?,?,?,?)";

		try {
			PreparedStatement pst = super.connection.prepareStatement(st);

			pst.setInt(1, reserva.getParcela().getId());
			pst.setInt(2, reserva.getUsuario().getId());
			pst.setDate(3, new Date(reserva.getFecha_ingreso().getTime()));
			pst.setDate(4, new Date(reserva.getFecha_salida().getTime()));
			pst.setBoolean(5, true);

			pst.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}
	
	public boolean eliminarReserva(Reserva reserva) {
		String st = "DELETE FROM reservas WHERE id_parcela=? and id_usuario=? and fecha_ingreso=? and fecha_salida=?";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);

			pst.setInt(1, reserva.getParcela().getId());
			pst.setInt(2, reserva.getUsuario().getId());
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
		String st = "SELECT * FROM reservas WHERE id_usuario=?";
		
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
		ModeloUsuario modeloUsuario = new ModeloUsuario();
		ModeloParcela modeloParcela = new ModeloParcela();
		
		modeloUsuario.conectar();
		modeloParcela.conectar();
		
		Reserva reserva = new Reserva();
		
		reserva.setUsuario(modeloUsuario.getUsuarios(rs.getInt("id_usuario")));
		reserva.setParcela(modeloParcela.getParcela(rs.getInt("id_parcela")));
		reserva.setFecha_ingreso(rs.getDate("fecha_ingreso"));
		reserva.setFecha_salida(rs.getDate("fecha_salida"));
		reserva.setOcupado(rs.getBoolean("ocupado"));
		
		modeloUsuario.cerrar();
		modeloParcela.cerrar();
		return reserva;
	}
	
	public ArrayList<Reserva> getReservasUsuario(int id_usuario) {
		String st = "SELECT * FROM reservas WHERE id_usuario=?";
		ArrayList<Reserva> reservas = new ArrayList<>();
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setInt(1, id_usuario);
			
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
	
	public boolean reservaLibre(Reserva reserva) {
		String st = "select * from reservas\r\n"
				+ "where \r\n"
				+ "  ?  between (select fecha_ingreso\r\n"
				+ "                 where id_parcela = ?) and (select fecha_salida\r\n"
				+ "                 where id_parcela = ?) \r\n"
				+ "or ?  between (select fecha_ingreso\r\n"
				+ "                 where id_parcela = ?) and (select fecha_salida\r\n"
				+ "                 where id_parcela = ?)  ";
		ArrayList<Reserva> reservas = new ArrayList<>();
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setDate(1, new Date(reserva.getFecha_ingreso().getTime()));
			pst.setInt(2, reserva.getParcela().getId());
			pst.setInt(3, reserva.getParcela().getId());
			pst.setDate(4, new Date(reserva.getFecha_salida().getTime()));
			pst.setInt(5, reserva.getParcela().getId());
			pst.setInt(6, reserva.getParcela().getId());
			
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				reservas.add(rellernarReserva(rs));
			}
			
			return reservas.size() > 0 ? true : false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public ArrayList<Reserva> getAllReservas() {
		String st = "SELECT * FROM reservas";
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
