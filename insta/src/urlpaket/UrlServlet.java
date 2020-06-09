package urlpaket;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UrlServlet
 */
@WebServlet("/UrlServlet")
public class UrlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	RequestDispatcher dispatcher = null;
    public UrlServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String kelime = request.getParameter("kelime");
		Urloku oku1 = new Urloku();
		String theList = oku1.GetUrl1(kelime);
		
		request.setAttribute("list", theList);
		
		dispatcher = request.getRequestDispatcher("welcome.jsp");
		
		dispatcher.forward(request, response);
	}

}
