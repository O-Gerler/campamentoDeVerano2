package modeloDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modeloDTO.Parcela;

public class ModeloParcela extends Conector{
	/**
	 * Este método inserta una nueva Parcela en la base de datos.
	 * @param id_tipo El id del tipo de la Parcela que se quiere insertar.
	 * @param id_zona El id de la zona de la Parcela que se quiere insertar.
	 * @param id_grupo El id del grupo de la Parcela que se quiere insertar.
	 * @return true si la inserción fue exitosa, false en caso contrario.
	 */
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
	
	/**
	 * Este método elimina una Parcela de la base de datos.
	 * @param id El id de la Parcela que se quiere eliminar.
	 * @return true si la eliminación fue exitosa, false en caso contrario.
	 */
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
	
	/**
	 * Este método modifica los datos de una Parcela en la base de datos.
	 * @param id_parcela El id de la Parcela que se quiere modificar.
	 * @param id_grupo El nuevo id del grupo de la Parcela.
	 * @param id_tipo El nuevo id del tipo de la Parcela.
	 * @param id_zona El nuevo id de la zona de la Parcela.
	 * @return true si la modificación fue exitosa, false en caso contrario.
	 */
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
	
	/**
	 * Este método marca una Parcela como limpia en la base de datos.
	 * @param id_parcela El id de la Parcela que se quiere marcar como limpia.
	 * @return true si la operación fue exitosa, false en caso contrario.
	 */
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

	/**
	 * Este método obtiene un objeto Parcela a partir de su id.
	 * @param id El id de la Parcela que se quiere obtener.
	 * @return Un objeto Parcela con los datos de la Parcela con el id especificado, o null si no se encuentra en la base de datos.
	 */
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
	
	/**
	 * Este método obtiene un objeto Parcela a partir de su id de zona.
	 * @param id El id de la zona de la Parcela que se quiere obtener.
	 * @return Un objeto Parcela con los datos de la Parcela con el id de zona especificado, o null si no se encuentra en la base de datos.
	 */
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

	/**
	 * Este método crea un objeto Parcela a partir de un ResultSet.
	 * @param rs El ResultSet que contiene los datos de la Parcela.
	 * @return Un objeto Parcela con los datos del ResultSet.
	 * @throws SQLException Si ocurre un error al acceder a los datos del ResultSet.
	 */
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
	
	/**
	 * Este método obtiene una lista de Parcelas a partir de su id de zona.
	 * @param id_zona El id de la zona de las Parcelas que se quieren obtener.
	 * @return Una lista de objetos Parcela con los datos de las Parcelas con el id de zona especificado.
	 */
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
	
	/**
	 * Este método obtiene una lista de todas las Parcelas en la base de datos.
	 * @return Una lista de objetos Parcela con los datos de todas las Parcelas en la base de datos.
	 */
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
