package modeloDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modeloDTO.UsuarioVehiculo;
import modeloDTO.Vehiculo;

public class ModeloUsuarioVehiculo extends Conector{
	/**
	 * Este método inserta una relación entre un usuario y un vehículo en la base de datos.
	 *
	 * @param usuarioVehiculo El objeto UsuarioVehiculo que se quiere insertar en la base de datos.
	 * @return Un valor booleano que indica si la inserción fue exitosa (true) o no (false).
	 */
	public boolean insertarUsuarioVehiculo(UsuarioVehiculo usuarioVehiculo) {
		String st = "INSERT INTO usuarios_vehiculos VALUES (?,?)";
		
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
	
	/**
	 * Elimina una relación entre un usuario y un vehículo en la base de datos.
	 *
	 * @param id_usuario el ID del usuario
	 * @param id_vehiculo el ID del vehículo
	 * @return verdadero si la eliminación fue exitosa, falso en caso contrario
	 */
	public boolean eliminarUsuarioVehiculo(int id_usuario, int id_vehiculo) {
		String st = "DELETE FROM usuarios_vehiculos WHERE id_usuario=? and id_vehiculo=?";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);

			pst.setInt(1, id_usuario);
			pst.setInt(2, id_vehiculo);
			
			pst.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * Obtiene una lista de vehículos asociados a un usuario en la base de datos.
	 *
	 * @param id el ID del usuario
	 * @return una lista de objetos Vehiculo asociados al usuario con el ID especificado
	 */
	public ArrayList<Vehiculo> getUsuarioVehiculo(int id) {
		String st = "SELECT * FROM usuarios_vehiculos WHERE id_usuario=?";
		ArrayList<Vehiculo> vehiculos = new ArrayList<>();
		ModeloUsuario modeloUsuario = new ModeloUsuario();
		ModeloVehiculos modeloVehiculos = new ModeloVehiculos();
		
		modeloUsuario.conectar();
		modeloVehiculos.conectar();
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setInt(1, id);
			
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				vehiculos.add(rellenarUsuarioVehiculo(modeloUsuario, modeloVehiculos, rs).getVehiculo());
			}
			
			modeloUsuario.cerrar();
			modeloVehiculos.cerrar();
			
			return vehiculos;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		modeloUsuario.cerrar();
		modeloVehiculos.cerrar();
		
		return null;
	}
	
	/**
	 * Obtiene una lista de todas las relaciones entre usuarios y vehículos en la base de datos.
	 *
	 * @return una lista de objetos UsuarioVehiculo que representan todas las relaciones entre usuarios y vehículos en la base de datos
	 */
	public ArrayList<UsuarioVehiculo> getAllUsuarioVehiculo() {
		String st = "SELECT * FROM usuarios_vehiculos";
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
			
			modeloUsuario.cerrar();
			modeloVehiculos.cerrar();
			
			return usuarioVehiculos;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		modeloUsuario.cerrar();
		modeloVehiculos.cerrar();
		
		return null;
	}
	
	/**
	 * Obtiene una lista de todas las relaciones entre usuarios y vehículos en la base de datos, incluyendo información detallada sobre los usuarios.
	 *
	 * @return una lista de objetos UsuarioVehiculo que representan todas las relaciones entre usuarios y vehículos en la base de datos, con información detallada sobre los usuarios
	 */
	public ArrayList<UsuarioVehiculo> getAllUsuarioVehiculoConUsuario() {
		String st = "SELECT * FROM usuarios_vehiculos";
		ArrayList<UsuarioVehiculo> usuarioVehiculos = new ArrayList<>();
		ModeloUsuario modeloUsuario = new ModeloUsuario();
		ModeloVehiculos modeloVehiculos = new ModeloVehiculos();
		
		modeloUsuario.conectar();
		modeloVehiculos.conectar();
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				usuarioVehiculos.add(rellenarUsuarioVehiculoConUsuario(modeloUsuario, modeloVehiculos, rs));
			}
			
			return usuarioVehiculos;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * Rellena un objeto UsuarioVehiculo con información de un ResultSet.
	 *
	 * @param modeloUsuario un objeto ModeloUsuario para obtener información sobre el usuario
	 * @param modeloVehiculos un objeto ModeloVehiculos para obtener información sobre el vehículo
	 * @param rs un ResultSet que contiene información sobre la relación entre el usuario y el vehículo
	 * @return un objeto UsuarioVehiculo rellenado con información del ResultSet
	 * @throws SQLException si ocurre un error al acceder al ResultSet
	 */
	private UsuarioVehiculo rellenarUsuarioVehiculo(ModeloUsuario modeloUsuario, ModeloVehiculos modeloVehiculos,
			ResultSet rs) throws SQLException {
		UsuarioVehiculo usuarioVehiculo = new UsuarioVehiculo();
		
		usuarioVehiculo.setVehiculo(modeloVehiculos.getVehiculo(rs.getInt("id_vehiculo")));
		return usuarioVehiculo;
	}
	
	/**
	 * Rellena un objeto UsuarioVehiculo con información detallada sobre el usuario y el vehículo a partir de un ResultSet.
	 *
	 * @param modeloUsuario un objeto ModeloUsuario para obtener información detallada sobre el usuario
	 * @param modeloVehiculos un objeto ModeloVehiculos para obtener información detallada sobre el vehículo
	 * @param rs un ResultSet que contiene información sobre la relación entre el usuario y el vehículo
	 * @return un objeto UsuarioVehiculo rellenado con información detallada sobre el usuario y el vehículo a partir del ResultSet
	 * @throws SQLException si ocurre un error al acceder al ResultSet
	 */
	private UsuarioVehiculo rellenarUsuarioVehiculoConUsuario(ModeloUsuario modeloUsuario, ModeloVehiculos modeloVehiculos,
			ResultSet rs) throws SQLException {
		UsuarioVehiculo usuarioVehiculo = new UsuarioVehiculo();
		
		usuarioVehiculo.setUsuario(modeloUsuario.getUsuarios(rs.getInt("id_usuario")));
		usuarioVehiculo.setVehiculo(modeloVehiculos.getVehiculo(rs.getInt("id_vehiculo")));
		return usuarioVehiculo;
	}
}
