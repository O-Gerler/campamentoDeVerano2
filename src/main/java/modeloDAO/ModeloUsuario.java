package modeloDAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modeloDTO.Usuario;

public class ModeloUsuario extends Conector{
	
	public boolean insertarUsuario(Usuario usuario) {

		String st = "INSERT INTO usuarios (nombre, apellido, dni, email, contrasena, telefono, fecha_nacimiento) VALUES (?,?,?,?,?,?,?)";

		try {
			PreparedStatement pst = super.connection.prepareStatement(st);

			pst.setString(1, usuario.getNombre());
			pst.setString(2, usuario.getApellido());
			pst.setString(3, usuario.getDni());
			pst.setString(4, usuario.getEmail());
			pst.setString(5, usuario.getContrasena());
			pst.setInt(6, usuario.getTelefono());
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
		
		String st = "DELETE FROM usuarios WHERE id = ?";
		
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
		
		String st = "UPDATE usuarios SET nombre = ?, apellido = ?, dni = ?, email = ?, contrasena = ?, telefono = ?, fecha_nacimiento = ? WHERE id = ?";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setString(1, usuario.getNombre());
			pst.setString(2, usuario.getApellido());
			pst.setString(3, usuario.getDni());
			pst.setString(4, usuario.getEmail());
			pst.setString(5, usuario.getContrasena());
			pst.setInt(6, usuario.getTelefono());
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
		
		Usuario usuario = new Usuario();
		String st = "SELECT * FROM usuarios WHERE id = ?";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setInt(1, id);
			
			ResultSet rs = pst.executeQuery();
			rs.next();
			
			rellenarUsuario(usuario, rs);
			
			return usuario;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	private void rellenarUsuario(Usuario usuario, ResultSet rs) throws SQLException {
		usuario.setId(rs.getInt("id"));
		usuario.setNombre(rs.getString("nombre"));
		usuario.setApellido(rs.getString("apellido"));
		usuario.setEmail(rs.getString("email"));
		usuario.setContrasena(rs.getString("email"));
		usuario.setTelefono(rs.getInt("telefono"));
		usuario.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
	}
	
	public ArrayList<Usuario> getAllUsuarios() {
		
		ArrayList<Usuario> usuarios = new ArrayList<>();
		String st = "SELECT * FROM clientes";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				Usuario usuario = new Usuario();
				rellenarUsuario(new Usuario(), rs);
				usuarios.add(usuario);
			}
			
			return usuarios;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
