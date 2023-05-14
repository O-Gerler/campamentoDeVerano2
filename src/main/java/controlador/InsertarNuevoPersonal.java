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

import modeloDAO.ModeloCliente;
import modeloDAO.ModeloGrupo;
import modeloDAO.ModeloPersonal;
import modeloDAO.ModeloUsuario;
import modeloDTO.Cliente;
import modeloDTO.Grupo;
import modeloDTO.Manager;
import modeloDTO.Personal;
import modeloDTO.Recepcion;
import modeloDTO.Usuario;

/**
 * Inserta un nuevo personal con los datos de usuario incluidos
 */
@WebServlet("/InsertarNuevoPersonal")
public class InsertarNuevoPersonal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarNuevoPersonal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String dni = request.getParameter("dni");
		String email = request.getParameter("email");
		String contrasena = request.getParameter("contrasena");
		String telf = request.getParameter("telf");
		int dirige = Integer.parseInt(request.getParameter("dirige"));
		String fecha_ingreso = request.getParameter("fecha_ingreso");
		String fecha = request.getParameter("fecha_nacimiento");
		
		Date fechaNacimiento = null;
		try {
			fechaNacimiento = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Date fechaIngreso = null;
		try {
			fechaIngreso = new SimpleDateFormat("yyyy-MM-dd").parse(fecha_ingreso);
		} catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		Personal personal = new Personal();
		
		personal.setNombre(nombre);
		personal.setApellido(apellidos);
		personal.setDni(dni);
		personal.setEmail(email);
		personal.setContrasena(contrasena);
		personal.setTelefono(telf);
		personal.setFechaNacimiento(fechaNacimiento);
		personal.setDirector(dirige);
		personal.setFechaIngreso(fechaIngreso);
		
		Usuario usuario = personal;
		
		ModeloUsuario modeloUsuario = new ModeloUsuario();
		modeloUsuario.conectar();
		
		modeloUsuario.insertarUsuario(usuario);
		
		modeloUsuario.cerrar();
		
		ModeloPersonal modeloPersonal = new ModeloPersonal();
		modeloPersonal.conectar();
		
		modeloPersonal.insertarPersonal(personal);
		
		modeloPersonal.cerrar();
		
		HttpSession session = request.getSession();
		
		Manager manager = (Manager) session.getAttribute("manager");
		
		if (manager != null) {
			response.sendRedirect("VistaManager");
		}else{
			request.getRequestDispatcher("error404.jsp").forward(request, response);
		}
	}

}
