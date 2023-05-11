package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modeloDAO.ModeloPersonal;
import modeloDTO.Manager;
import modeloDTO.Personal;

/**
 * Servlet implementation class ModificarPersonal
 */
@WebServlet("/ModificarPersonal")
public class ModificarPersonal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarPersonal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		Manager manager = (Manager) session.getAttribute("manager");
		
		if (manager != null) {
			int id = Integer.parseInt(request.getParameter("id"));
			
			ModeloPersonal modeloPersonal = new ModeloPersonal();
			modeloPersonal.conectar();
			
			Personal personal = modeloPersonal.getPersonal(id);
			ArrayList<Personal> personales = modeloPersonal.getAllPersonal();
			
			modeloPersonal.cerrar();
			
			request.setAttribute("personal", personal);
			request.setAttribute("personales", personales);
			request.getRequestDispatcher("personal/modificarPersonal.jsp").forward(request, response);
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
