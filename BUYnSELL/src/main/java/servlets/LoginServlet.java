package servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import DAO.DbConnect;
import DAO.*;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int MAX_LOGIN_ATTEMPTS = 3; // Maximum login attempts allowed
    private static final long LOCKOUT_DURATION = 300000;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		
		String username = request.getParameter("username");
		//System.out.println(username);
        String password = request.getParameter("password");
        //System.out.println(password);
        String lockedAccounts = "hi";
        HttpSession session = request.getSession();
        Long lockoutTime = (Long) session.getAttribute("lockoutTime");
        if ((lockoutTime != null && System.currentTimeMillis() < lockoutTime) || lockedAccounts.equals(username)) {
            // Account is locked out, redirect to an error page or display a message
            response.sendRedirect("accountLocked.jsp");
            session.removeAttribute("lockoutTime");
            return;
        }
        
        Integer loginAttempts = (Integer) session.getAttribute("loginAttempts");
        loginAttempts = (loginAttempts != null) ? loginAttempts + 1 : 1;
        session.setAttribute("loginAttempts", loginAttempts);
        
        boolean a = AuthenticateUser.authenticate(username, password);
        
        if(a) {
        	
        	session.removeAttribute("lockoutTime");
        	session.removeAttribute("loginAttempts");
        
        	Map<String, String> u = new HashMap<>();

        	u = UserDAO.getUserByUsername(username);

        	String role = u.get("role");
        	
        	//HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setAttribute("role", role);
            session.setAttribute("email", u.get("email"));
            session.setAttribute("phone", u.get("phone"));
            
        	if (role.equals("s")) {
        		response.sendRedirect("seller.jsp");
        	}

        	else if (role.equals("b")) {
        		//System.out.println(role);
        		response.sendRedirect("buyer.jsp");
        	}

        }
        else {
        	
        	if (loginAttempts >= MAX_LOGIN_ATTEMPTS) {
                // Lock the account
                session.setAttribute("lockoutTime", System.currentTimeMillis() + LOCKOUT_DURATION);
                // Redirect to an error page or display a message
                response.sendRedirect("accountLocked.jsp");
                loginAttempts =0;
                lockedAccounts = username;
                return;
            }
        	
        	request.setAttribute("errorMessage", "Username or password incorrect. Account will be locked after 3 unsuccessful Attempts");
        	RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        	dispatcher.forward(request, response);
        	
        }
        
        
        
		//doGet(request, response);
	}

}
