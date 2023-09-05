package com.bs.servlets;

import java.io.IOException;
import com.bs.controllers.BookController;
import com.bs.daos.BookDAOImpl;
import com.bs.models.Book;
import com.bs.services.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.List;
//import java.util.ArrayList;

/**
 * Servlet implementation class ListBookServlet
 */
@WebServlet("/ListBookServlet")
public class ListBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//list all books from database
		HttpSession session = request.getSession();
		BookController ctrl = new BookController(new BookServiceImpl(new BookDAOImpl()));
		 List<Book> booklist = ctrl.listBook();
		
		if(booklist != null)
		{

			session.setAttribute("booklist", booklist);								  request.getRequestDispatcher("books.jsp").forward(request,response);					
		}

		request.getRequestDispatcher("home.jsp").forward(request,response);
		

	}

}