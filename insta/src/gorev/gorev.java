package gorev;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import gorev.GorevImp;
import gorev.Gorevkontrol;
import gorev.Gorevler;


@WebServlet("/gorev")
public class gorev extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	RequestDispatcher dispatcher = null;
	Gorevkontrol gorevkontrol = null;
	
    public gorev() {
		gorevkontrol = new GorevImp();
	}
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	listEmployee(request, response);
        RequestDispatcher dispatcher //
                = this.getServletContext().getRequestDispatcher("/gorevler.jsp");
 
       
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	
		String gorev = request.getParameter("gorev");
		String baslik = request.getParameter("baslik");
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("user");
		byte[] bytes = new byte[gorev.length()];
		for (int i = 0; i < gorev.length(); i++) bytes[i] = (byte) gorev.charAt(i);
		String output = new String(bytes, "UTF-8");
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/covid?useUnicode=true&characterEncoding=utf8","root","fbfbfb333*");
				 
				
			    	 PreparedStatement pst = (PreparedStatement) con.prepareStatement(" insert into gorevler(baslik,gorevtext,gusername) values(?,?,?)");
					 pst.setString(1, baslik);
					 pst.setString(2, output);
					 pst.setString(3, userName);
					 pst.executeUpdate();
					 
					 response.sendRedirect(request.getContextPath() + "/gorev");
					 return;
		
		} catch (Exception e) {
		
			e.printStackTrace();
			
		} 
		
	}
private void listEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession session = request.getSession();
	String userName = (String) session.getAttribute("user");
		List<Gorevler> theList = gorevkontrol.get(userName);
		
		request.setAttribute("list", theList);
		
		dispatcher = request.getRequestDispatcher("gorevler.jsp");
		
		dispatcher.forward(request, response);
	}

}
