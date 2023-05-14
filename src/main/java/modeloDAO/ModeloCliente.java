package modeloDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modeloDTO.Cliente;
import modeloDTO.Usuario;

public class ModeloCliente extends Conector{
	/**
	 * Retorna un objeto Cliente a partir de un objeto Usuario.
	 * @param id El id del usuario.
	 * @return El objeto Cliente obtenido.
	 */
	private Cliente clienteHeredaUsuario(int id) {
		ModeloUsuario modeloUsuario = new ModeloUsuario();
		modeloUsuario.conectar();
		
		Usuario usuario = modeloUsuario.getUsuarios(id);
		
		Cliente cliente = new Cliente();
		
		cliente.setId(usuario.getId());
		cliente.setNombre(usuario.getNombre());
		cliente.setApellido(usuario.getApellido());
		cliente.setDni(usuario.getDni());
		cliente.setContrasena(usuario.getContrasena());
		cliente.setEmail(usuario.getEmail());
		cliente.setFechaNacimiento(usuario.getFechaNacimiento());
		cliente.setTelefono(usuario.getTelefono());
		cliente.setVehiculos(usuario.getVehiculos());
		
		return cliente;
	}
	
	/**
	 * Inserta un nuevo cliente en la base de datos.
	 * @param cliente El cliente a insertar.
	 * @return true si el cliente se insertó correctamente, false en caso contrario.
	 */
	public boolean insertarCliente(Cliente cliente) {
		String st = "INSERT INTO clientes VALUES (?,?)";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setInt(1, cliente.getId());
			pst.setInt(2, cliente.getGrupo().getId());
			
			pst.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	/**
	 * Elimina un cliente de la base de datos.
	 *
	 * @param id el ID del cliente a eliminar.
	 * @return true si se eliminó correctamente, false si ocurrió un error.
	 */
	public boolean eliminarCliente(int id) {
		String st = "DELETE FROM clientes WHERE id_cliente=?";
		
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
	 * Modifica un cliente en la base de datos.
	 * 
	 * @param cliente el cliente a modificar.
	 * @return true si se ha modificado correctamente, false en caso contrario.
	 */

	public boolean modificarCliente(Cliente cliente) {
		String st = "UPDATE clientes SET id_grupo=? WHERE id_cliente=?";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setInt(1, cliente.getGrupo().getId());
			pst.setInt(2, cliente.getId());
			
			pst.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	* Devuelve el objeto Cliente correspondiente al id proporcionado.
	* @param id El id del cliente.
	* @return El objeto Cliente correspondiente al id proporcionado, o null si no existe.
	*/
	public Cliente getCliente(int id) {
		String st = "SELECT * FROM clientes WHERE id_cliente=?";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setInt(1, id);
			
			ResultSet rs = pst.executeQuery();
			rs.next();
			
			Cliente cliente = rellenarCliente(rs);
			
			return cliente;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * Rellena los datos de un objeto Cliente a partir de un objeto ResultSet de una consulta a la tabla "clientes" de la base de datos.
	 * @param rs Objeto ResultSet con los datos del cliente consultado.
	 * @return Objeto Cliente con los datos rellenados a partir del ResultSet.
	 * @throws SQLException Si ocurre algún error en la consulta SQL.
	 */
	private Cliente rellenarCliente(ResultSet rs) throws SQLException {
		Cliente cliente = clienteHeredaUsuario(rs.getInt("id_cliente"));
		
		ModeloGrupo modeloGrupo = new ModeloGrupo();
		modeloGrupo.conectar();
		
		cliente.setGrupo(modeloGrupo.getGrupo(rs.getInt("id_grupo")));
		
		modeloGrupo.cerrar();
		
		return cliente;
	}
	
	/**
	 * Devuelve una lista de clientes asociados a un monitor determinado.
	 * 
	 * @param id_monitor el ID del monitor del que se desea obtener la lista de clientes.
	 * @return una lista de objetos Cliente asociados al monitor especificado.
	 *         Si no se encuentra ningún cliente, devuelve una lista vacía.
	 *         Si ocurre una excepción SQL, devuelve null.
	 */
	public ArrayList<Cliente> getClientesPorMonitor(int id_monitor) {
		String st = "SELECT * FROM clientes WHERE id_grupo = (SELECT id_grupo FROM grupos WHERE id_monitor=?)";
		ArrayList<Cliente> clientes = new ArrayList<>();
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setInt(1, id_monitor);
			
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				clientes.add(rellenarCliente(rs));
			}
			
			return clientes;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * Obtiene todos los clientes almacenados en la base de datos.
	 * 
	 * @return un ArrayList de objetos Cliente con la información de todos los clientes, 
	 *         o null si ocurre un error al acceder a la base de datos.
	 */
	public ArrayList<Cliente> getAllClientes() {
		String st = "SELECT * FROM clientes";
		ArrayList<Cliente> clientes = new ArrayList<>();
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				clientes.add(rellenarCliente(rs));
			}
			
			return clientes;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
