package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modeloDAO.ModeloVehiculos;
import modeloDTO.Manager;
import modeloDTO.Usuario;

/**
 * Elimina un vehiculo
 */
@WebServlet("/EliminarVehiculo")
public class EliminarVehiculo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EliminarVehiculo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		Manager manager = (Manager) session.getAttribute("manager");

		Usuario usuario = (Usuario) session.getAttribute("usuario");

		Usuario monitor = (Usuario) session.getAttribute("monitor");

		Usuario recepcion = (Usuario) session.getAttribute("recepcion");

		Usuario limpieza = (Usuario) session.getAttribute("limpieza");

		if (manager == null && usuario == null && monitor == null && recepcion == null && limpieza == null) {
			request.getRequestDispatcher("error404.jsp").forward(request, response);
		} else {

			int id = Integer.parseInt(request.getParameter("id"));

			ModeloVehiculos modeloVehiculos = new ModeloVehiculos();
			modeloVehiculos.conectar();

			modeloVehiculos.eliminarVehiculo(id);

			modeloVehiculos.cerrar();

			if (manager != null) {
				response.sendRedirect("VistaManager");
			}else {
				response.sendRedirect("MostrarUsuarioVehiculo");
			}
			
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
