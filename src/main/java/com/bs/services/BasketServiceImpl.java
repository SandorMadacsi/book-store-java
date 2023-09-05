package com.bs.services;


import java.util.List;

import com.bs.daos.BasketDAO;
import com.bs.models.BasketItem;
import com.bs.models.Book;

public class BasketServiceImpl implements BasketService{
	
	private BasketDAO basketDAO;

	public BasketServiceImpl(BasketDAO basketDAO) {
		super();
		this.basketDAO = basketDAO;
	}

	@Override
	public List<BasketItem> addToBasket(List<BasketItem> books, Book b) {
		
		return this.basketDAO.addToBasket(books, b);
	}

	@Override
	public List<BasketItem> removeFromBasket(List<BasketItem> books, String isbn) {
		
		return this.basketDAO.removeFromBasket(books, isbn);
	}
	@Override
	public List<BasketItem> storeBasket(List<BasketItem> books, String userEmail, String basketId) {
		
		return this.basketDAO.storeBasket(books, userEmail, basketId);
	}

}
