package modeloDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modeloDTO.Monitor;
import modeloDTO.Personal;

public class ModeloMonitor extends Conector{
	private Monitor monitorHeredaUsuario(int id) {
		ModeloPersonal modeloPersonal = new ModeloPersonal();
		modeloPersonal.conectar();
		
		Personal personal = modeloPersonal.getPersonal(id);
		
		Monitor monitor = new Monitor();

		monitor.setId(personal.getId());
		monitor.setNombre(personal.getNombre());
		monitor.setApellido(personal.getApellido());
		monitor.setDni(personal.getDni());
		monitor.setContrasena(personal.getContrasena());
		monitor.setEmail(personal.getEmail());
		monitor.setFechaNacimiento(personal.getFechaNacimiento());
		monitor.setTelefono(personal.getTelefono());
		monitor.setVehiculos(personal.getVehiculos());
		monitor.setDirector(personal.getDirector());
		monitor.setFechaIngreso(personal.getFechaIngreso());
		
		return monitor;
	}
	
	public boolean insertarMonitor(int id) {
		Monitor monitor = monitorHeredaUsuario(id);
		
		if (monitor == null) {
			return false;
		}
		
		String st = "INSERT INTO monitor VALUES ?";
		
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
	
	public boolean eliminarMonitor(int id) {
		String st = "DELETE FROM monitores WHERE id=?";
		
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
	
	//NO SE PUEDE MODIFICAR MONITOR, TENDRIAMOS QUE MODIFICAR USUARIO
	
	public Monitor getMonitor(int id) {
		String st = "SELECT * FROM monitores WHERE id_monitor=?";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setInt(1, id);
			
			ResultSet rs = pst.executeQuery();
			rs.next();
			
			return monitorHeredaUsuario(rs.getInt("id_monitor"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public ArrayList<Monitor> getAllMonitor() {
		String st = "SELECT * FROM monitores";
		ArrayList<Monitor> monitores = new ArrayList<>();
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				monitores.add(monitorHeredaUsuario(rs.getInt("id_monitor")));
			}
			
			return monitores;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
