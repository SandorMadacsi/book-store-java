package com.bs.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bs.controllers.UserController;
import com.bs.services.UserServiceImpl;
import com.bs.daos.UserDAOImpl;
import com.bs.models.User;
/**
 * Servlet implementation class UserRegisterServlet
 */
@WebServlet("/UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegisterServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Creates new user based on form input
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User u1 = new User(firstName,lastName, email,password);
		
		UserController ctrl = new UserController(new UserServiceImpl(new UserDAOImpl()));
		
		User registeredUser = ctrl.registerUser(u1);
		request.setAttribute("registeredUser", registeredUser);
		request.getRequestDispatcher("login.jsp").forward(request,response);
	}

}
