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

import modeloDAO.ModeloUsuario;
import modeloDTO.Usuario;

/**
 * Inserta un usuario
 */
@WebServlet("/InsertarUsuario")
public class InsertarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("usuarios/insertarUsuario.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		
		modeloUsuario.cerrar();
		
		request.getRequestDispatcher("MostrarUsuarios").forward(request, response);
	}

}
