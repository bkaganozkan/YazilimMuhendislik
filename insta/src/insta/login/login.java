package insta.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logindao.LoginDao;
import bean.UserAccount;
import Filter.Filter2;
/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	  @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	 
	        RequestDispatcher dispatcher //
	                = this.getServletContext().getRequestDispatcher("/login.jsp");
	 
	        dispatcher.forward(request, response);
	    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		
		LoginDao dao = new LoginDao();
		
		if(dao.check(uname, pass)) {
			UserAccount user = new UserAccount();
			user.setUsername(uname);
			Filter2 loginbean = new Filter2();
			
			String userValidate = loginbean.authenticateUser(user);
			
			if(userValidate.equals("Admin_Role")) {
			HttpSession session = request.getSession();
			user.setRole("Admin");
			session.setAttribute("admin", uname);
			session.setAttribute("user", uname);
			
			response.sendRedirect("welcome.jsp");
		}
			else if (userValidate.equals("Editor_Role")) {
				HttpSession session = request.getSession();
				session.setAttribute("editor", uname);
				session.setAttribute("user", uname);
				user.setRole("Editör");
				response.sendRedirect("welcome.jsp");
			}
			
		
		
		}
		else {
			String errorMessage = "Kullanıcı adı veya şifre hatalı!";
			request.setAttribute("errorMessage", errorMessage);
			 RequestDispatcher dispatcher //
             = this.getServletContext().getRequestDispatcher("/login.jsp");

			     dispatcher.forward(request, response);
			     return;
			

		}
	}



}
