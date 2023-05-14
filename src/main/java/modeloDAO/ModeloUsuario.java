package modeloDAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modeloDTO.Usuario;

public class ModeloUsuario extends Conector{
	/**
	 * Este método inserta un nuevo usuario en la base de datos.
	 *
	 * @param usuario El objeto Usuario que se quiere insertar en la base de datos.
	 * @return Un valor booleano que indica si la inserción fue exitosa (true) o no (false).
	 */
	public boolean insertarUsuario(Usuario usuario) {

		String st = "INSERT INTO usuarios (nombre, apellidos, dni, email, contrasena, telf, fecha_nacimiento) VALUES (?,?,?,?,?,?,?)";

		try {
			PreparedStatement pst = super.connection.prepareStatement(st);

			pst.setString(1, usuario.getNombre());
			pst.setString(2, usuario.getApellido());
			pst.setString(3, usuario.getDni());
			pst.setString(4, usuario.getEmail());
			pst.setString(5, usuario.getContrasena());
			pst.setString(6, usuario.getTelefono());
			pst.setDate(7, new Date(usuario.getFechaNacimiento().getTime()));

			pst.execute();
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}
	
	/**
	 * Este método elimina un usuario de la base de datos.
	 *
	 * @param id El ID del usuario que se quiere eliminar.
	 * @return Un valor booleano que indica si la eliminación fue exitosa (true) o no (false).
	 */
	public boolean eliminarUsuario(int id) {
		
		String st = "DELETE FROM usuarios WHERE id_usuario = ?";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setInt(1, id);
			
			pst.execute();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * Este método modifica un usuario en la base de datos.
	 *
	 * @param usuario El objeto Usuario que contiene los datos actualizados.
	 * @return Un valor booleano que indica si la modificación fue exitosa (true) o no (false).
	 */
	public boolean modificarUsuario(Usuario usuario) {
		
		String st = "UPDATE usuarios SET nombre = ?, apellidos = ?, dni = ?, email = ?, contrasena = ?, telf = ?, fecha_nacimiento = ? WHERE id_usuario = ?";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setString(1, usuario.getNombre());
			pst.setString(2, usuario.getApellido());
			pst.setString(3, usuario.getDni());
			pst.setString(4, usuario.getEmail());
			pst.setString(5, usuario.getContrasena());
			pst.setString(6, usuario.getTelefono());
			pst.setDate(7, new Date(usuario.getFechaNacimiento().getTime()));
			pst.setInt(8, usuario.getId());

			pst.execute();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * Este método devuelve un objeto Usuario de la base de datos.
	 *
	 * @param id El ID del usuario que se quiere obtener.
	 * @return Un objeto Usuario con los datos del usuario especificado.
	 */
	public Usuario getUsuarios(int id) {
		String st = "SELECT * FROM usuarios WHERE id_usuario = ?";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setInt(1, id);
			
			ResultSet rs = pst.executeQuery();
			rs.next();
			
			Usuario usuario = rellenarUsuario(rs);
			
			return usuario;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * Este método devuelve un objeto Usuario de la base de datos utilizando su DNI.
	 *
	 * @param dni El DNI del usuario que se quiere obtener.
	 * @return Un objeto Usuario con los datos del usuario especificado.
	 */
	public Usuario getUsuariosViaDNI(String dni) {
		String st = "SELECT * FROM usuarios WHERE dni = ?";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setString(1, dni);
			
			ResultSet rs = pst.executeQuery();
			rs.next();
			
			Usuario usuario = rellenarUsuario(rs);
			
			return usuario;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * Este método privado toma un objeto ResultSet y devuelve un objeto Usuario.
	 *
	 * @param rs El objeto ResultSet que contiene los datos del usuario.
	 * @return Un objeto Usuario con los datos del ResultSet.
	 * @throws SQLException Si ocurre un error al acceder a los datos del ResultSet.
	 */
	private Usuario rellenarUsuario(ResultSet rs) throws SQLException {
		Usuario usuario = new Usuario();
		
		usuario.setId(rs.getInt("id_usuario"));
		usuario.setDni(rs.getString("dni"));
		usuario.setNombre(rs.getString("nombre"));
		usuario.setApellido(rs.getString("apellidos"));
		usuario.setEmail(rs.getString("email"));
		usuario.setContrasena(rs.getString("contrasena"));
		usuario.setTelefono(rs.getString("telf"));
		usuario.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
		
		ModeloUsuarioVehiculo modeloUsuarioVehiculo = new ModeloUsuarioVehiculo();
		modeloUsuarioVehiculo.conectar();
		
		usuario.setVehiculos(modeloUsuarioVehiculo.getUsuarioVehiculo(rs.getInt("id_usuario")));
		
		modeloUsuarioVehiculo.cerrar();
		
		return usuario;
	}
	
	/**
	 * Este método verifica si un usuario puede iniciar sesión con un DNI y una contraseña específicos.
	 *
	 * @param dni El DNI del usuario que se quiere verificar.
	 * @param contrasena La contraseña del usuario que se quiere verificar.
	 * @return Un valor booleano que indica si el inicio de sesión es válido (true) o no (false).
	 */
	public boolean getLogin(String dni, String contrasena) {
		String st = "SELECT * FROM usuarios WHERE dni=? and contrasena=?";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setString(1, dni);
			pst.setString(2, contrasena);
			
			ResultSet rs = pst.executeQuery();
			rs.next();
			
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * Este método devuelve una lista de usuarios que no son personal.
	 *
	 * @return Una lista de objetos Usuario que contiene todos los usuarios que no son personal.
	 */
	public ArrayList<Usuario> getUsuariosNoPersonal() {
		
		ArrayList<Usuario> usuarios = new ArrayList<>();
		String st = "SELECT * FROM usuarios WHERE id_usuario not in (SELECT id_personal FROM personal)";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				usuarios.add(rellenarUsuario(rs));
			}
			
			return usuarios;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * Este método devuelve una lista de todos los usuarios.
	 *
	 * @return Una lista de objetos Usuario que contiene todos los usuarios.
	 */
	public ArrayList<Usuario> getAllUsuarios() {
		
		ArrayList<Usuario> usuarios = new ArrayList<>();
		String st = "SELECT * FROM usuarios";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				usuarios.add(rellenarUsuario(rs));
			}
			
			return usuarios;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
