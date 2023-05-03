package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modeloDAO.ModeloTipo;
import modeloDTO.Tipo;

/**
 * Servlet implementation class InsertarTipo
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
		// TODO Auto-generated method stub
		request.getRequestDispatcher("tipos/insertarTipo.jsp").forward(request, response);
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
		
		request.getRequestDispatcher("MostrarTipos").forward(request, response);
	}

}
