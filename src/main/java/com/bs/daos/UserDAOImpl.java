package com.bs.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bs.utils.DatabaseConnection;
import com.bs.models.User;

public class UserDAOImpl implements UserDAO{

	private Connection con;
	private PreparedStatement pst;
	private ResultSet rs;
	@Override
	public User registerUser(User u) {
		this.con = DatabaseConnection.getConnection();
		try {
			this.pst = this.con.prepareStatement("INSERT into users( first_name, last_name, email, password) VALUES(?,?,?,?)");
			
			this.pst.setString(1, u.getFirstName());
			this.pst.setString(2, u.getLastName());
			this.pst.setString(3, u.getEmail());
			this.pst.setString(4, u.getPassword());
			
			int i = this.pst.executeUpdate();
			if(i > 0) {
				return u;
			}
		}
		catch(SQLException exc) {
			System.out.println(exc);
			return null;
		}
		return null;
	}
	@Override
	public User loginUser(String email, String password) {
		
		
		this.con = DatabaseConnection.getConnection();
		try {
			this.pst = this.con.prepareStatement("SELECT * from users WHERE email = ? AND password = ?");
			
			//Replace ?'s 
			this.pst.setString(1, email);
			this.pst.setString(2, password);
			
			this.rs = this.pst.executeQuery();
			

			if(this.rs.next()) {
				User u = new User(this.rs.getString("first_name"), this.rs.getString("last_name"), this.rs.getString("email"),this.rs.getString("password"));
				return u;
			}
			
		}
		catch(SQLException exc) {
			System.out.println(exc);
			return null;
		}
		return null;
	}
	
	@Override
	public User editUser(String email , User u)
	{


			this.con = DatabaseConnection.getConnection();
			try {
			this.pst = this.con.prepareStatement("UPDATE users SET first_name = ? , last_name = ? , email = ?, password = ? WHERE email = ?");
		
				this.pst.setString(1, u.getFirstName());
				this.pst.setString(2, u.getLastName());
				this.pst.setString(3, u.getEmail());
				this.pst.setString(4, u.getPassword());
				this.pst.setString(5, email);

				
				int i = this.pst.executeUpdate();
				if(i > 0) {
					return u;
				}
			}
			catch(SQLException exc) {
				System.out.println(exc);
				return null;
			}
			return null;
	}
	
}
