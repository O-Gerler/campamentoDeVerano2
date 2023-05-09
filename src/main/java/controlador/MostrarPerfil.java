package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modeloDTO.Usuario;

/**
 * Servlet implementation class MostrarPerfil
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
			request.setAttribute("usuario", usuario);
			System.out.println("a");
			request.getRequestDispatcher("usuarios/modificarUsuario.jsp").forward(request, response);
		}else if (monitor != null) {
			request.setAttribute("usuario", monitor);
			System.out.println("b");
			request.getRequestDispatcher("usuarios/modificarUsuario.jsp").forward(request, response);
		}else if (recepcion != null) {
			request.setAttribute("usuario", recepcion);
			System.out.println("c");
			request.getRequestDispatcher("usuarios/modificarUsuario.jsp").forward(request, response);
		}else if (limpieza != null) {
			request.setAttribute("usuario", limpieza);
			System.out.println("d");
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
