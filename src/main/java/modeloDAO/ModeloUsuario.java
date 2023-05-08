package modeloDAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modeloDTO.Usuario;

public class ModeloUsuario extends Conector{
	
	public boolean insertarUsuario(Usuario usuario) {

		String st = "INSERT INTO usuario (nombre, apellidos, dni, email, contrasena, telf, fecha_nacimiento) VALUES (?,?,?,?,?,?,?)";

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
	
	public boolean eliminarUsuario(int id) {
		
		String st = "DELETE FROM usuario WHERE id_usuario = ?";
		
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
	
	public boolean modificarUsuario(Usuario usuario) {
		
		String st = "UPDATE usuario SET nombre = ?, apellidos = ?, dni = ?, email = ?, contrasena = ?, telf = ?, fecha_nacimiento = ? WHERE id_usuario = ?";
		
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
	
	public Usuario getUsuarios(int id) {
		String st = "SELECT * FROM usuario WHERE id_usuario = ?";
		
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
	
	public Usuario getUsuariosViaDNI(String dni) {
		String st = "SELECT * FROM usuario WHERE DNI = ?";
		
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
	
	public boolean getLogin(String dni, String contrasena) {
		String st = "SELECT * FROM usuario WHERE dni=? and contrasena=?";
		
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
	
	public ArrayList<Usuario> getAllUsuarios() {
		
		ArrayList<Usuario> usuarios = new ArrayList<>();
		String st = "SELECT * FROM usuario";
		
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
