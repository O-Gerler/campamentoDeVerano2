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
 * Servlet implementation class ModificarTipo
 */
@WebServlet("/ModificarTipo")
public class ModificarTipo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarTipo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		
		ModeloTipo modeloTipo = new ModeloTipo();
		modeloTipo.conectar();
		
		Tipo tipo = modeloTipo.getTipo(id);
		
		modeloTipo.cerrar();
		
		request.setAttribute("tipo", tipo);
		request.getRequestDispatcher("tipos/modificarTipo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		int cantidadPersonas = Integer.parseInt(request.getParameter("cantidad_personas"));
		String descripcion = request.getParameter("descripcion");
		
		Tipo tipo = new Tipo();
		
		tipo.setId(id);
		tipo.setNombre(nombre);
		tipo.setCantidad_personas(cantidadPersonas);
		tipo.setDescripcion(descripcion);
		
		ModeloTipo modeloTipo = new ModeloTipo();
		modeloTipo.conectar();
		
		modeloTipo.modificarTipo(tipo);
		
		modeloTipo.cerrar();
		
		request.getRequestDispatcher("MostrarTipos").forward(request, response);
	}

}
