package modeloDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modeloDTO.Limpieza;

public class ModeloLimpieza extends Conector{
	private Limpieza limpiezaHeredaPersonal(int id) {
		ModeloPersonal modeloPersonal = new ModeloPersonal();
		modeloPersonal.conectar();
		
		Limpieza limpieza = (Limpieza) modeloPersonal.getPersonal(id);
		
		return limpieza;
	}
	
	public boolean insertarLimpieza(int id) {
		Limpieza limpieza = limpiezaHeredaPersonal(id);
		
		if (limpieza == null) {
			return false;
		}
		
		String st = "INSERT INTO limpieza VALUES ?,?";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setInt(1, limpieza.getId());
			pst.setInt(2, limpieza.getZona().getId());
			
			pst.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean eliminarLimpieza(int id) {
		String st = "DELETE FROM limpieza WHERE id=?";
		
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
	
	public boolean modificarLimpieza(Limpieza limpieza) {
		String st = "UPDATE FROM limpieza SET id_zona=? WHERE id=?";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setInt(1,limpieza.getZona().getId());
			pst.setInt(2, limpieza.getId());
			
			pst.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public Limpieza getLimpieza(int id) {
		String st = "SELECT * FROM limpieza WHERE id=?";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setInt(1, id);
			
			ResultSet rs = pst.executeQuery();
			rs.next();
			
			Limpieza limpieza = rellenarLimpieza(rs);
			
			return limpieza;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	private Limpieza rellenarLimpieza(ResultSet rs) throws SQLException {
		Limpieza limpieza = limpiezaHeredaPersonal(rs.getInt("id"));
		
		ModeloZona modeloZona = new ModeloZona();
		modeloZona.conectar();
		
		limpieza.setZona(modeloZona.getZona(rs.getInt("id_zona")));
		
		modeloZona.cerrar();
		return limpieza;
	}
	
	public ArrayList<Limpieza> getAllLimpieza() {
		String st = "SELECT * FROM limpieza";
		ArrayList<Limpieza> limpiadores = new ArrayList<>();
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				limpiadores.add(rellenarLimpieza(rs));
			}
			
			return limpiadores;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
