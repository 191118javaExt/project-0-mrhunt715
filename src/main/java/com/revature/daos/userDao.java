package com.revature.daos;

import java.util.List;

import com.revature.models.User;

public interface userDao {
	User getUser();
	List<User> findAll();
	public User findById(int id);
	public boolean insertUser();
	public boolean updateUser();
	public boolean deleteUser();

}
