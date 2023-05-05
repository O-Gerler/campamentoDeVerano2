package modeloDAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modeloDTO.Cliente;
import modeloDTO.Personal;
import modeloDTO.Usuario;

public class ModeloPersonal extends Conector{
	private Personal personalHeredaUsuario(int id) {
		ModeloUsuario modeloUsuario = new ModeloUsuario();
		modeloUsuario.conectar();
		
		Usuario usuario = modeloUsuario.getUsuarios(id);
		
		Personal personal = new Personal();
		
		personal.setId(usuario.getId());
		personal.setNombre(usuario.getNombre());
		personal.setApellido(usuario.getApellido());
		personal.setDni(usuario.getDni());
		personal.setContrasena(usuario.getContrasena());
		personal.setEmail(usuario.getEmail());
		personal.setFechaNacimiento(usuario.getFechaNacimiento());
		personal.setTelefono(usuario.getTelefono());
		
		return personal;
	}
	
	public boolean insertarPersonal(Personal personal) {
		String st = "INSERT INTO personal VALUES ?,?,?";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setInt(1, personal.getId());
			pst.setDate(2, new Date(personal.getFechaIngreso().getTime()));
			pst.setInt(3, personal.getDirector());
			
			pst.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean eliminarPersonal(int id) {
		String st = "DELETE FROM personal WHERE id=?";
		
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
	
	public boolean modificarPersonal(Personal personal) {
		String st = "UPDATE personal SET fech_ingreso=?, dirige=? WHERE id=?";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setDate(1, new Date(personal.getFechaIngreso().getTime()));
			pst.setInt(2, personal.getDirector());
			pst.setInt(3, personal.getId());
			
			pst.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public Personal getPersonal(int id) {
		String st = "SELECT * FROM personal WHERE id_personal=?";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setInt(1, id);
			
			ResultSet rs = pst.executeQuery();
			rs.next();
			
			Personal personal = rellenarPersonal(rs);
			
			return personal;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	private Personal rellenarPersonal(ResultSet rs) throws SQLException {
		Personal personal = personalHeredaUsuario(rs.getInt("id_personal"));
		
		personal.setFechaIngreso(rs.getDate("fecha_ingreso"));
		personal.setDirector(rs.getInt("dirige"));
		return personal;
	}
	
	public ArrayList<Personal> getAllPersonal() {
		String st = "SELECT * FROM personal";
		ArrayList<Personal> personals = new ArrayList<>();
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				personals.add(rellenarPersonal(rs));
			}
			
			return personals;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
