package logindao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import com.mysql.jdbc.Connection;

public class LoginDao {
	private static final String URL = "jdbc:mysql://localhost:3306/covid";
	
	
			
	private static final String USERNAME = "root";
			
	private static final String PASSWORD = "fbfbfb333*";
	private static String sql ="select * from users where username=? and password=?";

	
	public boolean check(String uname , String pass) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, uname);
			st.setString(2, pass);
			
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				return true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
