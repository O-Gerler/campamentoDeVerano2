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
import modeloDTO.Cliente;
import modeloDTO.Recepcion;

/**
 * Servlet implementation class VistaRecepcion
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
			
			request.setAttribute("clientes", clientes);
			
			request.getRequestDispatcher("vistaRecepcion/vistaRecepcion.jsp").forward(request, response);
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
