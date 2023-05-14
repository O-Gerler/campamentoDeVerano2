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
import modeloDAO.ModeloUsuario;
import modeloDTO.Usuario;
import modeloDTO.Cliente;
import modeloDTO.Grupo;
import modeloDTO.Manager;
import modeloDTO.Recepcion;

/**
 * Inserta un nuevo cliente con los datos de usuario incluidos
 */
@WebServlet("/InsertarNuevoCliente")
public class InsertarNuevoCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarNuevoCliente() {
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
		// TODO Auto-generated method stub
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String dni = request.getParameter("dni");
		String email = request.getParameter("email");
		String contrasena = request.getParameter("contrasena");
		String telf = request.getParameter("telf");
		String fecha = request.getParameter("fecha_nacimiento");
		int id_grupo = Integer.parseInt(request.getParameter("id_grupo"));
		
		Date fechaNacimiento = null;
		try {
			fechaNacimiento = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Cliente cliente = new Cliente();
		
		cliente.setNombre(nombre);
		cliente.setApellido(apellidos);
		cliente.setDni(dni);
		cliente.setEmail(email);
		cliente.setContrasena(contrasena);
		cliente.setTelefono(telf);
		cliente.setFechaNacimiento(fechaNacimiento);
		
		ModeloGrupo modeloGrupo = new ModeloGrupo();
		modeloGrupo.conectar();
		
		Grupo grupo = modeloGrupo.getGrupo(id_grupo);
		
		modeloGrupo.cerrar();
		
		cliente.setGrupo(grupo);
		
		Usuario usuario = cliente;
		
		ModeloUsuario modeloUsuario = new ModeloUsuario();
		modeloUsuario.conectar();
		
		modeloUsuario.insertarUsuario(usuario);
		
		cliente.setId(modeloUsuario.getUsuariosViaDNI(cliente.getDni()).getId());
		
		modeloUsuario.cerrar();
		
		ModeloCliente modeloCliente = new ModeloCliente();
		modeloCliente.conectar();
		
		modeloCliente.insertarCliente(cliente);
		
		modeloCliente.cerrar();
		
		HttpSession session = request.getSession();
		
		Recepcion recepcion = (Recepcion) session.getAttribute("recepcion");
		
		Manager manager = (Manager) session.getAttribute("manager");
		
		if (recepcion != null) {
			request.getRequestDispatcher("VistaRecepcion").forward(request, response);
		}else if (manager != null) {
			request.getRequestDispatcher("VistaManager").forward(request, response);
		}else{
			request.getRequestDispatcher("error404.jsp").forward(request, response);
		}
	}

}
