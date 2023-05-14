package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modeloDAO.ModeloParcela;
import modeloDTO.Limpieza;

/**
 * Limpia una parcela que este sin limpiar
 */
@WebServlet("/LimpiarParcela")
public class LimpiarParcela extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LimpiarParcela() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		Limpieza limpieza = (Limpieza) session.getAttribute("limpieza");
		
		if (limpieza != null) {
			int id_parcela = Integer.parseInt(request.getParameter("id_parcela"));
			
			ModeloParcela modeloParcela = new ModeloParcela();
			modeloParcela.conectar();
			
			modeloParcela.limpiarParcela(id_parcela);
			
			modeloParcela.cerrar();
			
			response.sendRedirect("VistaLimpieza");
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
