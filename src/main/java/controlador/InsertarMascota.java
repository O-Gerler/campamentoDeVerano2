package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modeloDAO.ModeloMascota;
import modeloDTO.Mascota;

/**
 * Servlet implementation class InsertarMascota
 */
@WebServlet("/InsertarMascota")
public class InsertarMascota extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarMascota() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("mascotas/insertarMascota.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nombre = request.getParameter("nombre");
		String numChip = request.getParameter("numChip");
		String raza = request.getParameter("raza");
		
		Mascota mascota = new Mascota();
		
		mascota.setNombre(nombre);
		mascota.setNumChip(numChip);
		mascota.setRaza(raza);
		
		ModeloMascota modeloMascota = new ModeloMascota();
		modeloMascota.conectar();
		
		modeloMascota.insertarMascota(mascota);
		
		modeloMascota.cerrar();
		
		request.getRequestDispatcher("MostrarMascotas").forward(request, response);
	}

}
