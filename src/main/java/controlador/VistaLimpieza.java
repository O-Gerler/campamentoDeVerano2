package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modeloDAO.ModeloParcela;
import modeloDAO.ModeloUsuario;
import modeloDTO.Limpieza;
import modeloDTO.Parcela;
import modeloDTO.Usuario;

/**
 * Muestra la vista de usuario limpieza
 */
@WebServlet("/VistaLimpieza")
public class VistaLimpieza extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VistaLimpieza() {
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
			ModeloParcela modeloParcela = new ModeloParcela();
			modeloParcela.conectar();
			
			ArrayList<Parcela> parcelas = modeloParcela.getParcelasPorZona(limpieza.getZona().getId());
			
			modeloParcela.cerrar();
			
			ModeloUsuario modeloUsuario = new ModeloUsuario();
			modeloUsuario.conectar();
			
			Usuario usuario = modeloUsuario.getUsuarios(limpieza.getId());
			
			modeloUsuario.cerrar();
			
			request.setAttribute("usuario", usuario);
			request.setAttribute("parcelas", parcelas);
			request.getRequestDispatcher("vistaLimpieza/vistaLimpieza.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("vistaLimpieza/vistaLimpieza.jsp").forward(request, response);
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
