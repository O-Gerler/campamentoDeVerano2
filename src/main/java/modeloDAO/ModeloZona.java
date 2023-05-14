package modeloDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modeloDTO.Zona;

public class ModeloZona extends Conector{
	/**
	 * Inserta una nueva zona en la base de datos.
	 *
	 * @param zona el objeto Zona que se va a insertar en la base de datos
	 * @return verdadero si la inserción fue exitosa, falso en caso contrario
	 */
	public boolean insertarZona(Zona zona) {
		String st = "INSERT INTO zonas(nombre, descripcion) VALUES (?,?)";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setString(1, zona.getNombre());
			pst.setString(2, zona.getDescripcion());
			
			pst.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * Elimina una zona de la base de datos.
	 *
	 * @param id el ID de la zona que se va a eliminar
	 * @return verdadero si la eliminación fue exitosa, falso en caso contrario
	 */
	public boolean eliminarZona(int id) {
		String st = "DELETE FROM zonas WHERE id_zona=?";
		
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
	 * Modifica la información de una zona en la base de datos.
	 *
	 * @param zona el objeto Zona con la información actualizada
	 * @return verdadero si la modificación fue exitosa, falso en caso contrario
	 */
	public boolean modificarZona(Zona zona) {
		String st = "UPDATE zonas SET nombre=?, descripcion=? WHERE id_zona=?";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setString(1, zona.getNombre());
			pst.setString(2, zona.getDescripcion());
			pst.setInt(3, zona.getId());
			
			pst.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * Obtiene una zona de la base de datos a partir de su ID.
	 *
	 * @param id el ID de la zona que se quiere obtener
	 * @return un objeto Zona con la información de la zona solicitada
	 */
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

	/**
	 * Este método toma un objeto ResultSet y lo utiliza para crear y devolver un objeto Zona.
	 * 
	 * @param rs el objeto ResultSet que contiene los datos de la zona
	 * @return un objeto Zona con los datos obtenidos del ResultSet
	 * @throws SQLException si ocurre un error al acceder a los datos del ResultSet
	 */
	private Zona rellenarZona(ResultSet rs) throws SQLException {
		Zona zona = new Zona();
		
		zona.setId(rs.getInt("id_zona"));
		zona.setNombre(rs.getString("nombre"));
		zona.setDescripcion(rs.getString("descripcion"));
		
		return zona;
	}
	
	/**
	 * Este método recupera todas las zonas de la base de datos y las devuelve en un ArrayList.
	 * 
	 * @return un ArrayList de objetos Zona que contiene todas las zonas de la base de datos
	 */
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
