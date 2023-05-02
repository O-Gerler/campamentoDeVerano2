package modeloDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modeloDTO.Vehiculo;

public class ModeloVehiculos extends Conector{
	public boolean insertarVehiculo(Vehiculo vehiculo) {
		String st = "INSERT INTO vehiculos(matricula, marca, modelo, color) VALUES ?,?,?,?";
		
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
	
	public boolean eliminarVehiculo(int id) {
		String st = "DELETE FROM vehiculos WHERE id=?";
		
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
	
	public boolean modificarVehiculo(Vehiculo vehiculo) {
		String st = "UPDATE vehiculos SET matricula=?, marca=?, modelo=?, color=? WHERE id=?";
		
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
	
	public Vehiculo getVehiculo(int id) {
		String st = "SELECT * FROM vehiculos WHERE id=?";
		
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

	private Vehiculo rellenarVehiculo(ResultSet rs) throws SQLException {
		Vehiculo vehiculo = new Vehiculo();
		
		vehiculo.setId(rs.getInt("id"));
		vehiculo.setMatricula(rs.getString("matricula"));
		vehiculo.setMarca(rs.getString("marca"));
		vehiculo.setModelo(rs.getString("modelo"));
		vehiculo.setColor(rs.getString("color"));
		return vehiculo;
	}
	
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
