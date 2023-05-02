package modeloDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modeloDTO.Actividad;

public class ModeloActividad extends Conector{
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
	
	public boolean eliminarActividad(int id) {
		String st = "DELETE FROM actividades WHERE id=?";
		
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
	
	public boolean modificarActividad(Actividad actividad) {
		String st = "UPDATE actividades SET id_zona=?,nombre=?,cantidad_max=?,edad_min=? WHERE id=?";
		
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
	
	public Actividad getActividad(int id) {
		String st = "SELECT * FROM actividades WHERE id=?";
		
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

	private Actividad rellenarActividad(ResultSet rs) throws SQLException {
		ModeloZona modeloZona = new ModeloZona();
		modeloZona.conectar();
		
		Actividad actividad = new Actividad();
		
		actividad.setId(rs.getInt("id"));
		actividad.setZona(modeloZona.getZona(rs.getInt("id_zona")));
		actividad.setNombre(rs.getString("nombre"));
		actividad.setCantidad_max(rs.getInt("cantidad_max"));
		actividad.setEdad_min(rs.getInt("edad_min"));
		return actividad;
	}
	
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
	