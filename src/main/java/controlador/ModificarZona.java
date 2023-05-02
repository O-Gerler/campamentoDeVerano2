package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modeloDAO.ModeloZona;
import modeloDTO.Zona;

/**
 * Servlet implementation class ModificarZona
 */
@WebServlet("/ModificarZona")
public class ModificarZona extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarZona() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		
		ModeloZona modeloZona = new ModeloZona();
		modeloZona.conectar();
		
		Zona zona = modeloZona.getZona(id);
		
		modeloZona.cerrar();
		
		request.setAttribute("zona", zona);
		request.getRequestDispatcher("zonas/modificarZona.jsp").forward(request, response);;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		
		Zona zona = new Zona();
		
		zona.setId(id);
		zona.setNombre(nombre);
		zona.setDescripcion(descripcion);
		
		ModeloZona modeloZona = new ModeloZona();
		modeloZona.conectar();
		
		modeloZona.modificarZona(zona);
		
		modeloZona.cerrar();
		
		request.getRequestDispatcher("MostrarZonas").forward(request, response);
	}

}
