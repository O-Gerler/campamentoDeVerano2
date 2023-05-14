package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modeloDAO.ModeloReserva;
import modeloDAO.ModeloUsuario;
import modeloDTO.Recepcion;
import modeloDTO.Reserva;
import modeloDTO.Usuario;

/**
 * Muestra todas las reservas hechas por un usuario
 */
@WebServlet("/MostrarReservas")
public class MostrarReservas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarReservas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		
		if (usuario != null) {
			ModeloReserva modeloReserva = new ModeloReserva();
			modeloReserva.conectar();
			
			ArrayList<Reserva> reservas = modeloReserva.getReservasUsuario(usuario.getId());
			
			modeloReserva.cerrar();
			
			ModeloUsuario modeloUsuario = new ModeloUsuario();
			modeloUsuario.conectar();
			
			usuario = modeloUsuario.getUsuarios(usuario.getId());
			
			modeloUsuario.cerrar();
			
			request.setAttribute("usuario", usuario);
			request.setAttribute("reservas", reservas);
			request.getRequestDispatcher("reservas/verReservas.jsp").forward(request, response);
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
