package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modeloDAO.ModeloActividad;
import modeloDAO.ModeloZona;
import modeloDTO.Actividad;
import modeloDTO.Manager;
import modeloDTO.Zona;

/**
 * Inserta una actividad
 */
@WebServlet("/InsertarActividad")
public class InsertarActividad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarActividad() {
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
			ModeloZona modeloZona = new ModeloZona();
			modeloZona.conectar();
			
			ArrayList<Zona> zonas = modeloZona.getAllZonas();
			
			modeloZona.cerrar();
			
			request.setAttribute("zonas", zonas);
			request.getRequestDispatcher("actividades/insertarActividad.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("error404.jsp").forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idZona = Integer.parseInt(request.getParameter("id_zona"));
		String nombre = request.getParameter("nombre");
		int cantidadMax = Integer.parseInt(request.getParameter("cantidad_max"));
		int edadMin = Integer.parseInt(request.getParameter("edad_min"));
		
		Actividad actividad = new Actividad();
		
		ModeloZona modeloZona = new ModeloZona();
		modeloZona.conectar();
		
		actividad.setZona(modeloZona.getZona(idZona));
		actividad.setNombre(nombre);
		actividad.setCantidad_max(cantidadMax);
		actividad.setEdad_min(edadMin);
		
		modeloZona.cerrar();
		
		ModeloActividad modeloActividad = new ModeloActividad();
		modeloActividad.conectar();
		
		modeloActividad.insertarActividad(actividad);
		
		modeloActividad.cerrar();
		
		HttpSession session = request.getSession();
		
		Manager manager = (Manager) session.getAttribute("manager");
		
		if (manager != null) {
			response.sendRedirect("VistaManager");
		}else {
			request.getRequestDispatcher("error404.jsp").forward(request, response);
		}
		
	}

}
