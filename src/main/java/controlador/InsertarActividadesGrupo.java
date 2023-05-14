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

import modeloDAO.ModeloActividad;
import modeloDAO.ModeloActividadesGrupo;
import modeloDAO.ModeloGrupo;
import modeloDTO.Actividad;
import modeloDTO.ActividadesPorGrupo;
import modeloDTO.Grupo;
import modeloDTO.Manager;
import modeloDTO.Monitor;

/**
 * Inserta una actividad por grupo
 */
@WebServlet("/InsertarActividadesGrupo")
public class InsertarActividadesGrupo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarActividadesGrupo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		Monitor monitor = (Monitor) session.getAttribute("monitor");
		
		Manager manager = (Manager) session.getAttribute("manager");
		
		if (manager != null || monitor != null) {
			ModeloActividad modeloActividad = new ModeloActividad();
			modeloActividad.conectar();
			
			ArrayList<Actividad> actividades = modeloActividad.getAllActividades();
			
			modeloActividad.cerrar();
			
			ModeloGrupo modeloGrupo = new ModeloGrupo();
			modeloGrupo.conectar();
			
			ArrayList<Grupo> grupos = modeloGrupo.getAllGrupos();
			
			modeloGrupo.cerrar();
			
			request.setAttribute("actividades", actividades);
			request.setAttribute("grupos", grupos);
			request.getRequestDispatcher("actividadesPorGrupo/insertar.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("error404.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		ActividadesPorGrupo actividadesPorGrupo = new ActividadesPorGrupo();
		
		ModeloActividad modeloActividad = new ModeloActividad();
		modeloActividad.conectar();
		
		actividadesPorGrupo.setActividad(modeloActividad.getActividad(id_actividad));
		
		modeloActividad.cerrar();
		
		ModeloGrupo modeloGrupo = new ModeloGrupo();
		modeloGrupo.conectar();
		
		actividadesPorGrupo.setGrupo(modeloGrupo.getGrupo(id_grupo));
		
		modeloGrupo.cerrar();
		
		actividadesPorGrupo.setFecha(fechaActividad);
		actividadesPorGrupo.setHora(hora);
		
		ModeloActividadesGrupo modeloActividadesGrupo = new ModeloActividadesGrupo();
		modeloActividadesGrupo.conectar();
		
		if (modeloActividadesGrupo.getActividadesPorGrupoRepetida(actividadesPorGrupo) == null) {
			modeloActividadesGrupo.insertarActividadGrupo(actividadesPorGrupo);
			
			modeloActividadesGrupo.cerrar();
			
			HttpSession session = request.getSession();
			
			Monitor monitor = (Monitor) session.getAttribute("monitor");
			
			Manager manager = (Manager) session.getAttribute("manager");
			
			if (manager != null) {
				response.sendRedirect("VistaManager");
			}else if (monitor != null) {
				response.sendRedirect("VistaMonitor");
			}else {
				request.getRequestDispatcher("error404.jsp").forward(request, response);
			}
		}else {
			request.setAttribute("incorrecto", true);
			doGet(request, response);
		}
		
		
	}

}
