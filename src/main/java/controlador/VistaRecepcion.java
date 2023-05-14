package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modeloDAO.ModeloCliente;
import modeloDAO.ModeloReserva;
import modeloDAO.ModeloUsuario;
import modeloDTO.Cliente;
import modeloDTO.Recepcion;
import modeloDTO.Reserva;
import modeloDTO.Usuario;

/**
 * Muestra la vista del usuario recepcion
 */
@WebServlet("/VistaRecepcion")
public class VistaRecepcion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VistaRecepcion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sesion = request.getSession();
		
		Recepcion recepcion = (Recepcion) sesion.getAttribute("recepcion");
		
		if (recepcion != null) {
			ModeloCliente modeloCliente = new ModeloCliente();
			modeloCliente.conectar();
			
			ArrayList<Cliente> clientes = modeloCliente.getAllClientes();
			
			modeloCliente.cerrar();
			
			ModeloReserva modeloReserva = new ModeloReserva();
			modeloReserva.conectar();
			
			ArrayList<Reserva> reservas = modeloReserva.getAllReservas();
			
			modeloReserva.cerrar();
			
			ModeloUsuario modeloUsuario = new ModeloUsuario();
			modeloUsuario.conectar();
			
			Usuario usuario = modeloUsuario.getUsuarios(recepcion.getId());
			
			modeloUsuario.cerrar();
			
			request.setAttribute("usuario", usuario);
			request.setAttribute("clientes", clientes);
			request.setAttribute("reservas", reservas);
			request.getRequestDispatcher("vistaRecepcion/vistaRecepcion.jsp").forward(request, response);
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
