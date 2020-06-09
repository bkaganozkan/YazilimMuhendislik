package ayar;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


@WebServlet("/ayarServlet")
public class ayarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ayarServlet() {
        super();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String baslik = request.getParameter("baslik");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/covid","root","fbfbfb333*");
			 

					    
		    	 PreparedStatement pst = (PreparedStatement) con.prepareStatement(" UPDATE ayarlar SET sitetitle=?");
				 pst.setString(1, baslik);
				 pst.executeUpdate();
				 response.sendRedirect("ayarlar.jsp"); 
		            
		    
	
	           
	
	} catch (Exception e) {
	
		e.printStackTrace();
		
	} 
	}

}
