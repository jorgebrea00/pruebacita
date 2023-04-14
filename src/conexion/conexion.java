package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {

	

	public static Connection darConexion() {
	    Connection con = null;

	    try {
	        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/motor_racing_ver5?user=root&password=root");
	    } catch (SQLException e) {
	        System.out.println(e);
	    }
	    
	    return con;
	}
}
