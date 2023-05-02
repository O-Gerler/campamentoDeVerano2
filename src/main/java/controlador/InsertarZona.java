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
 * Servlet implementation class InsertarZona
 */
@WebServlet("/InsertarZona")
public class InsertarZona extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarZona() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("zonas/insertarZona.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		
		Zona zona = new Zona();
		
		zona.setNombre(nombre);
		zona.setDescripcion(descripcion);
		
		ModeloZona modeloZona = new ModeloZona();
		modeloZona.conectar();
		
		modeloZona.insertarZona(zona);
		
		modeloZona.cerrar();
		
		request.getRequestDispatcher("MostrarZonas").forward(request, response);
	}

}
