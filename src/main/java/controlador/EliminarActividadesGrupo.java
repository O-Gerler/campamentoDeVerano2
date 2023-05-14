package controlador;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modeloDAO.ModeloActividadesGrupo;
import modeloDTO.Manager;
import modeloDTO.Monitor;

/**
 * Elimina una actividadPorGrupo
 */
@WebServlet("/EliminarActividadesGrupo")
public class EliminarActividadesGrupo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarActividadesGrupo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		Manager manager = (Manager) session.getAttribute("manager");
		
		Monitor monitor = (Monitor) session.getAttribute("monitor");
		
		if (manager != null || monitor != null) {
			int id_actividad = Integer.parseInt(request.getParameter("id_actividad"));
			int id_grupo = Integer.parseInt(request.getParameter("id_grupo"));
			String fecha = request.getParameter("fecha");
			String hora = request.getParameter("hora");
			
			Date fechaActividad = null;
			
			try {
				fechaActividad = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			ModeloActividadesGrupo modeloActividadesGrupo = new ModeloActividadesGrupo();
			modeloActividadesGrupo.conectar();
			
			modeloActividadesGrupo.eliminarActividadGrupo(id_actividad, id_grupo, fechaActividad, hora);
			
			if (manager != null) {
				response.sendRedirect("VistaManager");
			}else {
				response.sendRedirect("VistaMonitor");
			}
		}else {
			request.getRequestDispatcher("error404.jsp").forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
