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
 * Servlet implementation class InsertarVehiculo
 */
@WebServlet("/InsertarVehiculo")
public class InsertarVehiculo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarVehiculo() {
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
		
		Manager manager = (Manager) session.getAttribute("manager");
		
		if (manager != null || usuario != null || monitor != null || limpieza != null || recepcion != null) {
			request.getRequestDispatcher("vehiculos/insertarVehiculo.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("error404.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String matricula = request.getParameter("matricula");
		String marca = request.getParameter("marca");
		String modelo = request.getParameter("modelo");
		String color = request.getParameter("color");
		
		Vehiculo vehiculo = new Vehiculo();
		
		vehiculo.setMatricula(matricula);
		vehiculo.setMarca(marca);
		vehiculo.setModelo(modelo);
		vehiculo.setColor(color);
		
		ModeloVehiculos modeloVehiculos = new ModeloVehiculos();
		modeloVehiculos.conectar();
		
		modeloVehiculos.insertarVehiculo(vehiculo);
		
		modeloVehiculos.cerrar();
		
		request.getRequestDispatcher("MostrarVehiculos").forward(request, response);
	}

}
