package com.bs.daos;

import java.time.LocalDateTime;
import java.util.List;


import com.bs.models.BasketItem;
import com.bs.models.Book;

public interface BasketDAO {

	public List<BasketItem> addToBasket(List<BasketItem> books,Book b );
	public List<BasketItem> removeFromBasket(List<BasketItem> books,String isbn);
	public List<BasketItem> storeBasket(List<BasketItem> books,String userEmail, String basketId);

	
}
