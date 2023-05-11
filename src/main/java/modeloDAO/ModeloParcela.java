package modeloDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modeloDTO.Parcela;

public class ModeloParcela extends Conector{
	public boolean insertarParcela(int id_tipo, int id_zona, int id_grupo) {
		String st = "INSERT INTO parcelas (id_tipo, id_zona, id_grupo, limpia) values (?,?,?,?)";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setInt(1, id_tipo);
			pst.setInt(2, id_zona);
			pst.setInt(3, id_grupo);
			pst.setBoolean(4, false);
			
			pst.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean eliminarParcela(int id) {
		String st = "DELETE FROM parcelas WHERE id_parcela = ?";
		
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
	
	public boolean modificarParcela(int id_parcela, int id_grupo, int id_tipo, int id_zona) {
		String st = "UPDATE parcelas SET id_tipo = ?, id_zona = ?, id_grupo = ? WHERE id_parcela = ?";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setInt(1, id_tipo);
			pst.setInt(2, id_zona);
			pst.setInt(3, id_grupo);
			pst.setInt(4, id_parcela);
			
			pst.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean limpiarParcela(int id_parcela) {
		String st = "UPDATE parcelas SET limpia=? WHERE id_parcela=?";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setBoolean(1, true);
			pst.setInt(2, id_parcela);
			
			pst.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	public Parcela getParcela(int id) {
		String st = "SELECT * FROM parcelas WHERE id_parcela=?";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setInt(1, id);
			
			ResultSet rs = pst.executeQuery();
			rs.next();
			
			Parcela parcela = rellenarParcela(rs);
			
			return parcela;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Parcela getParcelaPorZona(int id) {
		String st = "SELECT * FROM parcelas WHERE id_zona=?";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			ResultSet rs = pst.executeQuery();
			rs.next();
			
			Parcela parcela = rellenarParcela(rs);
			
			return parcela;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	private Parcela rellenarParcela(ResultSet rs) throws SQLException {
		ModeloTipo modeloTipo = new ModeloTipo();
		ModeloZona modeloZona = new ModeloZona();
		ModeloGrupo modeloGrupo = new ModeloGrupo();
		
		modeloTipo.conectar();
		modeloZona.conectar();
		modeloGrupo.conectar();
		
		Parcela parcela = new Parcela();
		
		parcela.setId(rs.getInt("id_parcela"));
		parcela.setTipo(modeloTipo.getTipo(rs.getInt("id_tipo")));
		parcela.setZona(modeloZona.getZona(rs.getInt("id_zona")));
		parcela.setGrupo(modeloGrupo.getGrupo(rs.getInt("id_grupo")));
		parcela.setLimpia(rs.getBoolean("limpia"));
		
		modeloTipo.cerrar();
		modeloZona.cerrar();
		modeloGrupo.cerrar();
		
		return parcela;
	}
	
	public ArrayList<Parcela> getParcelasPorZona(int id_zona) {
		String st = "SELECT * FROM parcelas WHERE id_zona=?";
		ArrayList<Parcela> parcelas = new ArrayList<>();
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setInt(1, id_zona);
			
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				parcelas.add(rellenarParcela(rs));
			}
			
			return parcelas;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public ArrayList<Parcela> getAllParcelas() {
		String st = "SELECT * FROM parcelas";
		ArrayList<Parcela> parcelas = new ArrayList<>();
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				parcelas.add(rellenarParcela(rs));
			}
			
			return parcelas;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
