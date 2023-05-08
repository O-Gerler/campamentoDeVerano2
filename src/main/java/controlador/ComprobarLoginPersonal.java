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
import modeloDTO.Monitor;
import modeloDTO.Recepcion;

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
				}
			}
			break;
		case Roles.ADMIN: 
			break;
		default:
			response.sendRedirect("login/loginPersonal.jsp");
		}
	}

}
