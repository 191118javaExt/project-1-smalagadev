package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.User;
import com.revature.util.ConnectionUtil;

public class UserDAOImpl implements UserDAO {
	
	private static Logger logger = Logger.getLogger(UserDAOImpl.class);

	@Override
	public List<User> findAll() {
		
		List<User> list = new ArrayList<>();
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "SELECT * FROM Users;";
			
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("users_id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String username = rs.getString("username");
				int password = rs.getInt("password");
				String email = rs.getString("email");
				int role_id = rs.getInt("role_id");
				
				User u = new User(id, first_name, last_name, username, password, email, role_id);
				list.add(u);
			}
			rs.close();
		}
		catch(SQLException e) {
			logger.warn(e);
			return null;
		}

		return list;
	}

	@Override
	public User findByUsername(String attemptedUsername) {
		try(Connection conn= ConnectionUtil.getConnection()){
			
			String sql = "SELECT * FROM Users WHERE username = ?;";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, attemptedUsername);
			
			ResultSet rs = stmt.executeQuery();
			
			rs.next();
			int id = rs.getInt("users_id");
			String first_name = rs.getString("first_name");
			String last_name = rs.getString("last_name");
			String username = rs.getString("username");
			int password = rs.getInt("password");
			String email = rs.getString("email");
			int role_id = rs.getInt("role_id");
			
			
			User u = new User(id, first_name, last_name, username, password, email, role_id);
			rs.close();
			
			return u;
		}
		catch(SQLException e) {
			logger.warn(e);
			return null;
		}
	}

}
