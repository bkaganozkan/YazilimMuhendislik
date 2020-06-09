package gorev;

import java.io.IOException;
import java.sql.DriverManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


@WebServlet("/gorevver")
public class gorevver extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	RequestDispatcher dispatcher = null;
    public gorevver() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher 
        = this.getServletContext().getRequestDispatcher("/gorevver.jsp");
		
dispatcher = request.getRequestDispatcher("gorevver.jsp");
		
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String baslik = request.getParameter("baslik");
		String gorev = request.getParameter("gorev");
		String user = request.getParameter("user");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/covid?useUnicode=true&characterEncoding=utf8","root","fbfbfb333*");
			 
			
		    	 PreparedStatement pst = (PreparedStatement) con.prepareStatement(" insert into gorevler(baslik,gorevtext,gusername) values(?,?,?)");
				 pst.setString(1, baslik);
				 pst.setString(2, gorev);
				 pst.setString(3, user);
				 pst.executeUpdate();
				 
				 response.sendRedirect(request.getContextPath() + "/gorevver");
				 return;
	
	} catch (Exception e) {
	
		e.printStackTrace();
		
	} 
		
	}

}
