package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modeloDAO.ModeloLimpieza;
import modeloDAO.ModeloMonitor;
import modeloDAO.ModeloRecepcion;
import modeloDAO.ModeloUsuario;
import modeloDTO.Usuario;

/**
 * Muestra el perfil de cada usuario 
 */
@WebServlet("/MostrarPerfil")
public class MostrarPerfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarPerfil() {
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
		
		Usuario monitor = (Usuario) session.getAttribute("monitor");
		
		Usuario recepcion = (Usuario) session.getAttribute("recepcion");
		
		Usuario limpieza = (Usuario) session.getAttribute("limpieza");
		
		if (usuario != null) {
			ModeloUsuario modeloUsuario = new ModeloUsuario();
			modeloUsuario.conectar();
			
			usuario = modeloUsuario.getUsuarios(usuario.getId());
			
			modeloUsuario.cerrar();
			request.setAttribute("usuario", usuario);
			request.getRequestDispatcher("usuarios/modificarUsuario.jsp").forward(request, response);
		}else if (monitor != null) {
			ModeloMonitor modeloMonitor = new ModeloMonitor();
			modeloMonitor.conectar();
			
			monitor = modeloMonitor.getMonitor(monitor.getId());
			
			modeloMonitor.cerrar();
			request.setAttribute("usuario", monitor);
			request.getRequestDispatcher("usuarios/modificarUsuario.jsp").forward(request, response);
		}else if (recepcion != null) {
			ModeloRecepcion modeloRecepcion = new ModeloRecepcion();
			modeloRecepcion.conectar();
			
			recepcion = modeloRecepcion.getRecepcion(recepcion.getId());
			
			modeloRecepcion.cerrar();
			request.setAttribute("usuario", recepcion);
			request.getRequestDispatcher("usuarios/modificarUsuario.jsp").forward(request, response);
		}else if (limpieza != null) {
			ModeloLimpieza modeloLimpieza = new ModeloLimpieza();
			modeloLimpieza.conectar();
			
			limpieza = modeloLimpieza.getLimpieza(limpieza.getId());
			
			modeloLimpieza.cerrar();
			request.setAttribute("usuario", limpieza);
			request.getRequestDispatcher("usuarios/modificarUsuario.jsp").forward(request, response);
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
