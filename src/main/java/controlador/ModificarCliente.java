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
import modeloDAO.ModeloGrupo;
import modeloDTO.Cliente;
import modeloDTO.Grupo;
import modeloDTO.Manager;
import modeloDTO.Recepcion;

/**
 * Servlet implementation class ModificarCliente
 */
@WebServlet("/ModificarCliente")
public class ModificarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		Manager manager = (Manager) session.getAttribute("manager");
		
		Recepcion recepcion = (Recepcion) session.getAttribute("recepcion");
		
		if (manager != null || recepcion != null) {
			int id = Integer.parseInt(request.getParameter("id"));
			
			ModeloCliente modeloCliente = new ModeloCliente();
			modeloCliente.conectar();
			
			Cliente cliente = modeloCliente.getCliente(id);
			
			modeloCliente.cerrar();
			
			ModeloGrupo modeloGrupo = new ModeloGrupo();
			modeloGrupo.conectar();
			
			ArrayList<Grupo> grupos = modeloGrupo.getAllGrupos();
			
			modeloGrupo.cerrar();
			
			request.setAttribute("cliente", cliente);
			request.setAttribute("grupos", grupos);
			request.getRequestDispatcher("clientes/modificarCliente.jsp").forward(request, response);
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
