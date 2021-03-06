package database;



import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;



public class Dbutil {
	
	private static final String URL = "jdbc:mysql://localhost:3306/covid";
			
	private static final String DRIVER = "com.mysql.jdbc.Driver";
			
	private static final String USERNAME = "root";
			
	private static final String PASSWORD = "fbfbfb333*";

	private static Connection connection = null;
	
	public static Connection openConnection() {
		if (connection != null)
            return connection;
        else {
            try {
                Class.forName(DRIVER);
                connection = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } 
            return connection;
        }
	}
}

