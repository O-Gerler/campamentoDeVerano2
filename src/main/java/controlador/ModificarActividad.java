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
 * Modifica una actividad
 */
@WebServlet("/ModificarActividad")
public class ModificarActividad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarActividad() {
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
			int id = Integer.parseInt(request.getParameter("id"));
			
			ModeloActividad modeloActividad = new ModeloActividad();
			ModeloZona modeloZona = new ModeloZona();
			
			modeloActividad.conectar();
			modeloZona.conectar();
			
			Actividad actividad = modeloActividad.getActividad(id);
			ArrayList<Zona> zonas = modeloZona.getAllZonas();
			
			modeloActividad.cerrar();
			modeloZona.cerrar();
			
			request.setAttribute("actividad", actividad);
			request.setAttribute("zonas", zonas);
			
			request.getRequestDispatcher("actividades/modificarActividad.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("error404.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		int id_zona = Integer.parseInt(request.getParameter("id_zona"));
		String nombre = request.getParameter("nombre");
		int cantidad_max = Integer.parseInt(request.getParameter("cantidad_max"));
		int edad_min = Integer.parseInt(request.getParameter("edad_min"));
		
		Actividad actividad = new Actividad();
		
		ModeloZona modeloZona = new ModeloZona();
		modeloZona.conectar();
		
		actividad.setId(id);
		actividad.setZona(modeloZona.getZona(id_zona));
		actividad.setNombre(nombre);
		actividad.setCantidad_max(cantidad_max);
		actividad.setEdad_min(edad_min);
		
		ModeloActividad modeloActividad = new ModeloActividad();
		modeloActividad.conectar();
		
		modeloActividad.modificarActividad(actividad);
		
		modeloZona.cerrar();
		modeloActividad.cerrar();
		
		HttpSession session = request.getSession();
		
		Manager manager = (Manager) session.getAttribute("manager");
		
		if (manager != null) {
			response.sendRedirect("VistaManager");
		}else {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

}
