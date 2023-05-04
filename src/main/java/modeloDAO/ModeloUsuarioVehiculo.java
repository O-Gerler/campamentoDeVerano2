package modeloDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modeloDTO.UsuarioVehiculo;

public class ModeloUsuarioVehiculo extends Conector{
	public boolean insertarUsuarioVehiculo(UsuarioVehiculo usuarioVehiculo) {
		String st = "INSERT INTO usuario_vehiculo VALUES ?,?";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setInt(1, usuarioVehiculo.getUsuario().getId());
			pst.setInt(2, usuarioVehiculo.getVehiculo().getId());
			
			pst.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean eliminarUsuarioVehiculo(UsuarioVehiculo usuarioVehiculo) {
		String st = "DELETE FROM usuario_vehiculo WHERE id_usuario=? and id_vehiculo=?";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);

			pst.setInt(1, usuarioVehiculo.getUsuario().getId());
			pst.setInt(2, usuarioVehiculo.getVehiculo().getId());
			
			pst.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public UsuarioVehiculo getUsuarioVehiculo(int id) {
		String st = "SELECT * FROM usuario_vehiculo WHERE id_usuario=?";
		ModeloUsuario modeloUsuario = new ModeloUsuario();
		ModeloVehiculos modeloVehiculos = new ModeloVehiculos();
		
		modeloUsuario.conectar();
		modeloVehiculos.conectar();
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setInt(1, id);
			
			ResultSet rs = pst.executeQuery();
			
			return rellenarUsuarioVehiculo(modeloUsuario, modeloVehiculos, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public ArrayList<UsuarioVehiculo> getAllUsuarioVehiculoIDUsuario() {
		String st = "SELECT * FROM usuario_vehiculo";
		ArrayList<UsuarioVehiculo> usuarioVehiculos = new ArrayList<>();
		ModeloUsuario modeloUsuario = new ModeloUsuario();
		ModeloVehiculos modeloVehiculos = new ModeloVehiculos();
		
		modeloUsuario.conectar();
		modeloVehiculos.conectar();
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				usuarioVehiculos.add(rellenarUsuarioVehiculo(modeloUsuario, modeloVehiculos, rs));
			}
			
			return usuarioVehiculos;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	private UsuarioVehiculo rellenarUsuarioVehiculo(ModeloUsuario modeloUsuario, ModeloVehiculos modeloVehiculos,
			ResultSet rs) throws SQLException {
		UsuarioVehiculo usuarioVehiculo = new UsuarioVehiculo();
		
		usuarioVehiculo.setUsuario(modeloUsuario.getUsuarios(rs.getInt("id_usuario")));
		usuarioVehiculo.setVehiculo(modeloVehiculos.getVehiculo(rs.getInt("id_vehiculo")));
		return usuarioVehiculo;
	}
}
