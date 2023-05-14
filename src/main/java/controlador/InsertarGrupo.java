package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modeloDAO.ModeloGrupo;
import modeloDAO.ModeloMonitor;
import modeloDTO.Grupo;
import modeloDTO.Manager;
import modeloDTO.Monitor;

/**
 * Inserta grupo
 */
@WebServlet("/InsertarGrupo")
public class InsertarGrupo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarGrupo() {
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
			ModeloMonitor modeloMonitor = new ModeloMonitor();
			modeloMonitor.conectar();
			
			ArrayList<Monitor> monitores = modeloMonitor.getMonitoresSinGrupo();
			
			modeloMonitor.cerrar();
			
			request.setAttribute("monitores", monitores);
			request.getRequestDispatcher("grupos/insertarGrupo.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("error404.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id_monitor = Integer.parseInt(request.getParameter("id_monitor"));
		
		ModeloGrupo modeloGrupo = new ModeloGrupo();
		modeloGrupo.conectar();
		
		modeloGrupo.insertarGrupo(id_monitor);
		
		modeloGrupo.cerrar();
		
		HttpSession session = request.getSession();
		
		Manager manager = (Manager) session.getAttribute("manager");
		
		if (manager != null) {
			response.sendRedirect("VistaManager");
		}else {
			request.getRequestDispatcher("error404.jsp").forward(request, response);
		}
	}

}
