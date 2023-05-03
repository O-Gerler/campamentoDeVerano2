package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modeloDAO.ModeloMascota;
import modeloDTO.Mascota;

/**
 * Servlet implementation class MostrarMascotas
 */
@WebServlet("/MostrarMascotas")
public class MostrarMascotas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarMascotas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModeloMascota modeloMascota = new ModeloMascota();
		modeloMascota.conectar();
		
		ArrayList<Mascota> mascotas = modeloMascota.getAllMascota();
		
		modeloMascota.cerrar();
		
		request.setAttribute("mascotas", mascotas);
		request.getRequestDispatcher("mascotas/verMascotas.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
