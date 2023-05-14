package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modeloDAO.ModeloActividad;
import modeloDAO.ModeloActividadesGrupo;
import modeloDAO.ModeloCliente;
import modeloDAO.ModeloGrupo;
import modeloDAO.ModeloLimpieza;
import modeloDAO.ModeloMonitor;
import modeloDAO.ModeloParcela;
import modeloDAO.ModeloPersonal;
import modeloDAO.ModeloRecepcion;
import modeloDAO.ModeloReserva;
import modeloDAO.ModeloTipo;
import modeloDAO.ModeloUsuario;
import modeloDAO.ModeloUsuarioVehiculo;
import modeloDAO.ModeloVehiculos;
import modeloDAO.ModeloZona;
import modeloDTO.Actividad;
import modeloDTO.ActividadesPorGrupo;
import modeloDTO.Cliente;
import modeloDTO.Grupo;
import modeloDTO.Limpieza;
import modeloDTO.Manager;
import modeloDTO.Monitor;
import modeloDTO.Parcela;
import modeloDTO.Personal;
import modeloDTO.Recepcion;
import modeloDTO.Reserva;
import modeloDTO.Tipo;
import modeloDTO.Usuario;
import modeloDTO.UsuarioVehiculo;
import modeloDTO.Vehiculo;
import modeloDTO.Zona;

/**
 * Muestra la vista del usuario manager
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
			
			ModeloActividad modeloActividad = new ModeloActividad();
			ModeloActividadesGrupo modeloActividadesGrupo = new ModeloActividadesGrupo();
			ModeloGrupo modeloGrupo = new ModeloGrupo();
			ModeloParcela modeloParcela = new ModeloParcela();
			ModeloReserva modeloReserva = new ModeloReserva();
			ModeloTipo modeloTipo = new ModeloTipo();
			ModeloVehiculos modeloVehiculos = new ModeloVehiculos();
			ModeloUsuarioVehiculo modeloUsuarioVehiculo = new ModeloUsuarioVehiculo();
			ModeloZona modeloZona = new ModeloZona();
			
			modeloUsuario.conectar();
			modeloCliente.conectar();
			modeloPersonal.conectar();
			modeloMonitor.conectar();
			modeloLimpieza.conectar();
			modeloRecepcion.conectar();
			
			modeloActividad.conectar();
			modeloActividadesGrupo.conectar();
			modeloGrupo.conectar();
			modeloParcela.conectar();
			modeloReserva.conectar();
			modeloTipo.conectar();
			modeloVehiculos.conectar();
			modeloUsuarioVehiculo.conectar();
			modeloZona.conectar();
			
			ArrayList<Usuario> usuarios = modeloUsuario.getAllUsuarios();
			ArrayList<Cliente> clientes = modeloCliente.getAllClientes();
			ArrayList<Personal> personales = modeloPersonal.getAllPersonal();
			ArrayList<Monitor> monitores = modeloMonitor.getAllMonitor();
			ArrayList<Limpieza> limpiezas = modeloLimpieza.getAllLimpieza();
			ArrayList<Recepcion> recepciones = modeloRecepcion.getAllRecepcion();
			
			ArrayList<Actividad> actividades = modeloActividad.getAllActividades();
			ArrayList<ActividadesPorGrupo> actividadesPorGrupos = modeloActividadesGrupo.getAllActividadesPorGrupo();
			ArrayList<Grupo> grupos = modeloGrupo.getAllGrupos();
			ArrayList<Parcela> parcelas = modeloParcela.getAllParcelas();
			ArrayList<Reserva> reservas = modeloReserva.getAllReservas();
			ArrayList<Tipo> tipos = modeloTipo.getAllTipos();
			ArrayList<Vehiculo> vehiculos = modeloVehiculos.getAllVehiculos();
			ArrayList<UsuarioVehiculo> usuarioVehiculos = modeloUsuarioVehiculo.getAllUsuarioVehiculoConUsuario();
			ArrayList<Zona> zonas = modeloZona.getAllZonas();
			
			modeloUsuario.cerrar();
			modeloCliente.cerrar();
			modeloPersonal.cerrar();
			modeloMonitor.cerrar();
			modeloLimpieza.cerrar();
			modeloRecepcion.cerrar();
			
			modeloActividad.cerrar();
			modeloActividadesGrupo.cerrar();
			modeloGrupo.cerrar();
			modeloParcela.cerrar();
			modeloReserva.cerrar();
			modeloTipo.cerrar();
			modeloVehiculos.cerrar();
			modeloUsuarioVehiculo.cerrar();
			modeloZona.cerrar();
			
			request.setAttribute("usuarios", usuarios);
			request.setAttribute("clientes", clientes);
			request.setAttribute("personales", personales);
			request.setAttribute("monitores", monitores);
			request.setAttribute("limpiezas", limpiezas);
			request.setAttribute("recepciones", recepciones);
			
			request.setAttribute("actividades", actividades);
			request.setAttribute("actividadesPorGrupos", actividadesPorGrupos);
			request.setAttribute("grupos", grupos);
			request.setAttribute("parcelas", parcelas);
			request.setAttribute("reservas", reservas);
			request.setAttribute("tipos", tipos);
			request.setAttribute("vehiculos", vehiculos);
			request.setAttribute("usuarioVehiculos", usuarioVehiculos);
			request.setAttribute("zonas", zonas);
			
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
