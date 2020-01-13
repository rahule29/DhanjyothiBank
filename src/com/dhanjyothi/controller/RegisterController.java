package com.dhanjyothi.controller;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dhanjyothi.enums.UserStatus;
import com.dhanjyothi.exception.UserException;
import com.dhanjyothi.model.User;
import com.dhanjyothi.service.AccountService;
import com.dhanjyothi.service.RegisterService;
import com.dhanjyothi.util.Constants;

@Controller
@RequestMapping("/register")
public class RegisterController {
	
	@Autowired
	private RegisterService registerService;
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping("/signup")
	public ModelAndView showRegister() {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("register");
		mav.addObject(new User());
		return mav;
	}
	
	@PostMapping("/save")
	public ModelAndView saveRegister(@ModelAttribute("user") User user, BindingResult bindingResult) throws UserException {
		ModelAndView mav = new ModelAndView();
		if (bindingResult.hasErrors()) {
			mav.setViewName("error");
            return mav;
        }
		registerService.saveRegister(user);
		mav.setViewName("login");
		mav.addObject(user);
		return mav;
	}
	
	@GetMapping("/getall")
	public ModelAndView getAllUsers(HttpServletRequest request) throws UserException {
		User user = registerService.getUserByUsername(request.getParameter("username"));
		ModelAndView mav = new ModelAndView();
		mav.setViewName("viewAllUsers");
		mav.addObject("users", registerService.getAllUsers());
		request.getSession().setAttribute(Constants.LOGGED_USER, user);
		request.getSession().setMaxInactiveInterval(2000);
		return mav;
	}
	
	@GetMapping("/changeStatus/{userId}")
	public String changeStatus(@PathVariable("userId") int userId) throws UserException {
		User user = accountService.getUserById(userId);
		user.setUserStatus(UserStatus.ACTIVE.getDesc().equalsIgnoreCase(user.getUserStatus()) ? UserStatus.IN_ACTIVE.getDesc() : UserStatus.ACTIVE.getDesc());
		registerService.saveRegister(user);
		return "success";
	}
	
	@GetMapping("/changeRole/{userId}")
	public String changeRole(@PathVariable("userId") int userId, @PathParam("role") String role) throws UserException {
		User user = accountService.getUserById(userId);
		user.setUserRole(role);
		registerService.saveRegister(user);
		return "success";
	}
	
}
