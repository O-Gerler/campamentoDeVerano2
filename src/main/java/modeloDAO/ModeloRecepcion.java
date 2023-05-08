package modeloDAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modeloDTO.Recepcionista;

public class ModeloRecepcion extends Conector{
	public boolean insertarRecepcion(Recepcionista recepcionista) {
		String st = "INSERT INTO recepcion VALUES (?)";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setInt(1, recepcionista.getId());
			
			pst.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
}
