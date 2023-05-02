package modeloDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modeloDTO.Zona;

public class ModeloZona extends Conector{
	public boolean insertarZona(Zona zona) {
		String st = "INSERT INTO zonas(nombre) VALUES ?";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setString(1, zona.getNombre());
			
			pst.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean eliminarZona(int id) {
		String st = "DELETE FROM zonas WHERE id=?";
		
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
	
	public boolean modificarZona(Zona zona) {
		String st = "UPDATE zonas SET nombre=? WHERE id_zona=?";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setString(1, zona.getNombre());
			
			pst.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public Zona getZona(int id) {
		String st = "SELECT * FROM zonas WHERE id_zona=?";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setInt(1, id);
			
			ResultSet rs = pst.executeQuery();
			rs.next();
			
			Zona zona = rellenarZona(rs);
			
			return zona;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	private Zona rellenarZona(ResultSet rs) throws SQLException {
		Zona zona = new Zona();
		
		zona.setId(rs.getInt("id_zona"));
		zona.setNombre(rs.getString("nombre"));
		return zona;
	}
	
	public ArrayList<Zona> getAllZonas() {
		String st = "SELECT * FROM zonas";
		ArrayList<Zona> zonas = new ArrayList<>();
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				zonas.add(rellenarZona(rs));
			}
			
			return zonas;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
