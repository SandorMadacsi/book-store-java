package com.bs.daos;

import java.util.List;

import com.bs.models.Book;

public interface BookDAO {

	
	public List<Book> listBook();
	public Book getSingleBook(String isbn);
}
