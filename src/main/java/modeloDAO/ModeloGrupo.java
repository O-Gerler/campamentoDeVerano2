package modeloDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modeloDTO.Grupo;

public class ModeloGrupo extends Conector{
	public boolean insertarGrupo(Grupo grupo) {
		String st = "INSERT INTO grupos (id_monitor) VALUES ?";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setInt(1, grupo.getMonitor().getId());
			
			pst.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean eliminarGrupo(int id) {
		String st = "DELETE FROM grupos WHERE id=?";
		
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
	
	public boolean modificarGrupo(Grupo grupo) {
		String st = "UPDATE grupos SET id_monito=? WHERE id=?";
		
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
	
	public Grupo getGrupo(int id) {
		String st = "SELECT * FROM grupos WHERE id=?";
		
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

	private Grupo rellenarGrupo(ResultSet rs) throws SQLException {
		Grupo grupo = new Grupo();
		
		grupo.setId(rs.getInt("id"));
		
		ModeloMonitor modeloMonitor = new ModeloMonitor();
		modeloMonitor.conectar();
		
		grupo.setMonitor(modeloMonitor.getMonitor(rs.getInt("id_monitor")));
		
		modeloMonitor.cerrar();
		return grupo;
	}
	
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
