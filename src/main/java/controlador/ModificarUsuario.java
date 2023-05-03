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
 * Servlet implementation class ModificarUsuario
 */
@WebServlet("/ModificarUsuario")
public class ModificarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		
		ModeloUsuario modeloUsuario = new ModeloUsuario();
		modeloUsuario.conectar();
		
		Usuario usuario = modeloUsuario.getUsuarios(id);
		
		modeloUsuario.cerrar();
		
		request.setAttribute("usuario", usuario);
		request.getRequestDispatcher("usuarios/modificarUsuario.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt((request.getParameter("id")));
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String dni = request.getParameter("dni");
		String contrasena = request.getParameter("contrasena");
		String telefono = request.getParameter("telf");
		String fecha = request.getParameter("fecha_nacimiento");
		
		Date fechaNacimineto = null;
		
		try {
			fechaNacimineto = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Usuario usuario = new Usuario();
		
		usuario.setId(id);
		usuario.setNombre(nombre);
		usuario.setApellido(apellidos);
		usuario.setDni(dni);
		usuario.setContrasena(contrasena);
		usuario.setTelefono(telefono);
		usuario.setFechaNacimiento(fechaNacimineto);
		
		ModeloUsuario modeloUsuario = new ModeloUsuario();
		modeloUsuario.conectar();
		
		modeloUsuario.modificarUsuario(usuario);
		
		modeloUsuario.cerrar();
		
		request.getRequestDispatcher("MostrarUsuarios").forward(request, response);
	}

}
