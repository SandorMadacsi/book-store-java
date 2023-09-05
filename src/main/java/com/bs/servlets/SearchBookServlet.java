package com.bs.servlets;

import java.io.IOException;
import java.util.List;

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

/**
 * Servlet implementation class SearchBookServlet
 */
@WebServlet("/SearchBookServlet")
public class SearchBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchBookServlet() {
        super();
      
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get search term and option from form
		HttpSession session = request.getSession();
		String searchTerm = request.getParameter("search");
		String option = request.getParameter("option");
		
		BookController ctrl = new BookController(new BookServiceImpl(new BookDAOImpl()));
		List<Book> searchedBooks = ctrl.searchBook(searchTerm, option);
		
		//return the results to result page otherwise stay on search page
		if(!searchedBooks.isEmpty()) {
			session.setAttribute("searchedBooks", searchedBooks);
			
			request.getRequestDispatcher("results.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("search.jsp").forward(request,response);
		}
	}

}
