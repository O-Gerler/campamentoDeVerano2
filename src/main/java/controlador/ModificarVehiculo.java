package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modeloDAO.ModeloVehiculos;
import modeloDTO.Limpieza;
import modeloDTO.Manager;
import modeloDTO.Monitor;
import modeloDTO.Recepcion;
import modeloDTO.Usuario;
import modeloDTO.Vehiculo;

/**
 * Modificar un vehiculo
 */
@WebServlet("/ModificarVehiculo")
public class ModificarVehiculo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModificarVehiculo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();

		Usuario usuario = (Usuario) session.getAttribute("usuario");

		Monitor monitor = (Monitor) session.getAttribute("monitor");

		Limpieza limpieza = (Limpieza) session.getAttribute("limpieza");

		Recepcion recepcion = (Recepcion) session.getAttribute("recepcion");

		Manager manager = (Manager) session.getAttribute("manager");

		if (manager != null || usuario != null || monitor != null || limpieza != null || recepcion != null) {
			int id = Integer.parseInt(request.getParameter("id"));

			ModeloVehiculos modeloVehiculos = new ModeloVehiculos();
			modeloVehiculos.conectar();

			Vehiculo vehiculo = modeloVehiculos.getVehiculo(id);

			modeloVehiculos.cerrar();

			request.setAttribute("vehiculo", vehiculo);
			request.getRequestDispatcher("vehiculos/modificarVehiculo.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("error404.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		String matricula = request.getParameter("matricula");
		String marca = request.getParameter("marca");
		String modelo = request.getParameter("modelo");
		String color = request.getParameter("color");

		Vehiculo vehiculo = new Vehiculo();

		vehiculo.setId(id);
		vehiculo.setMatricula(matricula);
		vehiculo.setMarca(marca);
		vehiculo.setModelo(modelo);
		vehiculo.setColor(color);

		ModeloVehiculos modeloVehiculos = new ModeloVehiculos();
		modeloVehiculos.conectar();

		modeloVehiculos.modificarVehiculo(vehiculo);

		modeloVehiculos.cerrar();

		HttpSession session = request.getSession();

		Manager manager = (Manager) session.getAttribute("manager");

		Usuario usuario = (Usuario) session.getAttribute("usuario");

		Usuario monitor = (Usuario) session.getAttribute("monitor");

		Usuario recepcion = (Usuario) session.getAttribute("recepcion");

		Usuario limpieza = (Usuario) session.getAttribute("limpieza");

		if (manager == null && usuario == null && monitor == null && recepcion == null && limpieza == null) {
			request.getRequestDispatcher("error404.jsp").forward(request, response);
		} else if (manager != null) {
			response.sendRedirect("VistaManager");
		} else {
			response.sendRedirect("MostrarUsuarioVehiculo");
		}

	}

}
