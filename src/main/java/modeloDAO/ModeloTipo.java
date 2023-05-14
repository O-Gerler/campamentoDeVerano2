package modeloDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modeloDTO.Tipo;

public class ModeloTipo extends Conector{
	/**
	 * Este método inserta un nuevo tipo en la base de datos.
	 *
	 * @param tipo El objeto Tipo que se quiere insertar en la base de datos.
	 * @return Un valor booleano que indica si la inserción fue exitosa (true) o no (false).
	 */
	public boolean insertarTipo(Tipo tipo) {
		String st = "INSERT INTO tipos (nombre, cantidad_personas, descripcion) VALUES (?, ? ,?)";
		
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
	
	/**
	 * Este método elimina un tipo de la base de datos.
	 *
	 * @param id El ID del tipo que se quiere eliminar.
	 * @return Un valor booleano que indica si la eliminación fue exitosa (true) o no (false).
	 */
	public boolean eliminarTipo(int id) {
		String st = "DELETE FROM tipos WHERE id_tipo = ?";
		
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
	 * Este método modifica un tipo en la base de datos.
	 *
	 * @param tipo El objeto Tipo que contiene los datos actualizados.
	 * @return Un valor booleano que indica si la modificación fue exitosa (true) o no (false).
	 */
	public boolean modificarTipo(Tipo tipo) {
		String st = "UPDATE tipos SET nombre=?, cantidad_personas=?, descripcion=? WHERE id_tipo=?";
		
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
	
	/**
	 * Este método devuelve un objeto Tipo de la base de datos.
	 *
	 * @param id El ID del tipo que se quiere obtener.
	 * @return Un objeto Tipo con los datos del tipo especificado.
	 */
	public Tipo getTipo(int id) {
		String st = "SELECT * FROM tipos WHERE id_tipo = ?";
		
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

	/**
	 * Este método privado toma un objeto ResultSet y devuelve un objeto Tipo.
	 *
	 * @param rs El objeto ResultSet que contiene los datos del tipo.
	 * @return Un objeto Tipo con los datos del ResultSet.
	 * @throws SQLException Si ocurre un error al acceder a los datos del ResultSet.
	 */
	private Tipo rellenarTipo(ResultSet rs) throws SQLException {
		Tipo tipo = new Tipo();
		
		tipo.setId(rs.getInt("id_tipo"));
		tipo.setNombre(rs.getString("nombre"));
		tipo.setCantidad_personas(rs.getInt("cantidad_personas"));
		tipo.setDescripcion(rs.getString("descripcion"));
		return tipo;
	}
	
	/**
	 * Este método devuelve una lista de todos los tipos.
	 *
	 * @return Una lista de objetos Tipo que contiene todos los tipos.
	 */
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
