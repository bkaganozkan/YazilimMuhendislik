package gorev;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpSession;

import database.Dbutil;


public class GorevImp implements Gorevkontrol {
	
	@Override
	public List<Gorevler> get() {
		// TODO Auto-generated method stub
		return null;
	}

	Connection connection = null;
	ResultSet resultSet = null;
	Statement statement = null;
	PreparedStatement preparedStatement = null;
	

	@Override
	public List<Gorevler> get(String userName) {
		List<Gorevler> list = null;
		Gorevler gorevler = null;
	try {
				
				list = new ArrayList<Gorevler>();
			
				String sql = "SELECT * FROM gorevler where gusername=?";
				
				connection = Dbutil.openConnection();
				
			
				//String sql = "SELECT * FROM emp WHERE Username = ?";
				PreparedStatement st = connection.prepareStatement(sql);
				st.setString(1, userName);
				ResultSet rs = st.executeQuery();
				while(rs.next()) {
					gorevler = new Gorevler();
					gorevler.setId(rs.getInt("id"));
					gorevler.setBaslik(rs.getString("baslik"));
					gorevler.setGorevtext(rs.getString("gorevtext"));
					
					list.add(gorevler);
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return list;
	}

	@Override
	public Gorevler get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(Gorevler employee) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Gorevler employee) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
