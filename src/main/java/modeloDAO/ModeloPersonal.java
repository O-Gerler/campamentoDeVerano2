package modeloDAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modeloDTO.Cliente;
import modeloDTO.Personal;
import modeloDTO.Usuario;

public class ModeloPersonal extends Conector{
	/**
	 * Este método crea un objeto Personal a partir de un objeto Usuario con el mismo id.
	 * @param id El id del objeto Usuario del cual se quiere crear un objeto Personal.
	 * @return Un objeto Personal con los mismos datos que el objeto Usuario con el id especificado.
	 */
	private Personal personalHeredaUsuario(int id) {
		ModeloUsuario modeloUsuario = new ModeloUsuario();
		modeloUsuario.conectar();
		
		Usuario usuario = modeloUsuario.getUsuarios(id);
		
		modeloUsuario.cerrar();
		
		Personal personal = new Personal();
		
		personal.setId(usuario.getId());
		personal.setNombre(usuario.getNombre());
		personal.setApellido(usuario.getApellido());
		personal.setDni(usuario.getDni());
		personal.setContrasena(usuario.getContrasena());
		personal.setEmail(usuario.getEmail());
		personal.setFechaNacimiento(usuario.getFechaNacimiento());
		personal.setTelefono(usuario.getTelefono());
		personal.setVehiculos(usuario.getVehiculos());
		
		return personal;
	}
	
	/**
	 * Este método inserta un nuevo Personal en la base de datos.
	 * @param personal El objeto Personal que se quiere insertar.
	 * @return true si la inserción fue exitosa, false en caso contrario.
	 */
	public boolean insertarPersonal(Personal personal) {
		String st = "INSERT INTO personal VALUES (?,?,?)";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setInt(1, personal.getId());
			pst.setDate(2, new Date(personal.getFechaIngreso().getTime()));
			pst.setInt(3, personal.getDirector());
			
			pst.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * Elimina una fila de la tabla personal en la base de datos.
	 *
	 * @param id el valor de la columna id_personal de la fila a eliminar
	 * @return true si la eliminación se realiza correctamente, false en caso contrario
	 */
	public boolean eliminarPersonal(int id) {
		String st = "DELETE FROM personal WHERE id_personal=?";
		
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
	 * Actualiza una fila en la tabla personal en la base de datos.
	 *
	 * @param personal objeto Personal que contiene los nuevos valores para la fila
	 * @return true si la actualización se realiza correctamente, false en caso contrario
	 */
	public boolean modificarPersonal(Personal personal) {
		String st = "UPDATE personal SET fecha_ingreso=?, dirige=? WHERE id_personal=?";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setDate(1, new Date(personal.getFechaIngreso().getTime()));
			pst.setInt(2, personal.getDirector());
			pst.setInt(3, personal.getId());
			
			pst.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * Recupera una fila de la tabla personal en la base de datos.
	 *
	 * @param id el valor de la columna id_personal de la fila a recuperar
	 * @return un objeto Personal que representa la fila recuperada, o null si no se encuentra ninguna fila
	 */
	public Personal getPersonal(int id) {
		String st = "SELECT * FROM personal WHERE id_personal=?";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setInt(1, id);
			
			ResultSet rs = pst.executeQuery();
			rs.next();
			
			Personal personal = rellenarPersonal(rs);
			
			return personal;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * Recupera una lista de objetos Personal que no tienen un rol asignado.
	 *
	 * @return una lista de objetos Personal que no tienen un rol asignado
	 */
	public ArrayList<Personal> getPersonalSinRol() {
		String st = "select * from personal where id_personal not in (select id_monitor from monitores) and id_personal not in (select id_limpieza from limpieza) and id_personal not in (select id_recepcion from recepcion)";
		ArrayList<Personal> personales = new ArrayList<>();
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				personales.add(rellenarPersonal(rs));
			}
			
			return personales;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * Crea un objeto Personal a partir de un ResultSet.
	 *
	 * @param rs el ResultSet que contiene los datos del objeto Personal
	 * @return un objeto Personal con los datos del ResultSet
	 * @throws SQLException si ocurre un error al acceder a los datos del ResultSet
	 */
	private Personal rellenarPersonal(ResultSet rs) throws SQLException {
		Personal personal = personalHeredaUsuario(rs.getInt("id_personal"));
		
		personal.setFechaIngreso(rs.getDate("fecha_ingreso"));
		personal.setDirector(rs.getInt("dirige"));
		return personal;
	}
	
	/**
	 * Recupera una lista de todos los objetos Personal en la tabla personal de la base de datos.
	 *
	 * @return una lista de todos los objetos Personal en la tabla personal
	 */

	public ArrayList<Personal> getAllPersonal() {
		String st = "SELECT * FROM personal";
		ArrayList<Personal> personals = new ArrayList<>();
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				personals.add(rellenarPersonal(rs));
			}
			
			return personals;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
