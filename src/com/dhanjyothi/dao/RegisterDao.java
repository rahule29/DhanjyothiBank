package com.dhanjyothi.dao;

import java.util.List;

import com.dhanjyothi.exception.UserException;
import com.dhanjyothi.model.User;

public interface RegisterDao {
	
	void saveRegister(User user);
	List<User>  getAllUsers();
	User getUserByUserName(String userName) throws UserException;


}
