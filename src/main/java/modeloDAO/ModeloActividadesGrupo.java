package modeloDAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modeloDTO.ActividadesPorGrupo;

public class ModeloActividadesGrupo extends Conector{
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
