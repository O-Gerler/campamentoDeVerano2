package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modeloDAO.ModeloTipo;
import modeloDTO.Manager;
import modeloDTO.Tipo;

/**
 * Inserta un tipo
 */
@WebServlet("/InsertarTipo")
public class InsertarTipo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarTipo() {
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
			request.getRequestDispatcher("tipos/insertarTipo.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("error404.jsp").forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nombre = request.getParameter("nombre");
		int cantidad_personas = Integer.parseInt(request.getParameter("cantidad_personas"));
		String descripcion = request.getParameter("descripcion");
		
		Tipo tipo = new Tipo();
		
		tipo.setNombre(nombre);
		tipo.setCantidad_personas(cantidad_personas);
		tipo.setDescripcion(descripcion);
		
		ModeloTipo modeloTipo = new ModeloTipo();
		modeloTipo.conectar();
		
		modeloTipo.insertarTipo(tipo);
		
		modeloTipo.cerrar();
		
		HttpSession session = request.getSession();
		
		Manager manager = (Manager) session.getAttribute("manager");
		
		if (manager != null) {
			response.sendRedirect("VistaManager");
		}else {
			request.getRequestDispatcher("error404.jsp").forward(request, response);
		}
	}

}
