package controlador;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modeloDAO.ModeloPersonal;
import modeloDTO.Manager;
import modeloDTO.Personal;

/**
 * Modifica un personal
 */
@WebServlet("/ModificarPersonal")
public class ModificarPersonal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarPersonal() {
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
			
			ModeloPersonal modeloPersonal = new ModeloPersonal();
			modeloPersonal.conectar();
			
			Personal personal = modeloPersonal.getPersonal(id);
			ArrayList<Personal> personales = modeloPersonal.getAllPersonal();
			
			modeloPersonal.cerrar();
			
			request.setAttribute("personal", personal);
			request.setAttribute("personales", personales);
			request.getRequestDispatcher("personal/modificarPersonal.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("error404.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id_personal = Integer.parseInt(request.getParameter("id_personal"));
		String fecha_ingreso = request.getParameter("fecha_ingreso");
		int dirige = Integer.parseInt(request.getParameter("dirige"));
		
		Date fechaIngreso = null;
		try {
			fechaIngreso = new SimpleDateFormat("yyyy-MM-dd").parse(fecha_ingreso);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Personal personal = new Personal();
		
		personal.setId(id_personal);
		personal.setFechaIngreso(fechaIngreso);
		personal.setDirector(dirige);
		
		ModeloPersonal modeloPersonal = new ModeloPersonal();
		modeloPersonal.conectar();
		
		modeloPersonal.modificarPersonal(personal);
		
		modeloPersonal.cerrar();
		
		HttpSession session = request.getSession();
		
		Manager manager = (Manager) session.getAttribute("manager");
		
		if (manager != null) {
			response.sendRedirect("VistaManager");
		}else {
			request.getRequestDispatcher("error404.jsp").forward(request, response);
		}
	}

}
