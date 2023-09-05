package com.bs.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bs.controllers.UserController;
import com.bs.daos.UserDAOImpl;
import com.bs.models.User;
import com.bs.services.UserServiceImpl;

/**
 * Servlet implementation class UserEditServlet
 */
@WebServlet("/UserEditServlet")
public class UserEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserEditServlet() {
        super();
        
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get updated data from edit form
		HttpSession session = request.getSession();
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		//create new user and store it into logged in user
		
		User UpdatedUser = new User(firstName,lastName, email,password);
		User loggedInUser = (User) session.getAttribute("loggedInUser");
		String loggedEmail = loggedInUser.getEmail();
		
		UserController ctrl = new UserController(new UserServiceImpl(new UserDAOImpl()));
		
		loggedInUser = ctrl.editUser(loggedEmail,UpdatedUser);
		session.setAttribute("loggedInUser", loggedInUser);
		request.getRequestDispatcher("user.jsp").forward(request, response);
	}


}
