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
import modeloDAO.ModeloUsuario;
import modeloDTO.Cliente;
import modeloDTO.Grupo;
import modeloDTO.Manager;
import modeloDTO.Recepcion;
import modeloDTO.Usuario;

/**
 * Inserta cliente
 */
@WebServlet("/InsertarCliente")
public class InsertarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarCliente() {
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
		
		Manager manager = (Manager) sesion.getAttribute("manager");
		
		if (recepcion != null || manager != null) {
			ModeloUsuario modeloUsuario = new ModeloUsuario();
			ModeloGrupo modeloGrupo = new ModeloGrupo();
			
			modeloGrupo.conectar();
			modeloUsuario.conectar();
			
			ArrayList<Usuario> usuarios = modeloUsuario.getAllUsuarios();
			ArrayList<Grupo> grupos = modeloGrupo.getAllGrupos();
			
			modeloGrupo.cerrar();
			modeloUsuario.cerrar();
			
			request.setAttribute("grupos", grupos);
			request.setAttribute("usuarios", usuarios);
			request.getRequestDispatcher("clientes/insertarCliente.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("error404.jsp").forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id_cliente = Integer.parseInt(request.getParameter("id_cliente"));
		int id_grupo = Integer.parseInt(request.getParameter("id_grupo"));
		
		ModeloUsuario modeloUsuario = new ModeloUsuario();
		ModeloGrupo modeloGrupo = new ModeloGrupo();
		
		modeloGrupo.conectar();
		modeloUsuario.conectar();
		
		Usuario usuario = modeloUsuario.getUsuarios(id_cliente);
		Grupo grupo = modeloGrupo.getGrupo(id_grupo);
		
		modeloGrupo.cerrar();
		modeloUsuario.cerrar();
		
		ModeloCliente modeloCliente = new ModeloCliente();
		modeloCliente.conectar();
		
		Cliente cliente = new Cliente();
		
		cliente.setId(usuario.getId());
		cliente.setGrupo(grupo);
		
		modeloCliente.insertarCliente(cliente);
		modeloCliente.cerrar();
		
		HttpSession sesion = request.getSession();
		
		Recepcion recepcion = (Recepcion) sesion.getAttribute("recepcion");
		
		Manager manager = (Manager) sesion.getAttribute("manager");
		
		if (recepcion != null) {
			request.getRequestDispatcher("VistaRecepcion").forward(request, response);
		}else if (manager != null) {
			request.getRequestDispatcher("VistaManager").forward(request, response);
		}else{
			request.getRequestDispatcher("error404.jsp").forward(request, response);
		}	
	}

}
