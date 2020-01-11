package com.revature.services;

import java.util.List;

import com.revature.models.User;
import com.revature.models.UserDTO;
import com.revature.repositories.UserDAOImpl;

public class UserService {
	public static List<User> findAll(){
		return new UserDAOImpl().findAll();
	}
	
	public static User findByUsername(String username) {
		List<User> allUsers = new UserDAOImpl().findAll();
		
		for(User u : allUsers) {
			if(u.getUsername().equals(username)) {
				return u;
			}
		}
		return null;
	}
	
	public static User login(String username, String password) {
		User u = findByUsername(username);
		if (u == null) {
			return null;
		}
		
		if (u.getPassword() == password.hashCode()) {
			return u;
		}
		else {
			return null;
		}
	}
	
	public static UserDTO convertToDTO(User u) {
		return new UserDTO(u.getId(), u.getFirst_name(), u.getLast_name(), u.getUsername(), 
				u.getPassword(), u.getEmail(), u.getRole_id());
	}
}
