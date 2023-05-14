package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modeloDAO.ModeloGrupo;
import modeloDAO.ModeloParcela;
import modeloDAO.ModeloTipo;
import modeloDAO.ModeloZona;
import modeloDTO.Grupo;
import modeloDTO.Manager;
import modeloDTO.Parcela;
import modeloDTO.Tipo;
import modeloDTO.Zona;

/**
 * Modifica una parcela
 */
@WebServlet("/ModificarParcela")
public class ModificarParcela extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarParcela() {
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
			
			ModeloParcela modeloParcela = new ModeloParcela();
			modeloParcela.conectar();
			
			Parcela parcela = modeloParcela.getParcela(id);
			
			modeloParcela.cerrar();
			
			ModeloGrupo modeloGrupo = new ModeloGrupo();
			ModeloZona modeloZona = new ModeloZona();
			ModeloTipo modeloTipo = new ModeloTipo();
			
			modeloGrupo.conectar();
			modeloZona.conectar();
			modeloTipo.conectar();
			
			ArrayList<Grupo> grupos = modeloGrupo.getGruposSinParcela();
			ArrayList<Zona> zonas = modeloZona.getAllZonas();
			ArrayList<Tipo> tipos = modeloTipo.getAllTipos();
			
			modeloGrupo.cerrar();
			modeloZona.cerrar();
			modeloTipo.cerrar();
			
			request.setAttribute("parcela", parcela);
			request.setAttribute("grupos", grupos);
			request.setAttribute("zonas", zonas);
			request.setAttribute("tipos", tipos);
			request.getRequestDispatcher("parcelas/modificarParcela.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("error404.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id_parcela = Integer.parseInt(request.getParameter("id_parcela"));
		int id_grupo = Integer.parseInt(request.getParameter("id_grupo"));
		int id_zona = Integer.parseInt(request.getParameter("id_zona"));
		int id_tipo = Integer.parseInt(request.getParameter("id_tipo"));
		
		ModeloParcela modeloParcela = new ModeloParcela();
		modeloParcela.conectar();
		
		modeloParcela.modificarParcela(id_parcela, id_grupo, id_tipo, id_zona);
		
		modeloParcela.cerrar();
		
		HttpSession session = request.getSession();
		
		Manager manager = (Manager) session.getAttribute("manager");
		
		if (manager != null) {
			response.sendRedirect("VistaManager");
		}else {
			request.getRequestDispatcher("error404.jsp").forward(request, response);
		}
	}

}
