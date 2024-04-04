package servlets;

import java.io.IOException;
import org.owasp.encoder.Encode;
import DAO.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContactUsServlet
 */
@WebServlet("/ContactUsServlet")
public class ContactUsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactUsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = Encode.forHtml(request.getParameter("name"));
		String email = Encode.forHtml(request.getParameter("email"));
		String phone = Encode.forHtml(request.getParameter("phone"));
		String comments = Encode.forHtml(request.getParameter("comments"));
		
		if(UserDAO.userComments(name, email, phone, comments)) {
			request.setAttribute("successMessage", "Comment submitted Successfully");
			request.getRequestDispatcher("contactus.jsp").forward(request, response);
		}
		else {
			request.setAttribute("errorMessage", "Please try Again");
			request.getRequestDispatcher("contactus.jsp").forward(request, response);
		}
	}

}
