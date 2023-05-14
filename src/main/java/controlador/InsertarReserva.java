package controlador;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modeloDAO.ModeloParcela;
import modeloDAO.ModeloReserva;
import modeloDAO.ModeloUsuario;
import modeloDTO.Manager;
import modeloDTO.Parcela;
import modeloDTO.Recepcion;
import modeloDTO.Reserva;
import modeloDTO.Usuario;

/**
 * Inserta una reserva
 */
@WebServlet("/InsertarReserva")
public class InsertarReserva extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarReserva() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		Recepcion recepcion = (Recepcion) session.getAttribute("recepcion");
		
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		
		Manager manager = (Manager) session.getAttribute("manager");
		
		if(recepcion != null || manager != null) {
			ModeloUsuario modeloUsuario = new ModeloUsuario();
			modeloUsuario.conectar();
			
			ArrayList<Usuario> usuarios = modeloUsuario.getAllUsuarios();
			
			modeloUsuario.cerrar();
			
			ModeloParcela modeloParcela = new ModeloParcela();
			modeloParcela.conectar();
			
			ArrayList<Parcela> parcelas = modeloParcela.getAllParcelas();
			
			modeloParcela.cerrar();
			
			request.setAttribute("usuarios", usuarios);
			request.setAttribute("parcelas", parcelas);
			request.getRequestDispatcher("reservas/insertarReserva.jsp").forward(request, response);
		}else if(usuario != null) {
			ModeloParcela modeloParcela = new ModeloParcela();
			modeloParcela.conectar();
			
			ArrayList<Parcela> parcelas = modeloParcela.getAllParcelas();
			
			modeloParcela.cerrar();
			
			request.setAttribute("usuario", usuario);
			request.setAttribute("parcelas", parcelas);
			request.getRequestDispatcher("reservas/insertarReserva.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("error404.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id_usuario = Integer.parseInt(request.getParameter("id_usuario"));
		int id_parcela = Integer.parseInt(request.getParameter("id_parcela"));
		String fecha_ingreso = request.getParameter("fecha_ingreso");
		String fecha_salida = request.getParameter("fecha_salida");
		
		Date fechaIngreso = null;
		
		try {
			fechaIngreso = new SimpleDateFormat("yyyy-MM-dd").parse(fecha_ingreso);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Date fechaSalida = null;
		
		try {
			fechaSalida = new SimpleDateFormat("yyyy-MM-dd").parse(fecha_salida);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ModeloUsuario modeloUsuario = new ModeloUsuario();
		modeloUsuario.conectar();
		
		Usuario usuario = modeloUsuario.getUsuarios(id_usuario);
		
		modeloUsuario.cerrar();
		
		ModeloParcela modeloParcela = new ModeloParcela();
		modeloParcela.conectar();
		
		Parcela parcela = modeloParcela.getParcela(id_parcela);
		
		modeloParcela.cerrar();
		
		Reserva reserva = new Reserva();
		
		reserva.setUsuario(usuario);
		reserva.setParcela(parcela);
		reserva.setFecha_ingreso(fechaIngreso);
		reserva.setFecha_salida(fechaSalida);
		
		ModeloReserva modeloReserva = new ModeloReserva();
		modeloReserva.conectar();
		
		if (modeloReserva.reservaLibre(reserva)) {
			modeloReserva.insertarReserva(reserva);
			
			modeloReserva.cerrar();
			
			HttpSession session = request.getSession();
			
			Recepcion VistaRecepcion = (Recepcion) session.getAttribute("recepcion");
			
			Usuario VistaUsuario = (Usuario) session.getAttribute("usuario");
			
			Manager manager = (Manager) session.getAttribute("manager");
			
			if (VistaRecepcion != null) {
				response.sendRedirect("VistaRecepcion");
			}else if (VistaUsuario != null) {
				response.sendRedirect("VistaUsuario");
			}else if (manager != null) {
				response.sendRedirect("VistaManager");
			}
		}else {
			request.setAttribute("incorrecto", true);
			doGet(request, response);
		}
		
		
	}

}
