package com.bs.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;
import java.util.ArrayList;

import com.bs.models.BasketItem;
import com.bs.models.Book;
import com.bs.utils.DatabaseConnection;

public class BasketDAOImpl implements BasketDAO{
	
	private Connection con;
	private PreparedStatement pst;
	private ResultSet rs;

	@Override
	public List<BasketItem> addToBasket(List<BasketItem> books,Book b) {
		//check if the book exists in basket
		boolean doesExist = false;
		for(BasketItem book : books)
		{
			//if already in basket increase quantity by 1
			Book currentBook = book.getBook();
			if(currentBook.getBookName().equals(b.getBookName())) {
				book.setQuantity(book.getQuantity()+1);				
				doesExist = true;
				
				break;
			}
		}
		//otherwise just add it to basket as a new item
		if(doesExist == false)
		{

			BasketItem bi = new BasketItem(b , 1);
			books.add(bi);		
		}

		return books;
		
	}

	@Override
	public List<BasketItem> removeFromBasket(List<BasketItem> books,String isbn) {
		
		
		//check if item exists in basket
		for(BasketItem book : books)
		{
			//if it does decrease the quantity by 1
			Book currentBook = book.getBook();
			if(currentBook.getBookISBN().equals(isbn)) {
				if(book.getQuantity() > 1) {
					book.setQuantity(book.getQuantity() - 1);
				}
				else {
					//if only one exists then remove it from basket
					books.remove(book);
					break;
				}
				
				
			}
		}
//		books.remove(bi);
		return books;
		
		
	}
	
	@Override
	public List<BasketItem> storeBasket(List<BasketItem> books, String userEmail, String basketId)
	{
		List<BasketItem> orderedItems = new ArrayList<>();
	
		this.con = DatabaseConnection.getConnection();
		try {
			this.pst = this.con.prepareStatement("DELETE FROM basket");
			int d = this.pst.executeUpdate();
		
			this.pst = this.con.prepareStatement("INSERT into basket(basket_id,book_ISBN, quantity, user_email) VALUES(?,?,?,?)");
			
			for(BasketItem b : books)
				
				
			{
				
				Book b1 = b.getBook();
				this.pst.setString(1, basketId);
				this.pst.setString(2, b1.getBookISBN());
				this.pst.setInt(3, b.getQuantity());
				this.pst.setString(4,userEmail);
				int i = this.pst.executeUpdate();
				if(i > 0) {
					orderedItems.add(b);
				}
			}

			return orderedItems;
		}
		catch(SQLException exc) {
			System.out.println(exc);
			return null;
		}
		
	}
	

	
	

}
