package yazilar;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Yazilar")
public class Yazilar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Yazilar() {
        super();
        
    }


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String baslik = request.getParameter("baslik");
		
		response.setContentType("text/plain");
        response.setHeader("Content-Disposition", "attachment; filename=\"example.txt\"");
        try {
            OutputStream outputStream = response.getOutputStream();
            String outputResult = "This is Test";
            outputStream.write(outputResult.getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
