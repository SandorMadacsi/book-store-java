package com.bs.services;

import java.util.List;
import java.util.ArrayList;

import com.bs.daos.BookDAO;
import com.bs.models.Book;
import java.util.stream.Collectors;

public class BookServiceImpl implements BookService{

	public BookServiceImpl(BookDAO bookDAO) {
		super();
		this.bookDAO = bookDAO;
	}
	//Class Dependency
	private BookDAO bookDAO;
	@Override
	public List<Book> listBook() {
	
		return this.bookDAO.listBook();
	}
	@Override
	public List<Book> searchBook(String searchTerm,String option) {
		
		List<Book> results = new ArrayList<>();
		//filters the whole list of books based on author or isbn and returns the list
		if(option.equals("AUTHOR")){
		results = this.bookDAO.listBook().stream()
					   .filter(b -> 	 b.getBookAuthor().toLowerCase().contains(searchTerm))
					.collect(Collectors.toList());
		}
		else if(option.equals("ISBN")){
		
		results = this.bookDAO.listBook().stream()
					   .filter(b -> 	 b.getBookISBN().contains(searchTerm))
					.collect(Collectors.toList());	
		}
		
		return results;
	}
	
	public Book getSingleBook(String isbn) {
		return this.bookDAO.getSingleBook(isbn);
	}

}
