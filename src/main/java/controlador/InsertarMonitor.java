package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modeloDAO.ModeloMonitor;
import modeloDAO.ModeloPersonal;
import modeloDTO.Manager;
import modeloDTO.Personal;

/**
 * Inserta monitor
 */
@WebServlet("/InsertarMonitor")
public class InsertarMonitor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarMonitor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		Manager manager = (Manager) session.getAttribute("manager");
		
		if (manager != null) {
			ModeloPersonal modeloPersonal = new ModeloPersonal();
			modeloPersonal.conectar();
			
			ArrayList<Personal> personales = modeloPersonal.getPersonalSinRol();
			
			modeloPersonal.cerrar();
			
			request.setAttribute("personales", personales);
			request.getRequestDispatcher("monitores/insertarMonitor.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("error404.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id_monitor = Integer.parseInt(request.getParameter("id_monitor"));
		
		ModeloMonitor modeloMonitor = new ModeloMonitor();
		modeloMonitor.conectar();
		
		modeloMonitor.insertarMonitor(id_monitor);
		
		modeloMonitor.cerrar();
		
		HttpSession session = request.getSession();
		
		Manager manager = (Manager) session.getAttribute("manager");
		
		if (manager != null) {
			response.sendRedirect("VistaManager");
		}else {
			request.getRequestDispatcher("error404.jsp").forward(request, response);
		}
	}

}
