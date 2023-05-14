package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modeloDAO.ModeloActividadesGrupo;
import modeloDAO.ModeloCliente;
import modeloDAO.ModeloUsuario;
import modeloDTO.ActividadesPorGrupo;
import modeloDTO.Cliente;
import modeloDTO.Monitor;
import modeloDTO.Usuario;

/**
 * Muestra la vista del usuario Monitor
 */
@WebServlet("/VistaMonitor")
public class VistaMonitor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VistaMonitor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		Monitor monitor = (Monitor) session.getAttribute("monitor");
		
		if (monitor != null) {
			ModeloActividadesGrupo modeloActividadesGrupo = new ModeloActividadesGrupo();
			modeloActividadesGrupo.conectar();
			
			ArrayList<ActividadesPorGrupo> actividadesPorGrupos = modeloActividadesGrupo.getActividadesViaMonitor(monitor.getId());
			
			modeloActividadesGrupo.cerrar();
			
			ModeloCliente modeloCliente = new ModeloCliente();
			modeloCliente.conectar();
			
			ArrayList<Cliente> clientes = modeloCliente.getClientesPorMonitor(monitor.getId());
			
			modeloCliente.cerrar();
			
			ModeloUsuario modeloUsuario = new ModeloUsuario();
			modeloUsuario.conectar();
			
			Usuario usuario = modeloUsuario.getUsuarios(monitor.getId());
			
			modeloUsuario.cerrar();
			
			request.setAttribute("clientes", clientes);
			request.setAttribute("actividadesPorGrupos", actividadesPorGrupos);
			request.setAttribute("usuario", usuario);
			request.getRequestDispatcher("vistaMonitor/vistaMonitor.jsp").forward(request, response);
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
