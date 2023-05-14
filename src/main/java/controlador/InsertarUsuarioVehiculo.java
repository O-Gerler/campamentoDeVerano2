package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modeloDAO.ModeloUsuario;
import modeloDAO.ModeloUsuarioVehiculo;
import modeloDAO.ModeloVehiculos;
import modeloDTO.Manager;
import modeloDTO.Usuario;
import modeloDTO.UsuarioVehiculo;
import modeloDTO.Vehiculo;

/**
 * Inserta un vehiculo para un usuario
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
		HttpSession session = request.getSession();
		
		Manager manager = (Manager) session.getAttribute("manager");
		
		if (manager != null) {
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
		}else {
			request.getRequestDispatcher("error404.jsp").forward(request, response);
		}
		
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
		
		HttpSession session = request.getSession();
		
		Manager manager = (Manager) session.getAttribute("manager");
		
		if (manager != null) { response.sendRedirect("VistaManager"); }
		else { request.getRequestDispatcher("error404.jsp").forward(request, response); }
	}

}
