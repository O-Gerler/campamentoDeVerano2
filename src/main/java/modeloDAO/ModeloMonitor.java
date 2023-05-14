package modeloDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modeloDTO.Monitor;
import modeloDTO.Personal;

public class ModeloMonitor extends Conector{
	/**
	 * Este método crea un objeto Monitor a partir de un objeto Personal con el mismo id.
	 * @param id El id del objeto Personal del cual se quiere crear un objeto Monitor.
	 * @return Un objeto Monitor con los mismos datos que el objeto Personal con el id especificado.
	 */
	private Monitor monitorHeredaUsuario(int id) {
		ModeloPersonal modeloPersonal = new ModeloPersonal();
		modeloPersonal.conectar();
		
		Personal personal = modeloPersonal.getPersonal(id);
		
		modeloPersonal.cerrar();
		
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
	
	/**
	 * Este método inserta un nuevo Monitor en la base de datos.
	 * @param id El id del Monitor que se quiere insertar.
	 * @return true si la inserción fue exitosa, false en caso contrario.
	 */
	public boolean insertarMonitor(int id) {
		String st = "INSERT INTO monitores VALUES (?)";
		
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
	 * Este método elimina un Monitor de la base de datos.
	 * @param id El id del Monitor que se quiere eliminar.
	 * @return true si la eliminación fue exitosa, false en caso contrario.
	 */
	public boolean eliminarMonitor(int id) {
		String st = "DELETE FROM monitores WHERE id_monitor=?";
		
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
	 * Este método obtiene un objeto Monitor a partir de su id.
	 * @param id El id del Monitor que se quiere obtener.
	 * @return Un objeto Monitor con los datos del Monitor con el id especificado, o null si no se encuentra en la base de datos.
	 */
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
	
	/**
	 * Este método obtiene una lista de Monitores que no están asignados a ningún grupo.
	 * @return Una lista de objetos Monitor que no están asignados a ningún grupo.
	 */
	public ArrayList<Monitor> getMonitoresSinGrupo() {
		String st = "SELECT * FROM monitores WHERE id_monitor not in (SELECT id_monitor FROM grupos)";
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
	
	/**
	 * Este método obtiene una lista de todos los Monitores en la base de datos.
	 * @return Una lista de objetos Monitor con los datos de todos los Monitores en la base de datos.
	 */
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
