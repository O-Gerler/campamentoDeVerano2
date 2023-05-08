package modeloDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modeloDTO.Personal;
import modeloDTO.Recepcion;

public class ModeloRecepcion extends Conector{
	private Recepcion recepcionHeredaUsuario(int id) {
		ModeloPersonal modeloPersonal = new ModeloPersonal();
		modeloPersonal.conectar();
		
		Personal personal = modeloPersonal.getPersonal(id);
		
		Recepcion recepcion = new Recepcion();

		recepcion.setId(personal.getId());
		recepcion.setNombre(personal.getNombre());
		recepcion.setApellido(personal.getApellido());
		recepcion.setDni(personal.getDni());
		recepcion.setContrasena(personal.getContrasena());
		recepcion.setEmail(personal.getEmail());
		recepcion.setFechaNacimiento(personal.getFechaNacimiento());
		recepcion.setTelefono(personal.getTelefono());
		recepcion.setVehiculos(personal.getVehiculos());
		recepcion.setDirector(personal.getDirector());
		recepcion.setFechaIngreso(personal.getFechaIngreso());
		
		return recepcion;
	}
	
	public boolean insertarRecepcion(Recepcion recepcionista) {
		String st = "INSERT INTO recepcion VALUES (?)";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setInt(1, recepcionista.getId());
			
			pst.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean eliminarRecepcion(int id) {
		String st = "DELETE FROM recepcion WHERE id_recepcion=?";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setInt(1,id);
			
			pst.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public Recepcion getRecepcion(int id) {
		String st = "SELECT * FROM recepcion WHERE id_recepcion=?";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setInt(1, id);
			
			ResultSet rs = pst.executeQuery();
			rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
