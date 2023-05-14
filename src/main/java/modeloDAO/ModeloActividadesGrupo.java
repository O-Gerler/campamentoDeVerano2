package modeloDAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modeloDTO.ActividadesPorGrupo;

public class ModeloActividadesGrupo extends Conector{
	/**
	 * Metodo para insertar una actividad por grupo en la BBDD
	 * @param actividadesPorGrupo -> Es la actividad por grupo que se quiere insertar en la BBDD
	 * @return true -> En caso de que la operacion se haya realizado correctamente
	 * @return false -> En caso de que haya habido algun error
	 */
	public boolean insertarActividadGrupo(ActividadesPorGrupo actividadesPorGrupo) {
		String st = "INSERT INTO actividades_grupos VALUES (?,?,?,?)";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setInt(1, actividadesPorGrupo.getActividad().getId());
			pst.setInt(2, actividadesPorGrupo.getGrupo().getId());
			pst.setDate(3, new Date(actividadesPorGrupo.getFecha().getTime()));
			pst.setString(4, actividadesPorGrupo.getHora());
			
			pst.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * Metodo para eliminar una actividad por grupo de la BBDD
	 * @param id_actividad -> id de la actividad para eliminar
	 * @param id_grupo -> id del grupo para eliminar
	 * @param fecha -> fecha para eliminar
	 * @param hora -> hora para eliminar
	 * @return true -> En caso de que la operacion se haya realizado correctamente
	 * @return false -> En caso de que haya habido algun error
	 */
	public boolean eliminarActividadGrupo(int id_actividad, int id_grupo, java.util.Date fecha, String hora) {
		String st = "DELETE FROM actividades_grupos WHERE id_actividad=? and id_grupo=? and fecha=? and hora=?";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setInt(1, id_actividad);
			pst.setInt(2, id_grupo);
			pst.setDate(3, new Date(fecha.getTime()));
			pst.setString(4, hora);
			
			pst.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * Recupera una actividad por grupo de la base de datos según los parámetros proporcionados.
	 * 
	 * @param actividadesPorGrupo el objeto ActividadesPorGrupo con la información de la actividad y el grupo
	 * @return el objeto ActividadesPorGrupo correspondiente a la búsqueda, o null si no se encuentra ninguna coincidencia
	 * @throws SQLException si ocurre algún error al realizar la consulta SQL
	 * 
	 * @see ActividadesPorGrupo
	 */
	public ActividadesPorGrupo getActividadesPorGrupo(ActividadesPorGrupo actividadesPorGrupo) {
		String st = "SELECT * FROM actividades_grupos WHERE id_actividad=?, id_grupo=?, fecha=?, hora=?";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setInt(1, actividadesPorGrupo.getActividad().getId());
			pst.setInt(2, actividadesPorGrupo.getGrupo().getId());
			pst.setDate(3, new Date(actividadesPorGrupo.getFecha().getTime()));
			pst.setString(4, actividadesPorGrupo.getHora());
			
			ResultSet rs = pst.executeQuery();
			rs.next();
			
			ActividadesPorGrupo actividadesPorGrupoBBDD = rellenarActividadGrupo(rs);
			
			return actividadesPorGrupoBBDD;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	Devuelve una instancia de ActividadesPorGrupo que coincida con la actividad, fecha y hora especificadas
	en el parámetro actividadesPorGrupo.
	@param actividadesPorGrupo un objeto ActividadesPorGrupo que contiene la actividad, fecha y hora a buscar
	@return un objeto ActividadesPorGrupo que coincide con los criterios de búsqueda, o null si no se encuentra ninguna coincidencia
	@throws SQLException si hay un problema al ejecutar la consulta SQL
	*/
	public ActividadesPorGrupo getActividadesPorGrupoRepetida(ActividadesPorGrupo actividadesPorGrupo) {
		String st = "SELECT * FROM actividades_grupos WHERE id_actividad=? and fecha=? and hora=?";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setInt(1, actividadesPorGrupo.getActividad().getId());
			pst.setDate(2, new Date(actividadesPorGrupo.getFecha().getTime()));
			pst.setString(3, actividadesPorGrupo.getHora());
			
			ResultSet rs = pst.executeQuery();
			rs.next();
			
			ActividadesPorGrupo actividadesPorGrupoBBDD = rellenarActividadGrupo(rs);
			
			return actividadesPorGrupoBBDD;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * Devuelve una lista de todas las actividades que pertenecen a un grupo del que el monitor con el ID proporcionado es responsable.
	 *
	 * @param id el ID del monitor cuyas actividades se buscan
	 * @return una lista de objetos ActividadesPorGrupo que pertenecen a uno de los grupos del monitor con el ID proporcionado
	 */

	public ArrayList<ActividadesPorGrupo> getActividadesViaMonitor(int id) {
		String st = "SELECT * FROM actividades_grupos WHERE id_grupo = (SELECT id_grupo FROM grupos WHERE id_monitor=?)";
		ArrayList<ActividadesPorGrupo> actividadesPorGrupos = new ArrayList<>();
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setInt(1, id);
			
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				actividadesPorGrupos.add(rellenarActividadGrupo(rs));
			}
			
			return actividadesPorGrupos;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}	

	/**
	 * Rellena un objeto ActividadesPorGrupo a partir de un ResultSet.
	 *
	 * @param rs ResultSet con los datos de la actividad de grupo
	 * @return objeto ActividadesPorGrupo con los datos obtenidos del ResultSet
	 * @throws SQLException si hay un error en el acceso a la base de datos
	 */
	private ActividadesPorGrupo rellenarActividadGrupo(ResultSet rs) throws SQLException {
		ActividadesPorGrupo actividadesPorGrupoBBDD = new ActividadesPorGrupo();
		
		ModeloActividad modeloActividad = new ModeloActividad();
		ModeloGrupo modeloGrupo = new ModeloGrupo();
		
		modeloActividad.conectar();
		modeloGrupo.conectar();
		
		actividadesPorGrupoBBDD.setActividad(modeloActividad.getActividad(rs.getInt("id_actividad")));
		actividadesPorGrupoBBDD.setGrupo(modeloGrupo.getGrupo(rs.getInt("id_grupo")));
		actividadesPorGrupoBBDD.setFecha(rs.getDate("fecha"));
		actividadesPorGrupoBBDD.setHora(rs.getString("hora"));
		
		modeloActividad.cerrar();
		modeloGrupo.cerrar();
		return actividadesPorGrupoBBDD;
	}
	
	/**
	 * Obtiene todas las actividades por grupo almacenadas en la base de datos.
	 * 
	 * @return un ArrayList de ActividadesPorGrupo con todas las actividades por grupo almacenadas en la base de datos, 
	 *         o null si se produce un error en la consulta.
	 */

	public ArrayList<ActividadesPorGrupo> getAllActividadesPorGrupo() {
		String st = "SELECT * FROM actividades_grupos";
		ArrayList<ActividadesPorGrupo> actividadesPorGrupos = new ArrayList<>();
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				actividadesPorGrupos.add(rellenarActividadGrupo(rs));
			}
			
			return actividadesPorGrupos;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
