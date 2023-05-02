package modeloDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modeloDTO.ClienteMascota;

public class ModeloClienteMascota extends Conector{
	public boolean insertarClienteMascota(ClienteMascota clienteMascota) {
		String st = "INSERT INTO cliente_mascota VALUES ?, ?";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setInt(1, clienteMascota.getCliente().getId());
			pst.setInt(2, clienteMascota.getMascota().getId());
			
			pst.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean eliminarClienteMascota(ClienteMascota clienteMascota) {
		String st = "DELETE FROM cliente_mascota WHERE id_cliente=? and id_mascota=?";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setInt(1, clienteMascota.getCliente().getId());
			pst.setInt(2, clienteMascota.getMascota().getId());
			
			pst.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public ClienteMascota getClienteMascota(int id_cliente) {
		String st = "SELECT * FROM cliente_mascota WHERE id_cliente=?";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setInt(1, id_cliente);
			
			ResultSet rs = pst.executeQuery();
			rs.next();
			
			ClienteMascota clienteMascota = rellenarClienteMascota(rs);
			
			return clienteMascota;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	private ClienteMascota rellenarClienteMascota(ResultSet rs) throws SQLException {
		ModeloCliente modeloCliente = new ModeloCliente();
		ModeloMascota modeloMascota = new ModeloMascota();
		
		modeloCliente.conectar();
		modeloMascota.conectar();
		
		ClienteMascota clienteMascota = new ClienteMascota();
		
		clienteMascota.setCliente(modeloCliente.getCliente(rs.getInt("id_cliente")));
		clienteMascota.setMascota(modeloMascota.getMascota(rs.getInt("id_mascota")));
		
		modeloCliente.cerrar();
		modeloMascota.cerrar();
		return clienteMascota;
	}
	
	public ArrayList<ClienteMascota> getAllClienteMascotas() {
		String st = "SELECT * FROM cliente_mascota";
		ArrayList<ClienteMascota> clienteMascotas = new ArrayList<>();
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				clienteMascotas.add(rellenarClienteMascota(rs));
			}
			
			return clienteMascotas;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
