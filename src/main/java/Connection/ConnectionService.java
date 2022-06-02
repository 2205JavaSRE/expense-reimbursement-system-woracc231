package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionService {
	private static String URL = System.getenv("db_url");
	private static String USERNAME = System.getenv("db_user");
	private static String PASSWORD = System.getenv("db_pass");
	
	
	private static Connection c;

	public static Connection ReturnConnection(){		
		try {
			c = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			//System.out.println("CONNECTED!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;

	}
}
