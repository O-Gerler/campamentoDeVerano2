package modeloDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modeloDTO.Limpieza;
import modeloDTO.Monitor;
import modeloDTO.Personal;

public class ModeloLimpieza extends Conector {
	/**
	 * Convierte un objeto Personal en un objeto Limpieza, heredando los atributos
	 * comunes.
	 * 
	 * @param id El ID del Personal a convertir.
	 * @return Un objeto Limpieza con los atributos del Personal especificado.
	 */

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

	/**
	 * Inserta una nueva asignación de limpieza a una zona en la base de datos.
	 * @param id_limpieza el ID de la limpieza a asignar.
	 * @param id_zona el ID de la zona a la cual se asignará la limpieza.
	 * @return verdadero si la asignación se insertó correctamente, falso si no.
	 */
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

	/**
	 * Elimina una entrada de limpieza en la base de datos con el id especificado.
	 *
	 * @param id el id de la entrada de limpieza que se eliminará
	 * @return true si se eliminó la entrada correctamente, false si ocurrió un error o no se encontró la entrada
	 */
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

	/**
	 * Modifica la entrada de limpieza con el id especificado para que esté asociada con la zona especificada.
	 *
	 * @param id_limpieza el id de la entrada de limpieza que se modificará
	 * @param id_zona el id de la zona a la que se asociará la entrada de limpieza
	 * @return true si se modificó la entrada correctamente, false si ocurrió un error o no se encontró la entrada
	 */
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

	/**
	 * Devuelve la entrada de limpieza correspondiente al id especificado.
	 *
	 * @param id el id de la entrada de limpieza que se desea obtener
	 * @return la entrada de limpieza correspondiente al id especificado, o null si no se encontró ninguna entrada con ese id o si ocurrió un error
	 */
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

	/**
	 * Rellena y devuelve un objeto Limpieza utilizando los datos del ResultSet especificado.
	 *
	 * @param rs el ResultSet que contiene los datos de la entrada de limpieza que se desea crear
	 * @return un objeto Limpieza creado a partir de los datos del ResultSet especificado
	 * @throws SQLException si se produce un error al acceder a los datos del ResultSet
	 */

	private Limpieza rellenarLimpieza(ResultSet rs) throws SQLException {
		Limpieza limpieza = limpiezaHeredaPersonal(rs.getInt("id_limpieza"));

		ModeloZona modeloZona = new ModeloZona();
		modeloZona.conectar();

		limpieza.setZona(modeloZona.getZona(rs.getInt("id_zona")));

		modeloZona.cerrar();
		return limpieza;
	}

	/**
	 * Devuelve una lista de todas las entradas de limpieza en la base de datos.
	 *
	 * @return una lista de objetos Limpieza que representan todas las entradas de limpieza en la base de datos
	 *         o null si se produce un error al acceder a la base de datos
	 */
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
