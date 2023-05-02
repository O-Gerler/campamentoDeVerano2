package modeloDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modeloDTO.Monitor;

public class ModeloMonitor extends Conector{
	private Monitor monitorHeredaUsuario(int id) {
		ModeloPersonal modeloPersonal = new ModeloPersonal();
		modeloPersonal.conectar();
		
		Monitor monitor = (Monitor) modeloPersonal.getPersonal(id);
		
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
		String st = "SELECT * FROM monitores WHERE id=?";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setInt(1, id);
			
			ResultSet rs = pst.executeQuery();
			rs.next();
			
			return monitorHeredaUsuario(rs.getInt("id"));
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
				monitores.add(monitorHeredaUsuario(rs.getInt("id")));
			}
			
			return monitores;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
