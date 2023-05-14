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
import modeloDAO.ModeloMonitor;
import modeloDAO.ModeloRecepcion;
import modeloDTO.Limpieza;
import modeloDTO.Manager;
import modeloDTO.Monitor;
import modeloDTO.Recepcion;

/**
 * Comprueba el login del personal depende de cada rol
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
		request.getRequestDispatcher("login/loginPersonal.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String dni = request.getParameter("dni");
		String contrasena = request.getParameter("contrasena");
		int id_rol = Integer.parseInt(request.getParameter("id_rol"));
		boolean sesionCorrecta = false;
		
		switch (id_rol) {
		case Roles.MONITOR: 
			ModeloMonitor modeloMonitor = new ModeloMonitor();
			modeloMonitor.conectar();
			
			ArrayList<Monitor> monitores = modeloMonitor.getAllMonitor();
			
			for (Monitor monitor : monitores) {
				if (monitor.getDni().equals(dni) && monitor.getContrasena().equals(contrasena)) {
					HttpSession sesion = request.getSession();

					sesion.setAttribute("monitor", monitor);
					System.out.println("b");
					
					response.sendRedirect("VistaMonitor");
					sesionCorrecta = true;
//					request.getRequestDispatcher("vistaMonitor/vistaMonitor.jsp").forward(request, response);
				}
			}
			
			break;
		case Roles.LIMPIEZA: 
			ModeloLimpieza modeloLimpieza = new ModeloLimpieza();
			modeloLimpieza.conectar();
			
			ArrayList<Limpieza> limpiezas = modeloLimpieza.getAllLimpieza();
			
			for (Limpieza limpieza : limpiezas) {
				if (limpieza.getDni().equals(dni) && limpieza.getContrasena().equals(contrasena)) {
					HttpSession sesion = request.getSession();

					sesion.setAttribute("limpieza", limpieza);
					
					response.sendRedirect("VistaLimpieza");
					sesionCorrecta = true;
				}
			}
		case Roles.RECEPCION: 
			ModeloRecepcion modeloRecepcion = new ModeloRecepcion();
			modeloRecepcion.conectar();
			
			ArrayList<Recepcion> recepcions = modeloRecepcion.getAllRecepcion();
			
			for (Recepcion recepcion : recepcions) {
				if (recepcion.getDni().equals(dni) && recepcion.getContrasena().equals(contrasena)) {
					HttpSession sesion = request.getSession();

					sesion.setAttribute("recepcion", recepcion);
					
					response.sendRedirect("VistaRecepcion");
					sesionCorrecta = true;
				}
			}
			break;
		case Roles.ADMIN: 
			if (dni.equals(Manager.USER_ADMIN) && contrasena.equals(Manager.PASSWORD_ADMIN)) {
				Manager manager = new Manager();
				
				HttpSession session = request.getSession();
				
				session.setAttribute("manager", manager);
				
				response.sendRedirect("VistaManager");
				sesionCorrecta = true;
			}
			break;
		}
		
		if (!sesionCorrecta) {
			request.setAttribute("incorrecto", true);
			request.getRequestDispatcher("login/loginPersonal.jsp").forward(request, response);
		}		
	}

}
