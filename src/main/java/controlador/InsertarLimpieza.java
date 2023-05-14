package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modeloDAO.ModeloLimpieza;
import modeloDAO.ModeloPersonal;
import modeloDAO.ModeloZona;
import modeloDTO.Manager;
import modeloDTO.Personal;
import modeloDTO.Zona;

/**
 * Inserta personal de limpieza
 */
@WebServlet("/InsertarLimpieza")
public class InsertarLimpieza extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarLimpieza() {
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
			ModeloPersonal modeloPersonal = new ModeloPersonal();
			modeloPersonal.conectar();
			
			ArrayList<Personal> personales = modeloPersonal.getPersonalSinRol();
			
			modeloPersonal.cerrar();
			
			ModeloZona modeloZona = new ModeloZona();
			modeloZona.conectar();
			
			ArrayList<Zona> zonas = modeloZona.getAllZonas();
			
			modeloZona.cerrar();
			
			request.setAttribute("personales", personales);
			request.setAttribute("zonas", zonas);
			request.getRequestDispatcher("limpieza/insertarLimpieza.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("error404.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id_limpieza = Integer.parseInt(request.getParameter("id_limpieza"));
		int id_zona = Integer.parseInt(request.getParameter("id_zona"));
		
		ModeloLimpieza modeloLimpieza = new ModeloLimpieza();
		modeloLimpieza.conectar();
		
		modeloLimpieza.insertarLimpieza(id_limpieza, id_zona);
		
		modeloLimpieza.cerrar();
		
		HttpSession session = request.getSession();
		
		Manager manager = (Manager) session.getAttribute("manager");
		
		if (manager != null) {
			response.sendRedirect("VistaManager");
		}else {
			request.getRequestDispatcher("error404.jsp").forward(request, response);
		}
	}

}
