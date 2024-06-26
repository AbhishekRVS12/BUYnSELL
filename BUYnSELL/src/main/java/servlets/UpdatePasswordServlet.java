package servlets;

import java.io.IOException;
import DAO.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdatePasswordServlet
 */
@WebServlet("/UpdatePasswordServlet")
public class UpdatePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePasswordServlet() {
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
		
		String oldPassword = request.getParameter("oldpassword");
        String newPassword = request.getParameter("newpassword");
        
        boolean passwordUpdated = UserDAO.updatePassword((String) request.getSession().getAttribute("username"), oldPassword, newPassword);
        
        if(passwordUpdated) {
        	request.setAttribute("successMessage", "Password updated successfully");
            request.getRequestDispatcher("buyer.jsp").forward(request, response);
        }
        else {
        	request.setAttribute("errorMessage", "Failed to update password. Please try again.");
            request.getRequestDispatcher("changepwd.jsp").forward(request, response);
        }
        }
		
		//doGet(request, response);
	}

