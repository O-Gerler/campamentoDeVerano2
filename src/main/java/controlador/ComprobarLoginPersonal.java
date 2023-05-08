package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modeloDAO.ModeloMonitor;
import modeloDTO.Monitor;

/**
 * Servlet implementation class ComprobarLoginPersonal
 */
@WebServlet("/ComprobarLoginPersonal")
public class ComprobarLoginPersonal extends HttpServlet implements Roles{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComprobarLoginPersonal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("login/loginPersonal.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String dni = request.getParameter("dni");
		String contrasena = request.getParameter("contrasena");
		int id_rol = Integer.parseInt(request.getParameter("id_rol"));
		
		switch (id_rol) {
		case Roles.MONITOR: 
			ModeloMonitor modeloMonitor = new ModeloMonitor();
			modeloMonitor.conectar();
			
			if (modeloMonitor.getLogin(dni, contrasena)) {
				HttpSession sesion = request.getSession();
				
				Monitor monitor = modeloMonitor.getMonitorViaDNI(dni);
				
				sesion.setAttribute("monitor", monitor);
				
				response.sendRedirect(contrasena);
			}
			
			break;
		case Roles.LIMPIEZA: 
			break;
		case Roles.RECEPCION: 
			break;
		case Roles.ADMIN: 
			break;
		default:
			response.sendRedirect("login/loginPersonal.jsp");
		}
	}

}
