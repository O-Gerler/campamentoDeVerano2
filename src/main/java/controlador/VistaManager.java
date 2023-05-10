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
import modeloDAO.ModeloLimpieza;
import modeloDAO.ModeloMonitor;
import modeloDAO.ModeloPersonal;
import modeloDAO.ModeloRecepcion;
import modeloDAO.ModeloUsuario;
import modeloDTO.Cliente;
import modeloDTO.Limpieza;
import modeloDTO.Manager;
import modeloDTO.Monitor;
import modeloDTO.Personal;
import modeloDTO.Recepcion;
import modeloDTO.Usuario;

/**
 * Servlet implementation class VistaManager
 */
@WebServlet("/VistaManager")
public class VistaManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VistaManager() {
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
		
		if (manager != null) {
			ModeloUsuario modeloUsuario = new ModeloUsuario();
			ModeloCliente modeloCliente = new ModeloCliente();
			ModeloPersonal modeloPersonal = new ModeloPersonal();
			ModeloMonitor modeloMonitor = new ModeloMonitor();
			ModeloLimpieza modeloLimpieza = new ModeloLimpieza();
			ModeloRecepcion modeloRecepcion = new ModeloRecepcion();
			
			modeloUsuario.conectar();
			modeloCliente.conectar();
			modeloPersonal.conectar();
			modeloMonitor.conectar();
			modeloLimpieza.conectar();
			modeloRecepcion.conectar();
			
			ArrayList<Usuario> usuarios = modeloUsuario.getAllUsuarios();
			ArrayList<Cliente> clientes = modeloCliente.getAllClientes();
			ArrayList<Personal> personales = modeloPersonal.getAllPersonal();
			ArrayList<Monitor> monitores = modeloMonitor.getAllMonitor();
			ArrayList<Limpieza> limpiezas = modeloLimpieza.getAllLimpieza();
			ArrayList<Recepcion> recepciones = modeloRecepcion.getAllRecepcion();
			
			modeloUsuario.cerrar();
			modeloCliente.cerrar();
			modeloPersonal.cerrar();
			modeloMonitor.cerrar();
			modeloLimpieza.cerrar();
			modeloRecepcion.cerrar();
			
			request.setAttribute("usuarios", usuarios);
			request.setAttribute("clientes", clientes);
			request.setAttribute("personales", personales);
			request.setAttribute("monitores", monitores);
			request.setAttribute("limpiezas", limpiezas);
			request.setAttribute("recepciones", recepciones);
			request.getRequestDispatcher("vistaManager/vistaManager.jsp").forward(request, response);
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
