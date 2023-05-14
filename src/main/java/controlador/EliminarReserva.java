package controlador;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
 * Elimina una reserva
 */
@WebServlet("/EliminarReserva")
public class EliminarReserva extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarReserva() {
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
		
		Recepcion recepcion = (Recepcion) session.getAttribute("recepcion");
		
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		
		if (manager != null || recepcion != null || usuario != null) {
			int id_parcela = Integer.parseInt(request.getParameter("id_parcela"));
			int id_usuario = Integer.parseInt(request.getParameter("id_usuario"));
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
			
			Usuario usuarioReserva = modeloUsuario.getUsuarios(id_usuario);
			
			modeloUsuario.cerrar();
			
			ModeloParcela modeloParcela = new ModeloParcela();
			modeloParcela.conectar();
			
			Parcela parcela = modeloParcela.getParcela(id_parcela);
			
			modeloParcela.cerrar();
			
			Reserva reserva = new Reserva();
			
			reserva.setUsuario(usuarioReserva);
			reserva.setParcela(parcela);
			reserva.setFecha_ingreso(fechaIngreso);
			reserva.setFecha_salida(fechaSalida);
			
			ModeloReserva modeloReserva = new ModeloReserva();
			modeloReserva.conectar();
			
			modeloReserva.eliminarReserva(reserva);
			
			modeloReserva.cerrar();
			
			if (recepcion != null) {
				response.sendRedirect("VistaRecepcion");
			}else if (usuario != null) {
				response.sendRedirect("VistaUsuario");
			}else if (manager != null) {
				response.sendRedirect("VistaManager");
			}
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
