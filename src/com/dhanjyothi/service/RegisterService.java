package com.dhanjyothi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dhanjyothi.exception.UserException;
import com.dhanjyothi.model.User;

@Service
public interface RegisterService {

	void saveRegister(User user) throws UserException;
	List<User> getAllUsers();
	User getUserByUsername(String userName) throws UserException;

}
