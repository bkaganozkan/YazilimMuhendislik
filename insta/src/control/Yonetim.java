package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.UserAccount;


@WebServlet("/Yonetim")
public class Yonetim extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	RequestDispatcher dispatcher = null;
	UserDAO userac = null;
	
	 public Yonetim() {
			userac = new Users();
		}
	    @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	    	
	    	
	        RequestDispatcher dispatcher //
	                = this.getServletContext().getRequestDispatcher("/yonetim.jsp");
	        
			String action = request.getParameter("action");
			
			if(action == null) {
				action = "LIST";
			}
			
			switch(action) {
				
				
					
				case "EDIT":
					getSingleEmployee(request, response);
					break;
					
				case "DELETE":
					deleteEmployee(request, response);
					break;
				default:
					listEmployee(request, response);
					break;
				
					
			}
	 
	       
	    }


	
	private void listEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			List<UserAccount> theList = userac.get();
			
			request.setAttribute("list", theList);
			
			dispatcher = request.getRequestDispatcher("yonetim.jsp");
			
			dispatcher.forward(request, response);
		}
private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
	
		if(userac.delete(Integer.parseInt(id))) {
			request.setAttribute("NOTIFICATION", "Employee Deleted Successfully!");
			
			dispatcher = request.getRequestDispatcher("yonetim.jsp");
			
			dispatcher.forward(request, response);
			
		}
		
		
	}
private void getSingleEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
	String id = request.getParameter("id");
	
	UserAccount theEmployee = userac.get(Integer.parseInt(id));
	
	request.setAttribute("employee", theEmployee);
	
	dispatcher = request.getRequestDispatcher("kullanıcıduzenle.jsp");
	
	dispatcher.forward(request, response);
}
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		UserAccount e = new UserAccount();
		e.setUsername(request.getParameter("username"));
		e.setRole(request.getParameter("role"));
		
		
		if(id.isEmpty() || id == null) {
			
			if(userac.save(e)) {
				request.setAttribute("NOTIFICATION", "Employee Saved Successfully!");
			}
		
		}else {
			
			e.setId(Integer.parseInt(id));
			if(userac.update(e)) {
				request.setAttribute("NOTIFICATION", "Employee Updated Successfully!");
			}
			
		}
		
		listEmployee(request, response);
	}

}
