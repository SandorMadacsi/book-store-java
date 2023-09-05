package com.bs.controllers;

import java.util.List;

import com.bs.models.Book;
import com.bs.services.BookService;

public class BookController {

	private BookService bookService;

	public BookController(BookService bookService) {
		super();
		this.bookService = bookService;
	}
	
	public List<Book> listBook() {
		return this.bookService.listBook();
	}
	
	public List<Book> searchBook(String searchTerm, String option) {
		return this.bookService.searchBook(searchTerm, option);
	}
	public Book getSingleBook(String isbn) {
		return this.bookService.getSingleBook(isbn);
	};
	
}
