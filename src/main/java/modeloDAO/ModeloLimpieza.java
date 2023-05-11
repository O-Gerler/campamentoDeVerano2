package modeloDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modeloDTO.Limpieza;
import modeloDTO.Monitor;
import modeloDTO.Personal;

public class ModeloLimpieza extends Conector{
	private Limpieza limpiezaHeredaPersonal(int id) {
		ModeloPersonal modeloPersonal = new ModeloPersonal();
		modeloPersonal.conectar();
		
		Personal personal = modeloPersonal.getPersonal(id);
		
		Limpieza limpieza = new Limpieza();

		limpieza.setId(personal.getId());
		limpieza.setNombre(personal.getNombre());
		limpieza.setApellido(personal.getApellido());
		limpieza.setDni(personal.getDni());
		limpieza.setContrasena(personal.getContrasena());
		limpieza.setEmail(personal.getEmail());
		limpieza.setFechaNacimiento(personal.getFechaNacimiento());
		limpieza.setTelefono(personal.getTelefono());
		limpieza.setVehiculos(personal.getVehiculos());
		limpieza.setDirector(personal.getDirector());
		limpieza.setFechaIngreso(personal.getFechaIngreso());
		
		return limpieza;
	}
	
	public boolean insertarLimpieza(int id_limpieza, int id_zona) {
		String st = "INSERT INTO limpieza VALUES (?,?)";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setInt(1, id_limpieza);
			pst.setInt(2, id_zona);
			
			pst.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean eliminarLimpieza(int id) {
		String st = "DELETE FROM limpieza WHERE id_limpieza=?";
		
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
	
	public boolean modificarLimpieza(int id_limpieza, int id_zona) {
		String st = "UPDATE limpieza SET id_zona=? WHERE id_limpieza=?";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setInt(1, id_zona);
			pst.setInt(2, id_limpieza);
			
			pst.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public Limpieza getLimpieza(int id) {
		String st = "SELECT * FROM limpieza WHERE id_limpieza=?";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setInt(1, id);
			
			ResultSet rs = pst.executeQuery();
			rs.next();
			
			Limpieza limpieza = rellenarLimpieza(rs);
			
			return limpieza;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	private Limpieza rellenarLimpieza(ResultSet rs) throws SQLException {
		Limpieza limpieza = limpiezaHeredaPersonal(rs.getInt("id_limpieza"));
		
		ModeloZona modeloZona = new ModeloZona();
		modeloZona.conectar();
		
		limpieza.setZona(modeloZona.getZona(rs.getInt("id_zona")));
		
		modeloZona.cerrar();
		return limpieza;
	}
	
	public ArrayList<Limpieza> getAllLimpieza() {
		String st = "SELECT * FROM limpieza";
		ArrayList<Limpieza> limpiadores = new ArrayList<>();
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				limpiadores.add(rellenarLimpieza(rs));
			}
			
			return limpiadores;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
