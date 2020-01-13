package com.dhanjyothi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.dhanjyothi.dao.RegisterDao;
import com.dhanjyothi.exception.UserException;
import com.dhanjyothi.model.User;
import com.dhanjyothi.service.RegisterService;

@Component
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private RegisterDao dao;
	
	@Override
	@Transactional
	public void saveRegister(User user) throws UserException {
		
		if(null != user) {
			
			// Add Validation
			
			dao.saveRegister(user);
		}else {
			throw new UserException("Supplied User is Null");
		}
		
	}

	@Override
	public User getUserByUsername(String userName) throws UserException {
		return dao.getUserByUserName(userName);
	}
	
	@Override
	public List<User> getAllUsers() {
		return dao.getAllUsers();
	}

}
