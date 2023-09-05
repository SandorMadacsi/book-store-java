package com.bs.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bs.controllers.BookController;
import com.bs.daos.BookDAOImpl;
import com.bs.models.Book;
import com.bs.services.BookServiceImpl;
import com.bs.utils.BasketSetup;

import java.util.List;

import com.bs.controllers.BasketController;
import com.bs.daos.BasketDAOImpl;

import com.bs.models.BasketItem;
import com.bs.services.BasketServiceImpl;

/**
 * Servlet implementation class AddToBasketServlet
 */
@WebServlet("/AddToBasketServlet")
public class AddToBasketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToBasketServlet() {
        super();
        
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String isbn = request.getParameter("isbn");
		
		
		BookController ctrl = new BookController(new BookServiceImpl(new BookDAOImpl()));	
		//get a book based on isbn
		Book b = ctrl.getSingleBook(isbn);
		BasketController ctrlBasket = new BasketController(new BasketServiceImpl(new BasketDAOImpl()));	
		//get basket
		List<BasketItem>basket = BasketSetup.setup();
		//add book to basket
		basket = ctrlBasket.addToBasket(basket,b);
		//calculate total
		double total = BasketSetup.calculateTotal(basket);
		session.setAttribute("basket", basket);
		session.setAttribute("total",total);

		request.getRequestDispatcher("basket.jsp").forward(request,response);
		
	}

}
