package modeloDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modeloDTO.Mascota;

public class ModeloMascota extends Conector{
	public boolean insertarMascota(Mascota mascota) {
		
		String st = "INSERT INTO mascotas (nombre, num_chip, raza) VALUES (? ?, ?)";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setString(1, mascota.getNombre());
			pst.setInt(2, mascota.getNumChip());
			pst.setString(3, mascota.getRaza());
			
			pst.execute();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean eliminarMascota(int id) {
		
		String st = "DELETE FROM mascotas WHERE id = ?";
		
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
	
	public boolean modificarMascota(Mascota mascota) {
		
		String st = "UPDATE mascotas SET nombre = ?, num_chip = ?, raza = ? WHERE id = ?";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setString(1, mascota.getNombre());
			pst.setInt(2, mascota.getNumChip());
			pst.setString(3, mascota.getRaza());
			pst.setInt(4, mascota.getId());
			
			pst.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	public Mascota getMascota(int id) {
		String st = "SELECT * FROM mascotas WHERE id =?";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setInt(1, id);
			
			ResultSet rs = pst.executeQuery();
			rs.next();
			
			Mascota mascota = rellenarMascota(rs);
			
			return mascota;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	private Mascota rellenarMascota(ResultSet rs) throws SQLException {
		Mascota mascota = new Mascota();
		
		mascota.setId(rs.getInt("id"));
		mascota.setNombre(rs.getString("nombre"));
		mascota.setNumChip(rs.getInt("num_chip"));
		mascota.setRaza(rs.getString("raza"));
		return mascota;
	}
	
	public ArrayList<Mascota> getAllMascota() {
		String st = "SELECT * FROM mascotas";
		ArrayList<Mascota> mascotas = new ArrayList<Mascota>();
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				mascotas.add(rellenarMascota(rs));
			}
			
			return mascotas;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
