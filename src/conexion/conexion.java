package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {

	
	public static Connection darConexion() {
		
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/motor_racing_ver5?user=root&password=5778380")){
			System.out.println("conexion exitosa");
			
			return con;
		
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}
}
