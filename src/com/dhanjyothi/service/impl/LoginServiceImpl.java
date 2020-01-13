package com.dhanjyothi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dhanjyothi.dao.LoginDao;
import com.dhanjyothi.model.User;
import com.dhanjyothi.service.LoginService;

@Component
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDao loginDao;
	
	@Override
	public int validateUser(User user) {
		return loginDao.validateUser(user);
	}

}
