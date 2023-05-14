package modeloDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modeloDTO.Personal;
import modeloDTO.Recepcion;

public class ModeloRecepcion extends Conector{
	/**
	 * Crea un objeto Recepcion a partir de un objeto Personal.
	 *
	 * @param id el valor de la columna id_personal del objeto Personal
	 * @return un objeto Recepcion con los mismos datos que el objeto Personal
	 */
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
	
	/**
	 * Inserta una nueva fila en la tabla recepcion en la base de datos.
	 *
	 * @param id_recepcion el valor de la columna id_recepcion de la nueva fila
	 * @return true si la inserción se realiza correctamente, false en caso contrario
	 */
	public boolean insertarRecepcion(int id_recepcion) {
		String st = "INSERT INTO recepcion VALUES (?)";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setInt(1, id_recepcion);
			
			pst.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * Elimina una fila de la tabla recepcion en la base de datos.
	 *
	 * @param id el valor de la columna id_recepcion de la fila a eliminar
	 * @return true si la eliminación se realiza correctamente, false en caso contrario
	 */
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
	
	/**
	 * Recupera una fila de la tabla recepcion en la base de datos.
	 *
	 * @param id el valor de la columna id_recepcion de la fila a recuperar
	 * @return un objeto Recepcion que representa la fila recuperada, o null si no se encuentra ninguna fila
	 */
	public Recepcion getRecepcion(int id) {
		String st = "SELECT * FROM recepcion WHERE id_recepcion=?";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setInt(1, id);
			
			ResultSet rs = pst.executeQuery();
			rs.next();
			
			return recepcionHeredaUsuario(rs.getInt("id_recepcion"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * Recupera una lista de todos los objetos Recepcion en la tabla recepcion de la base de datos.
	 *
	 * @return una lista de todos los objetos Recepcion en la tabla recepcion
	 */
	public ArrayList<Recepcion> getAllRecepcion() {
		String st = "SELECT * FROM recepcion";
		ArrayList<Recepcion> recepcions = new ArrayList<>();
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				recepcions.add(recepcionHeredaUsuario(rs.getInt("id_recepcion")));
			}
			
			return recepcions;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
