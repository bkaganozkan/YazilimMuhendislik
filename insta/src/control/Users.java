package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.UserAccount;
import database.Dbutil;
import gorev.Gorevler;

public class Users implements UserDAO{
	Connection connection = null;
	ResultSet resultSet = null;
	Statement statement = null;
	PreparedStatement preparedStatement = null;
	@Override
	public List<UserAccount> get() {
		List<UserAccount> list = null;
		UserAccount employee = null;
		
		try {
			
			list = new ArrayList<UserAccount>();
			String sql = "SELECT * FROM users";
			connection = Dbutil.openConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				employee = new UserAccount();
				employee.setId(resultSet.getInt("id"));
				employee.setUsername(resultSet.getString("username"));
				employee.setRole(resultSet.getString("role"));
				
				list.add(employee);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public UserAccount get(int id) {
		UserAccount employee = null;
		try {
			employee = new UserAccount();
			String sql = "SELECT * FROM users where id="+id;
			connection = Dbutil.openConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			if(resultSet.next()) {
				employee.setId(resultSet.getInt("id"));
				employee.setUsername(resultSet.getString("username"));
				employee.setRole(resultSet.getString("role"));
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return employee;
	}

	@Override
	public boolean save(UserAccount e) {
		boolean flag = false;
		try {
			String sql = "INSERT INTO users(username, role)VALUES"
					+ "('"+e.getUsername()+"', '"+e.getRole()+"')";
			connection = Dbutil.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag = true;
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean delete(int id) {
		boolean flag = false;
		try {
			String sql = "DELETE FROM users where id="+id;
			connection = Dbutil.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag = true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean update(UserAccount employee) {
		boolean flag = false;
		try {
			String sql = "UPDATE users SET username = '"+employee.getUsername()+"', "
					+ "role = '"+employee.getRole()+"' where id="+employee.getId();
			connection = Dbutil.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag = true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
}
