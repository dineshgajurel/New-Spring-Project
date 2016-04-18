package com.javastud.springmvcweb.dao;

import com.javastud.springmvcweb.model.User;

public interface UserDao {
	//Using Hibernate
public User getUser(Long id);

public boolean validatUser(User user);
}
