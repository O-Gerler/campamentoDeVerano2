package modeloDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modeloDTO.Vehiculo;

public class ModeloVehiculos extends Conector{
	/**
	 * Inserta un nuevo vehículo en la base de datos.
	 *
	 * @param vehiculo el objeto Vehiculo que se va a insertar en la base de datos
	 * @return verdadero si la inserción fue exitosa, falso en caso contrario
	 */
	public boolean insertarVehiculo(Vehiculo vehiculo) {
		String st = "INSERT INTO vehiculos(matricula, marca, modelo, color) VALUES (?,?,?,?)";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setString(1, vehiculo.getMatricula());
			pst.setString(2, vehiculo.getMarca());
			pst.setString(3, vehiculo.getModelo());
			pst.setString(4, vehiculo.getColor());
			
			pst.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * Elimina un vehículo de la base de datos.
	 *
	 * @param id el ID del vehículo que se va a eliminar
	 * @return verdadero si la eliminación fue exitosa, falso en caso contrario
	 */
	public boolean eliminarVehiculo(int id) {
		String st = "DELETE FROM vehiculos WHERE id_vehiculo=?";
		
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
	 * Modifica la información de un vehículo en la base de datos.
	 *
	 * @param vehiculo el objeto Vehiculo con la información actualizada
	 * @return verdadero si la modificación fue exitosa, falso en caso contrario
	 */
	public boolean modificarVehiculo(Vehiculo vehiculo) {
		String st = "UPDATE vehiculos SET matricula=?, marca=?, modelo=?, color=? WHERE id_vehiculo=?";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setString(1, vehiculo.getMatricula());
			pst.setString(2, vehiculo.getMarca());
			pst.setString(3, vehiculo.getModelo());
			pst.setString(4, vehiculo.getColor());
			pst.setInt(5, vehiculo.getId());
			
			pst.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * Obtiene un vehículo de la base de datos a partir de su ID.
	 *
	 * @param id el ID del vehículo que se quiere obtener
	 * @return un objeto Vehiculo con la información del vehículo solicitado
	 */
	public Vehiculo getVehiculo(int id) {
		String st = "SELECT * FROM vehiculos WHERE id_vehiculo=?";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setInt(1, id);
			
			ResultSet rs = pst.executeQuery();
			rs.next();
			
			Vehiculo vehiculo = rellenarVehiculo(rs);
			
			return vehiculo;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * Obtiene un vehículo de la base de datos a partir de su matrícula.
	 *
	 * @param matricula la matrícula del vehículo que se quiere obtener
	 * @return un objeto Vehiculo con la información del vehículo solicitado
	 */
	public Vehiculo getVehiculoViaMatricula(String matricula) {
		String st = "SELECT * FROM vehiculos WHERE matricula=?";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setString(1, matricula);
			
			ResultSet rs = pst.executeQuery();
			rs.next();
			
			Vehiculo vehiculo = rellenarVehiculo(rs);
			
			return vehiculo;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * Rellena un objeto Vehiculo con información de un ResultSet.
	 *
	 * @param rs un ResultSet que contiene información sobre el vehículo
	 * @return un objeto Vehiculo rellenado con información del ResultSet
	 * @throws SQLException si ocurre un error al acceder al ResultSet
	 */
	private Vehiculo rellenarVehiculo(ResultSet rs) throws SQLException {
		Vehiculo vehiculo = new Vehiculo();
		
		vehiculo.setId(rs.getInt("id_vehiculo"));
		vehiculo.setMatricula(rs.getString("matricula"));
		vehiculo.setMarca(rs.getString("marca"));
		vehiculo.setModelo(rs.getString("modelo"));
		vehiculo.setColor(rs.getString("color"));
		return vehiculo;
	}
	
	/**
	 * Obtiene una lista de todos los vehículos en la base de datos.
	 *
	 * @return una lista de objetos Vehiculo que representan todos los vehículos en la base de datos
	 */
	public ArrayList<Vehiculo> getAllVehiculos() {
		String st = "SELECT * FROM vehiculos";
		ArrayList<Vehiculo> vehiculos = new ArrayList<>();
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				vehiculos.add(rellenarVehiculo(rs));
			}
			
			return vehiculos;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
