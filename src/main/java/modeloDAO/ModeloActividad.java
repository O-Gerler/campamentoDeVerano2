package modeloDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modeloDTO.Actividad;

public class ModeloActividad extends Conector{
	/**
	 * Metodo para insertar una actividad en la BBDD
	 * @param actividad -> Es la actividad que se quiere insertar en la BBDD
	 * @return true -> En caso de que la operacion se haya realizado correctamente
	 * @return false -> En caso de que haya habido algun error
	 */
	public boolean insertarActividad(Actividad actividad) {
		String st = "INSERT INTO actividades (id_zona, nombre, cantidad_max, edad_min) VALUES (?,?,?,?)";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setInt(1, actividad.getZona().getId());
			pst.setString(2, actividad.getNombre());
			pst.setInt(3, actividad.getCantidad_max());
			pst.setInt(4, actividad.getEdad_min());
			
			pst.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	/**
	 * Metodo para eliminar una actividad en la BBDD
	 * @param id -> Es el id de la actividad que se quiere eliminar en la BBDD
	 * @return true -> En caso de que la operacion se haya realizado correctamente
	 * @return false -> En caso de que haya habido algun error
	 */
	public boolean eliminarActividad(int id) {
		String st = "DELETE FROM actividades WHERE id_actividad=?";
		
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
	 * Metodo para modificar una actividad en la BBDD
	 * @param id -> Es la actividad que se quiere modificar en la BBDD
	 * @return true -> En caso de que la operacion se haya realizado correctamente
	 * @return false -> En caso de que haya habido algun error
	 */
	public boolean modificarActividad(Actividad actividad) {
		String st = "UPDATE actividades SET id_zona=?,nombre=?,cantidad_max=?,edad_min=? WHERE id_actividad=?";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setInt(1, actividad.getZona().getId());
			pst.setString(2, actividad.getNombre());
			pst.setInt(3, actividad.getCantidad_max());
			pst.setInt(4, actividad.getEdad_min());
			pst.setInt(5, actividad.getId());
			
			pst.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * Obtener una actividad de la BBDD
	 * @param id -> Es el id de la actividad que se quiere obtener de la BBDD
	 * @return Actividad -> En caso de que la actividad exista
	 * @return null -> En caso de que no exista o de algun error
	 * @see rellenarActividades
	 */
	public Actividad getActividad(int id) {
		String st = "SELECT * FROM actividades WHERE id_actividad=?";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setInt(1, id);
			
			ResultSet rs = pst.executeQuery();
			rs.next();
			
			Actividad actividad = rellenarActividad(rs);
			
			return actividad;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * Dado el ResultSet rellena un objeto Actividad y lo devuelve
	 * @param rs -> Resultset a recorrer con la informacion de la BBDD
	 * @return -> La actividad ya rellena
	 * @throws SQLException -> En caso de no encontrar algo u otro error
	 */
	private Actividad rellenarActividad(ResultSet rs) throws SQLException {
		ModeloZona modeloZona = new ModeloZona();
		modeloZona.conectar();
		
		Actividad actividad = new Actividad();
		
		actividad.setId(rs.getInt("id_actividad"));
		actividad.setZona(modeloZona.getZona(rs.getInt("id_zona")));
		actividad.setNombre(rs.getString("nombre"));
		actividad.setCantidad_max(rs.getInt("cantidad_max"));
		actividad.setEdad_min(rs.getInt("edad_min"));
		
		modeloZona.cerrar();
		
		return actividad;
	}
	
	/**
	 * Obtiene todas las actividades de la BBDD
	 * @return -> Retorna un ArrayList de actividades de la BBDD
	 * @see rellenarActividad
	 */
	public ArrayList<Actividad> getAllActividades() {
		String st = "SELECT * FROM actividades";
		ArrayList<Actividad> actividades = new ArrayList<>();
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				actividades.add(rellenarActividad(rs));
			}
			
			return actividades;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
	