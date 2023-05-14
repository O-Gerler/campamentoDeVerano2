package modeloDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modeloDTO.Grupo;

public class ModeloGrupo extends Conector{
	/**
	 * Inserta un nuevo grupo en la base de datos con el monitor especificado.
	 * 
	 * @param id_monitor el ID del monitor asignado al grupo.
	 * @return true si se insertó el grupo correctamente, false en caso contrario.
	 */
	public boolean insertarGrupo(int id_monitor) {
		String st = "INSERT INTO grupos (id_monitor) VALUES (?)";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setInt(1, id_monitor);
			
			pst.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * Elimina un grupo de la base de datos.
	 * 
	 * @param id_grupo el id del grupo a eliminar
	 * @return true si se eliminó correctamente, false en caso contrario
	 */
	public boolean eliminarGrupo(int id_grupo) {
		String st = "DELETE FROM grupos WHERE id_grupo=?";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setInt(1, id_grupo);
			
			pst.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * Modifica un grupo en la base de datos.
	 * @param grupo El grupo a modificar.
	 * @return true si la modificación fue exitosa, false en caso contrario.
	 */
	public boolean modificarGrupo(Grupo grupo) {
		String st = "UPDATE grupos SET id_monitor=? WHERE id_grupo=?";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setInt(1, grupo.getMonitor().getId());
			pst.setInt(2, grupo.getId());
			
			pst.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * Devuelve el objeto Grupo correspondiente al id especificado.
	 * 
	 * @param id El id del grupo a buscar.
	 * @return El objeto Grupo correspondiente al id especificado, o null si no se encuentra.
	 */
	public Grupo getGrupo(int id) {
		String st = "SELECT * FROM grupos WHERE id_grupo=?";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setInt(1, id);
			
			ResultSet rs = pst.executeQuery();
			rs.next();
			
			Grupo grupo = rellenarGrupo(rs);
			
			return grupo;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * Rellena un objeto Grupo a partir de los datos obtenidos de un ResultSet.
	 *
	 * @param rs ResultSet con los datos del grupo.
	 * @return Grupo objeto Grupo rellenado con los datos obtenidos del ResultSet.
	 * @throws SQLException si ocurre alguna excepción al acceder a los datos del ResultSet.
	 */
	private Grupo rellenarGrupo(ResultSet rs) throws SQLException {
		Grupo grupo = new Grupo();
		
		grupo.setId(rs.getInt("id_grupo"));
		
		ModeloMonitor modeloMonitor = new ModeloMonitor();
		modeloMonitor.conectar();
		
		grupo.setMonitor(modeloMonitor.getMonitor(rs.getInt("id_monitor")));
		
		modeloMonitor.cerrar();
		return grupo;
	}
	
	
	/**
	 * Obtiene todos los grupos que no tienen asignada ninguna parcela.
	 * 
	 * @return ArrayList de objetos Grupo sin parcela asignada.
	 *         Retorna null si ocurre una excepción de tipo SQLException.
	 */
	public ArrayList<Grupo> getGruposSinParcela() {
		String st = "SELECT * FROM grupos WHERE id_grupo not in (SELECT id_grupo FROM parcelas)";
		ArrayList<Grupo> grupos = new ArrayList<>();
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				grupos.add(rellenarGrupo(rs));
			}
			
			return grupos;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * Retorna todos los grupos de la base de datos.
	 *
	 * @return un ArrayList con todos los grupos de la base de datos.
	 */
	public ArrayList<Grupo> getAllGrupos() {
		String st = "SELECT * FROM grupos";
		ArrayList<Grupo> grupos = new ArrayList<>();
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				grupos.add(rellenarGrupo(rs));
			}
			
			return grupos;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
