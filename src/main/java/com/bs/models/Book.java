package com.bs.models;

public class Book {
	
	private int bookId;
	private String bookName;
	private String bookAuthor;
	private String bookDescription;
	private String bookISBN;
	private double bookPrice;
	

	
	public Book(int bookId, String bookName, String bookAuthor,String bookDescription, String bookISBN, double bookPrice) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookDescription = bookDescription;
		this.bookISBN = bookISBN;
		this.bookPrice = bookPrice;

	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public double getBookPrice() {
		return this.bookPrice;
	}

	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}

	public String getBookDescription() {
		return this.bookDescription;
	}

	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}
	
	public String getBookISBN() {
		return this.bookISBN;
	}

	public void setBookISBN(String bookISBN) {
		this.bookISBN = bookISBN;
	}
	
	

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", bookAuthor=" + bookAuthor + ", bookDescription=" + bookDescription +", bookISBN=" + bookISBN + ", bookPrice="
				+  bookPrice + "]";
	}
	
	
	
	
}
