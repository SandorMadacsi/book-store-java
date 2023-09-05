package com.bs.controllers;

import java.util.List;


import com.bs.models.BasketItem;
import com.bs.models.Book;
import com.bs.services.BasketService;
import java.time.LocalDateTime;

public class BasketController {
	
	private BasketService basketService;

	public BasketController(BasketService basketService) {
		super();
		this.basketService = basketService;
	}

	
	public List<BasketItem> addToBasket(List<BasketItem> books, Book b) {
		// TODO Auto-generated method stub
		return this.basketService.addToBasket(books, b);
	}

	
	public List<BasketItem> removeFromBasket(List<BasketItem> books,String isbn) {
		// TODO Auto-generated method stub
		return this.basketService.removeFromBasket(books, isbn);
	}
	
	public List<BasketItem> storeBasket(List<BasketItem> books,String userEmail, String basketId) {
		// TODO Auto-generated method stub
		return this.basketService.storeBasket(books, userEmail, basketId);
	}

}
