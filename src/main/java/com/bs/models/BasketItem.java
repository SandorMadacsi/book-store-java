package com.bs.models;

public class BasketItem {

	private Book Book;
	private int quantity;
	private int orderId;
	public BasketItem(com.bs.models.Book book, int quaintity) {
		super();
		this.Book = book;
		this.quantity = quaintity;
	}
	public Book getBook() {
		return Book;
	}
	public void setBook(Book book) {
		Book = book;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	@Override
	public String toString() {
		return "BasketItem [Book=" + Book + ", quanitity=" + quantity + "]";
	}
	
	
}
