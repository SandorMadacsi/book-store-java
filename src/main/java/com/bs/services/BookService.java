package com.bs.services;

import java.util.List;

import com.bs.models.Book;

public interface BookService {

	public List<Book> listBook();
	
	public List<Book> searchBook(String searchTerm, String option);
	
	public Book getSingleBook(String isbn);
}
