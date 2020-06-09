package Filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import database.Dbutil;
import gorev.Gorevler;
import bean.UserAccount;
public class Filter2 {
	
	public  String authenticateUser(UserAccount loginBean)
	{
	    String userName = loginBean.getUsername();
	 
	    Connection con = null;
	    Statement statement = null;
	    ResultSet resultSet = null;
	 
	    String userNameDB = "";
	    String passwordDB = "";
	    String roleDB = "";
	 
	    try
	    {
	    	con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/covid","root","fbfbfb333*");
			 
	        statement = con.createStatement();
	        resultSet = statement.executeQuery("select username,role from users");
	 
	        while(resultSet.next())
	        {
	            userNameDB = resultSet.getString("username");
	            
	            roleDB = resultSet.getString("role");
	 
	            if(userName.equals(userNameDB)  && roleDB.equals("admin")) {
	            return "Admin_Role";}
	            else if(userName.equals(userNameDB)  && roleDB.equals("editor"))
	            return "Editor_Role";
	            else if(userName.equals(userNameDB)  && roleDB.equals("user"))
	            return "User_Role";
	        }
	    }
	    catch(SQLException e)
	    {
	        e.printStackTrace();
	    }
	    return "Invalid user credentials";
	}
	
	
}

