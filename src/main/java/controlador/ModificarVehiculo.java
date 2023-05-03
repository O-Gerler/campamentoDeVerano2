package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modeloDAO.ModeloVehiculos;
import modeloDTO.Vehiculo;

/**
 * Servlet implementation class ModificarVehiculo
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		
		ModeloVehiculos modeloVehiculos = new ModeloVehiculos();
		modeloVehiculos.conectar();
		
		Vehiculo vehiculo = modeloVehiculos.getVehiculo(id);
		
		modeloVehiculos.cerrar();
		
		request.setAttribute("vehiculo", vehiculo);
		request.getRequestDispatcher("vehiculos/modificarVehiculo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		request.getRequestDispatcher("MostrarVehiculos").forward(request, response);
	}

}
