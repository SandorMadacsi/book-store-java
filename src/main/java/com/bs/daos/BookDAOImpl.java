package com.bs.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import com.bs.models.Book;
import com.bs.utils.DatabaseConnection;

public class BookDAOImpl implements BookDAO{
	
	private Connection con;
	private PreparedStatement pst;
	private ResultSet rs;
	private List<Book> booklist;
	private Book b;

	@Override
	public List<Book> listBook() {
		this.booklist = new ArrayList<>();
		this.con = DatabaseConnection.getConnection();
		//returns all books from the database and returns it as a list
		try {
			this.pst = this.con.prepareStatement("Select * FROM books");
			
			this.rs = this.pst.executeQuery();
			while(this.rs.next()) {
				Book b = new Book(this.rs.getInt("b_id"),
	 this.rs.getString("b_name"),
	 this.rs.getString("b_author"),
	 this.rs.getString("b_description"),
	 this.rs.getString("b_isbn"),
	 this.rs.getDouble("b_price")
	);
				this.booklist.add(b);
				
			}
			return booklist;
		}
		catch(SQLException exc) {
			System.out.println(exc);
			return null;
		}
	}
	
	public Book getSingleBook(String isbn) {
		this.con = DatabaseConnection.getConnection();
		//gets a book based on isbn and returns that book
		try {
			this.pst = this.con.prepareStatement("Select * FROM books WHERE b_isbn = ?  ");
			this.pst.setString(1, isbn);
			
			this.rs = this.pst.executeQuery();
			if(this.rs.next()) {
				this.b = new Book(this.rs.getInt("b_id"),
	 this.rs.getString("b_name"),
	 this.rs.getString("b_author"),
	 this.rs.getString("b_description"),
	 this.rs.getString("b_isbn"),
	 this.rs.getDouble("b_price"));

		}
				return b;
				
			
		}
		catch(SQLException exc) {
			System.out.println(exc);
			return null;
		}
	}

}
