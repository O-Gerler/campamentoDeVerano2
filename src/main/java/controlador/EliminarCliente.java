package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modeloDAO.ModeloCliente;
import modeloDTO.Manager;
import modeloDTO.Recepcion;

/**
 * Elimina un cliente
 */
@WebServlet("/EliminarCliente")
public class EliminarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		Recepcion recepcion = (Recepcion) session.getAttribute("recepcion");
		
		Manager manager = (Manager) session.getAttribute("manager");
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		if (recepcion != null) {
			ModeloCliente modeloCliente = new ModeloCliente();
			modeloCliente.conectar();
			
			modeloCliente.eliminarCliente(id);
			
			modeloCliente.cerrar();
			
			response.sendRedirect("VistaRecepcion");
		}else if(manager != null) {
			ModeloCliente modeloCliente = new ModeloCliente();
			modeloCliente.conectar();
			
			modeloCliente.eliminarCliente(id);
			
			modeloCliente.cerrar();
			
			response.sendRedirect("VistaRecepcion");
		}else{
			request.getRequestDispatcher("Error404.jsp").forward(request, response);
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
