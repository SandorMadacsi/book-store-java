package com.bs.models;

import java.util.List;
import java.util.ArrayList;

public class Basket {

	private List<BasketItem> books;
	private double total;

	public Basket() {
		super();
		this.books = new ArrayList<>();
		this.total = 0;
	}

	public List<BasketItem> getBooks() {
		return books;
	}

	public void setBooks(List<BasketItem> books) {
		this.books = books;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Basket [books=" + books + ", total=" + total + "]";
	}
	
	
}
