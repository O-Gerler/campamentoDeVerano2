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
import modeloDAO.ModeloZona;
import modeloDTO.Limpieza;
import modeloDTO.Manager;
import modeloDTO.Zona;

/**
 * Modifica la zona de limpieza
 */
@WebServlet("/ModificarLimpieza")
public class ModificarLimpieza extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarLimpieza() {
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
			
			ModeloLimpieza modeloLimpieza = new ModeloLimpieza();
			modeloLimpieza.conectar();
			
			Limpieza limpieza =  modeloLimpieza.getLimpieza(id);
			
			modeloLimpieza.cerrar();
			
			ModeloZona modeloZona = new ModeloZona();
			modeloZona.conectar();
			
			ArrayList<Zona> zonas = modeloZona.getAllZonas();
			
			modeloZona.cerrar();
			
			request.setAttribute("limpieza", limpieza);
			request.setAttribute("zonas", zonas);
			request.getRequestDispatcher("limpieza/modificarLimpieza.jsp").forward(request, response);
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
		
		modeloLimpieza.modificarLimpieza(id_limpieza, id_zona);
		
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
