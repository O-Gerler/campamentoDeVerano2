package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modeloDAO.ModeloUsuarioVehiculo;

/**
 * Servlet implementation class EliminarUsuarioVehiculo
 */
@WebServlet("/EliminarUsuarioVehiculo")
public class EliminarUsuarioVehiculo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarUsuarioVehiculo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id_usuario = Integer.parseInt(request.getParameter("id_usuario"));
		int id_vehiculo = Integer.parseInt(request.getParameter("id_vehiculo"));
		
		ModeloUsuarioVehiculo modeloUsuarioVehiculo = new ModeloUsuarioVehiculo();
		modeloUsuarioVehiculo.conectar();
		
		modeloUsuarioVehiculo.eliminarUsuarioVehiculo(id_usuario, id_vehiculo);
		
		modeloUsuarioVehiculo.cerrar();
		
		request.getRequestDispatcher("MostrarUsuarioVehiculo").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
