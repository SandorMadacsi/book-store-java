package com.bs.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bs.controllers.BasketController;
import com.bs.daos.BasketDAOImpl;
import com.bs.models.BasketItem;
import com.bs.services.BasketServiceImpl;
import com.bs.utils.BasketSetup;

/**
 * Servlet implementation class RemoveFromBasketServlet
 */
@WebServlet("/RemoveFromBasketServlet")
public class RemoveFromBasketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveFromBasketServlet() {
        super();
      
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		String isbn = request.getParameter("isbn");
		
		BasketController ctrlBasket = new BasketController(new BasketServiceImpl(new BasketDAOImpl()));	
		//get the content of the basket
		List<BasketItem>basket = BasketSetup.setup();
		//remove from basket based on the isbn of the book
		basket = ctrlBasket.removeFromBasket(basket,isbn);
		//calculate the total of the basket
		if(!basket.isEmpty())
		{
			double total = BasketSetup.calculateTotal(basket);	
			session.setAttribute("total",total);

		}
		else {
			session.setAttribute("total",0);
		}
		//update basket attribute
		session.setAttribute("basket", basket);
			
		request.getRequestDispatcher("basket.jsp").forward(request,response);

	}

}
