package servlets;

import java.io.IOException;
import DAO.*;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		
		String u = request.getParameter("username");
		String p = request.getParameter("password");
		String e = request.getParameter("email");
		String phn = request.getParameter("phone");
		String r = request.getParameter("role");
		
		if(r.equals("buyer")) {
			r = "b";
		}
		else if (r.equals("seller")) {
			r = "s";
		}
		
		boolean isRegistered = UserDAO.registerUser(u, p, e, phn, r);
		
		if(isRegistered) {
			request.setAttribute("successMessage", "User registered successfully. Please log in.");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else {
			request.setAttribute("errorMessage", "Username or password incorrect");
        	request.getRequestDispatcher("registeruser.jsp").forward(request, response);
		}
		//doGet(request, response);
	}

}
