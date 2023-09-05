package com.bs.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bs.controllers.BasketController;
import com.bs.daos.BasketDAOImpl;
import com.bs.models.BasketItem;
import com.bs.models.User;
import com.bs.services.BasketServiceImpl;
import com.bs.utils.BasketSetup;

import java.util.List;
import java.time.LocalDateTime;
import java.sql.Time;

/**
 * Servlet implementation class CheckoutServlet
 */
@WebServlet("/CheckoutServlet")
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		User u = (User)session.getAttribute("loggedInUser");
		String email;
		String username;
		if(u == null)
		{
			 email = "unregistered";
			 username = "user";
		}
		else {
			 email = u.getEmail();
			 username = u.getFirstName();	
		}
	

			BasketController ctrlBasket = new BasketController(new BasketServiceImpl(new BasketDAOImpl()));	
			
			List<BasketItem>basket = BasketSetup.setup();
			LocalDateTime currentTime = LocalDateTime.now();
			String basketId = currentTime + username;
			
			basket = ctrlBasket.storeBasket(basket,email, basketId);
			session.setAttribute("basket", basket);
		request.getRequestDispatcher("checkout.jsp").forward(request, response);
		
	}

}
