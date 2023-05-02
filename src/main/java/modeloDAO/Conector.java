package modeloDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conector {
	protected Connection connection;
	
	public void conectar() {
		connection = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/campamentoverano", "root", "");
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
