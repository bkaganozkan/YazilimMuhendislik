package gorev;

import java.util.List;





public interface Gorevkontrol {
	
	List<Gorevler> get();
	
   Gorevler get(int id);
	
	boolean save(Gorevler employee);
	
	boolean delete(int id);
	
	boolean update(Gorevler employee);

	List<Gorevler> get(String userName);

}
