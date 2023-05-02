package modeloDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modeloDTO.Tipo;

public class ModeloTipo extends Conector{
	public boolean insertarTipo(Tipo tipo) {
		String st = "INSERT INTO tipos (nombre, cantidad_personas, descripcion) VALUES ?, ? ,?";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setString(1, tipo.getNombre());
			pst.setInt(2, tipo.getCantidad_personas());
			pst.setString(3, tipo.getDescripcion());
			
			pst.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean eliminarTipo(int id) {
		String st = "DELETE FROM tipos WHERE id = ?";
		
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
	
	public boolean modificarTipo(Tipo tipo) {
		String st = "UPDATE tipos SET nombre=?, cantidad_personas=?, descripcion=? WHERE id=?";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setString(1, tipo.getNombre());
			pst.setInt(2, tipo.getCantidad_personas());
			pst.setString(3, tipo.getDescripcion());
			pst.setInt(4, tipo.getId());
			
			pst.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public Tipo getTipo(int id) {
		String st = "SELECT * FROM tipos WHERE id = ?";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setInt(1, id);
			
			ResultSet rs = pst.executeQuery();
			rs.next();
			
			Tipo tipo = rellenarTipo(rs);
			
			return tipo;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	private Tipo rellenarTipo(ResultSet rs) throws SQLException {
		Tipo tipo = new Tipo();
		
		tipo.setId(rs.getInt("id"));
		tipo.setNombre(rs.getString("nombre"));
		tipo.setCantidad_personas(rs.getInt("cantidad_personas"));
		tipo.setDescripcion(rs.getString("descripcion"));
		return tipo;
	}
	
	public ArrayList<Tipo> getAllTipos() {
		String st = "SELECT * FROM tipos";
		ArrayList<Tipo> tipos = new ArrayList<>();
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				tipos.add(rellenarTipo(rs));
			}
			
			return tipos;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
