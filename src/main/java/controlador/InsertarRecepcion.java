package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modeloDAO.ModeloPersonal;
import modeloDAO.ModeloRecepcion;
import modeloDTO.Manager;
import modeloDTO.Personal;

/**
 * Inserta una recepcion
 */
@WebServlet("/InsertarRecepcion")
public class InsertarRecepcion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarRecepcion() {
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
			
			request.setAttribute("personales", personales);
			request.getRequestDispatcher("recepcion/insertarRecepcion.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("error404.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id_recepcion = Integer.parseInt(request.getParameter("id_recepcion"));
		
		ModeloRecepcion modeloRecepcion = new ModeloRecepcion();
		modeloRecepcion.conectar();
		
		modeloRecepcion.insertarRecepcion(id_recepcion);
		
		modeloRecepcion.cerrar();
		
		HttpSession session = request.getSession();
		
		Manager manager = (Manager) session.getAttribute("manager");
		
		if (manager != null) {
			response.sendRedirect("VistaManager");
		}else {
			request.getRequestDispatcher("error404.jsp").forward(request, response);
		}
	}

}
