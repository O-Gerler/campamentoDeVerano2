package modeloDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modeloDTO.Cliente;
import modeloDTO.Mascota;
import modeloDTO.Usuario;

public class ModeloCliente extends Conector{
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

	public boolean eliminarCliente(int id) {
		String st = "DELETE FROM clientes WHERE id=?";
		
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
	
	public boolean modificarCliente(Cliente cliente) {
		String st = "UPDATE clientes SET id_grupo WHERE id_cliente=?";
		
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

	private Cliente rellenarCliente(ResultSet rs) throws SQLException {
		Cliente cliente = clienteHeredaUsuario(rs.getInt("id_cliente"));
		
		ModeloGrupo modeloGrupo = new ModeloGrupo();
		modeloGrupo.conectar();
		
		cliente.setGrupo(modeloGrupo.getGrupo(rs.getInt("id_grupo")));
		
		modeloGrupo.cerrar();
		ModeloClienteMascota modeloClienteMascota = new ModeloClienteMascota();
		modeloClienteMascota.conectar();
		
		ArrayList<Mascota> mascotas = modeloClienteMascota.getClienteMascota(rs.getInt("id_cliente"));
		
		modeloClienteMascota.cerrar();
		
		cliente.setMascotas(mascotas);
		
		return cliente;
	}
	
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
