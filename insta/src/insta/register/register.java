package insta.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        RequestDispatcher dispatcher //
                = this.getServletContext().getRequestDispatcher("/register.jsp");
 
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/covid","root","fbfbfb333*");
				 
				String query = "SELECT * FROM users WHERE username = ?";
				pstmt = (PreparedStatement) con.prepareStatement(query);
				pstmt.setString(1, uname);
				 rs = pstmt.executeQuery();
				 
				    if(rs.next()) {
				    	String errorMessage = "Kullanıcı adı daha önceden alınmıs";
						request.setAttribute("errorMessage", errorMessage);
						 RequestDispatcher dispatcher //
			             = this.getServletContext().getRequestDispatcher("/register.jsp");

						     dispatcher.forward(request, response);
						     return;
			    }  else {
			    	 PreparedStatement pst = (PreparedStatement) con.prepareStatement(" insert into users(username,password) values(?,?)");
					 pst.setString(1, uname);
					 pst.setString(2, pass);
					 pst.executeUpdate();
					 response.sendRedirect("login.jsp"); 
			            
			    }
		
		           
		
		} catch (Exception e) {
		
			e.printStackTrace();
			
		} 

    }}
