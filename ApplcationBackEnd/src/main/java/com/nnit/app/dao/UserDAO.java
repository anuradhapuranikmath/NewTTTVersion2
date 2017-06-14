package com.nnit.app.dao;

import java.util.List;

import com.niit.app.domain.User;

public interface UserDAO {
	
	public User insert(User user);
	public User getUserById(int id);
	public List<User> getAllUsers();
	public User login(User user);

}