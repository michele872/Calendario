package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import service.DbUser;
import service.DbUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String action = request.getParameter("action");
		String nextURL = "";
		
		HttpSession session = request.getSession();
		
		if(action.equals("logout")) {
			session.invalidate();
			nextURL = "/login.jsp";
		} else {
			if(DbUser.isValidUser(email, password)) {
				User u = DbUser.getUserByEmail(email);
				session.setAttribute("user", u);
				nextURL = "/home.jsp";
			} else {
				nextURL = "/login.jsp";
			}
		}
		
		getServletContext().getRequestDispatcher(nextURL).forward(request, response);
	}

}
