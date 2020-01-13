package com.dhanjyothi.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dhanjyothi.exception.UserException;
import com.dhanjyothi.model.User;
import com.dhanjyothi.service.AccountService;
import com.dhanjyothi.service.RegisterService;
import com.dhanjyothi.util.Constants;

@Controller
@RequestMapping("/")
public class DefaultController {
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	private RegisterService registerService;
	
	/*
	 * @PersistenceContext private EntityManager entityManager;
	 */
	private static final Logger logger = Logger.getLogger(DefaultController.class);

	@GetMapping("/")
	private String loadAccountCreationPage(Model model,HttpServletRequest request) throws UserException {
		logger.debug("Inside default controller method");
		request.getSession().setAttribute(Constants.LOGGED_USER, registerService.getUserByUsername("Reshma"));
		return "login";
	}
	
	@PostMapping(value =  "/createUser")
	private String createUser(Model model,HttpServletRequest request) {
		logger.debug("Inside default createUser method");
		
		User user = new User();
		user.setFirstName("Rahul");
		user.setLastName("Badiger");
		user.setAddressLine1("Kobbarnas Vag 1C");
		user.setAddressLine2("LH 1102");
		user.setCity("Gothenburg");
		user.setDob("29/11/1986");
		user.setPin("41647");
		user.setState("Sweden");
		user.setUserRole("ADMIN");
		user.setUserStatus("Active");
		user.setUserName("Rahul");
		
		try {
			registerService.saveRegister(user);
		} catch (UserException e) {
			e.printStackTrace();
		}
		
		return "welcome";
	}
	
	
	@GetMapping(value =  "/removeUser")
	private String removeUser(Model model,HttpServletRequest request) {
		logger.debug("Inside default createUser method");
		
		User user = new User();
		user.setFirstName("Rahul");
		user.setLastName("Badiger");
		user.setAddressLine1("Kobbarnas Vag 1C");
		user.setAddressLine2("LH 1102");
		user.setCity("Gothenburg");
		user.setDob("29/11/1986");
		user.setPin("41647");
		user.setState("Sweden");
		user.setUserRole("ADMIN");
		user.setUserStatus("Active");
		
		try {
			registerService.saveRegister(user);
		} catch (UserException e) {
			e.printStackTrace();
		}
		
		return "welcome";
	}
}
