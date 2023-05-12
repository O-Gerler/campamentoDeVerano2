package modeloDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpSession;

public class Conector {
	protected Connection connection;
	
	public Conector() {
		connection = null;

//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			connection = DriverManager.getConnection("jdbc:mysql://localhost/campamento", "root", "");
//			System.out.println("funciona");
//
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			System.out.println("no funciona");
//
//		}
	}
	
	public void conectar() {
		connection = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/campamento", "root", "");
			System.out.println("funciona");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("no funciona");

		}
	}
	
	public void cerrar() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
