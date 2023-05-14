package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modeloDAO.ModeloUsuarioVehiculo;
import modeloDAO.ModeloVehiculos;
import modeloDTO.Limpieza;
import modeloDTO.Manager;
import modeloDTO.Monitor;
import modeloDTO.Recepcion;
import modeloDTO.Usuario;
import modeloDTO.UsuarioVehiculo;
import modeloDTO.Vehiculo;

/**
 * Muestra todos vehiculos por usuario
 */
@WebServlet("/MostrarUsuarioVehiculo")
public class MostrarUsuarioVehiculo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarUsuarioVehiculo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		
		Monitor monitor = (Monitor) session.getAttribute("monitor");
		
		Limpieza limpieza = (Limpieza) session.getAttribute("limpieza");
		
		Recepcion recepcion = (Recepcion) session.getAttribute("recepcion");
		
		ModeloUsuarioVehiculo modeloUsuarioVehiculo = new ModeloUsuarioVehiculo();
		modeloUsuarioVehiculo.conectar();
		
		ArrayList<Vehiculo> vehiculos = null;
		
		if (usuario != null) {
			vehiculos = modeloUsuarioVehiculo.getUsuarioVehiculo(usuario.getId());
		}else if (monitor != null) {
			vehiculos = modeloUsuarioVehiculo.getUsuarioVehiculo(monitor.getId());
		}else if (limpieza != null) {
			vehiculos = modeloUsuarioVehiculo.getUsuarioVehiculo(limpieza.getId());
		}else if (recepcion != null) {
			vehiculos = modeloUsuarioVehiculo.getUsuarioVehiculo(recepcion.getId());
		}
		
		modeloUsuarioVehiculo.cerrar();

		if (usuario != null || monitor != null || limpieza != null || recepcion != null) {
			request.setAttribute("usuarioVehiculos", vehiculos);
			request.getRequestDispatcher("usuariosVehiculos/ver.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("error404.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
