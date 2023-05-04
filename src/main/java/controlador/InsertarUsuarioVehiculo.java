package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modeloDAO.ModeloUsuario;
import modeloDAO.ModeloUsuarioVehiculo;
import modeloDAO.ModeloVehiculos;
import modeloDTO.Usuario;
import modeloDTO.UsuarioVehiculo;
import modeloDTO.Vehiculo;

/**
 * Servlet implementation class InsertarUsuarioVehiculo
 */
@WebServlet("/InsertarUsuarioVehiculo")
public class InsertarUsuarioVehiculo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarUsuarioVehiculo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ModeloUsuario modeloUsuario = new ModeloUsuario();
		ModeloVehiculos modeloVehiculos = new ModeloVehiculos();
		
		modeloUsuario.conectar();
		modeloVehiculos.conectar();
		
		ArrayList<Usuario> usuarios = modeloUsuario.getAllUsuarios();
		ArrayList<Vehiculo> vehiculos = modeloVehiculos.getAllVehiculos();
		
		modeloUsuario.cerrar();
		modeloVehiculos.cerrar();
		
		request.setAttribute("vehiculos", vehiculos);
		request.setAttribute("usuarios", usuarios);
		request.getRequestDispatcher("usuariosVehiculos/insertar.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id_usuario = Integer.parseInt(request.getParameter("id_usuario"));
		int id_vehiculo = Integer.parseInt(request.getParameter("id_vehiculo"));
		
		ModeloUsuario modeloUsuario = new ModeloUsuario();
		ModeloVehiculos modeloVehiculos = new ModeloVehiculos();
		
		modeloUsuario.conectar();
		modeloVehiculos.conectar();
		
		Usuario usuario = modeloUsuario.getUsuarios(id_usuario);
		Vehiculo vehiculo = modeloVehiculos.getVehiculo(id_vehiculo);
		
		modeloUsuario.cerrar();
		modeloVehiculos.cerrar();
		
		UsuarioVehiculo usuarioVehiculo = new UsuarioVehiculo();
		
		usuarioVehiculo.setUsuario(usuario);
		usuarioVehiculo.setVehiculo(vehiculo);
		
		ModeloUsuarioVehiculo modeloUsuarioVehiculo = new ModeloUsuarioVehiculo();
		modeloUsuarioVehiculo.conectar();
		
		modeloUsuarioVehiculo.insertarUsuarioVehiculo(usuarioVehiculo);
		
		modeloUsuarioVehiculo.cerrar();
		
		request.getRequestDispatcher("MostrarUsuarioVehiculo").forward(request, response);
	}

}
