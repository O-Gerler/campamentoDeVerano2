package modeloDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modeloDTO.Grupo;

public class ModeloGrupo extends Conector{
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

	private Grupo rellenarGrupo(ResultSet rs) throws SQLException {
		Grupo grupo = new Grupo();
		
		grupo.setId(rs.getInt("id_grupo"));
		
		ModeloMonitor modeloMonitor = new ModeloMonitor();
		modeloMonitor.conectar();
		
		grupo.setMonitor(modeloMonitor.getMonitor(rs.getInt("id_monitor")));
		
		modeloMonitor.cerrar();
		return grupo;
	}
	
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
