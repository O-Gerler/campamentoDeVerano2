package modeloDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modeloDTO.Parcela;

public class ModeloParcela extends Conector{
	public boolean insertarParcela(Parcela parcela) {
		String st = "INSERT INTO parcelas (id_tipo, id_zona, id_grupo, limpia) values ?,?,?,?";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setInt(1, parcela.getTipo().getId());
			pst.setInt(2, parcela.getZona().getId());
			pst.setInt(3, parcela.getGrupo().getId());
			pst.setBoolean(4, parcela.getLimpia());
			
			pst.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean eliminarParcela(int id) {
		String st = "DELETE FROM parcelas WHERE id = ?";
		
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
	
	public boolean modificarParcela(Parcela parcela) {
		String st = "UPDATE parcelas SET id_tipo = ?, id_zona = ?, id_grupo = ?, limpia = ? WHERE id = ?";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setInt(1, parcela.getTipo().getId());
			pst.setInt(2, parcela.getZona().getId());
			pst.setInt(3, parcela.getGrupo().getId());
			pst.setBoolean(4, parcela.getLimpia());
			pst.setInt(5, parcela.getId());
			
			pst.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	public Parcela getParcela(int id) {
		String st = "SELECT * FROM parcelas WHERE id=?";
		
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
		
		parcela.setId(rs.getInt("id"));
		parcela.setTipo(modeloTipo.getTipo(rs.getInt("id_tipo")));
		parcela.setZona(modeloZona.getZona(rs.getInt("id_zona")));
		parcela.setGrupo(modeloGrupo.getGrupo(rs.getInt("id_grupo")));
		parcela.setLimpia(rs.getBoolean("limpia"));
		
		modeloTipo.cerrar();
		modeloZona.cerrar();
		modeloGrupo.cerrar();
		
		return parcela;
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
