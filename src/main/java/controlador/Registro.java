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

import modeloDAO.ModeloUsuario;
import modeloDTO.Usuario;

/**
 * Registra un usuario
 */
@WebServlet("/Registro")
public class Registro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login/registro.jsp").forward(request, response);
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
		String fecha = request.getParameter("fecha_nacimiento");
		
		System.out.println(fecha);
		
		Date fechaNacimiento = null;
		try {
			fechaNacimiento = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Usuario usuario = new Usuario();
		
		usuario.setNombre(nombre);
		usuario.setApellido(apellidos);
		usuario.setDni(dni);
		usuario.setEmail(email);
		usuario.setContrasena(contrasena);
		usuario.setTelefono(telf);
		usuario.setFechaNacimiento(fechaNacimiento);
		
		ModeloUsuario modeloUsuario = new ModeloUsuario();
		modeloUsuario.conectar();
		
		modeloUsuario.insertarUsuario(usuario);
		
		usuario = modeloUsuario.getUsuariosViaDNI(dni);
		
		modeloUsuario.cerrar();
		
		if (usuario != null) {
			HttpSession session = request.getSession();
			
			session.setAttribute("usuario", usuario);
			
			response.sendRedirect("VistaUsuario");
		}else {
			response.sendRedirect("Registro");
		}
		
		
	}

}
