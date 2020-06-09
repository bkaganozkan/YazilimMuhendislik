package control;

import java.util.List;
import bean.UserAccount;


public interface UserDAO {
	List<UserAccount> get();
	
	UserAccount get(int id);
	
	boolean save(UserAccount employee);
	
	boolean delete(int id);
	
	boolean update(UserAccount employee);
}
