package com.bs.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bs.controllers.UserController;
import com.bs.services.UserServiceImpl;
import com.bs.daos.UserDAOImpl;
import com.bs.models.User;
/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Getting email and password from login form
		HttpSession session = request.getSession();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UserController ctrl = new UserController(new UserServiceImpl(new UserDAOImpl()));
		
		
		User loggedInUser = ctrl.loginUser(email,password);
		
		//if user is in database sends the user to the home page otherwise back to login
		if(loggedInUser != null) {
			session.setAttribute("loggedInUser", loggedInUser);

			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
