package com.bs.utils;

import java.util.List;
import java.util.ArrayList;

import com.bs.controllers.BasketController;
import com.bs.daos.BasketDAOImpl;
import com.bs.models.BasketItem;
import com.bs.services.BasketServiceImpl;

public class BasketSetup {
	
	private static List<BasketItem> basket;
	private static double total;
	
	//setup basket singleton
	public static List<BasketItem> setup(){
		
		//if basket doesn't exist create a new one with an empty arraylist
		if(basket == null) {
			BasketController ctrlBasket = new BasketController(new BasketServiceImpl(new BasketDAOImpl()));
			basket = new ArrayList<>();
			total = 0;
		}
		
		
		return basket;
	}

public static double calculateTotal(List<BasketItem> books) {
		//calculate the price for all books in the basket
		//it is called each time the user modifies the content of the basket
		total = 0;
		double currentPrice =0;
		for(BasketItem book : books)
		{
			if(book.getQuantity() > 1)
			{
				currentPrice = book.getBook().getBookPrice() * book.getQuantity();
			}
			else {
				 currentPrice = book.getBook().getBookPrice();	
			}

			total += currentPrice;
		}
		return total;
	}
}
