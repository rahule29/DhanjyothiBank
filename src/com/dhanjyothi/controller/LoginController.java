package com.dhanjyothi.controller;

import javax.security.auth.login.AccountException;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dhanjyothi.enums.AccountType;
import com.dhanjyothi.enums.UserRole;
import com.dhanjyothi.enums.UserStatus;
import com.dhanjyothi.exception.UserException;
import com.dhanjyothi.model.Account;
import com.dhanjyothi.model.User;
import com.dhanjyothi.service.AccountService;
import com.dhanjyothi.service.LoginService;
import com.dhanjyothi.service.RegisterService;
import com.dhanjyothi.util.Constants;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	private static final Logger logger = Logger.getLogger(LoginController.class);
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	RegisterService registerService;
	
	@Autowired
	RegisterController registerController;

	@GetMapping("")
	public ModelAndView showRegister() {
		logger.debug("Inside LoginController showRegister method");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		return mav;
	}
	
	@PostMapping("/submit")
	public ModelAndView validateUser(@ModelAttribute("cust") User user,HttpServletRequest request, Model model) throws UserException {
		user.setUserName(request.getParameter("username"));
		user.setPassword(request.getParameter("pass"));
		
		ModelAndView mav = new ModelAndView();
		if(loginService.validateUser(user) == 1) {
			user = registerService.getUserByUsername(user.getUserName());
			// Redirect to Users Status Screen in case of admin role login
			if(UserRole.ADMIN.getDesc().equalsIgnoreCase(user.getUserRole())) {
				return registerController.getAllUsers(request);
			}else if(!UserStatus.ACTIVE.getDesc().equalsIgnoreCase(user.getUserStatus())) {
				mav.setViewName("login");
				mav.addObject("errorMsg", "User is not active, please contact admin@dhanjyothibank.com");
				return mav;
			}
			
			Account account = new Account();
			try {
				account = accountService.getAccountDetails(user.getUserId(), AccountType.SA.name());
			} catch (AccountException e) {
				logger.info("No account found for current user: "+ user.getUserName());
			}
			mav.addObject("savingsAccount", account);
			mav.setViewName("accountSummary");
			request.getSession().setAttribute(Constants.LOGGED_USER, user);
			request.getSession().setAttribute(Constants.IS_SA_ACCOUNT_EXISTS, account.getAccountId() != 0);
			request.getSession().setMaxInactiveInterval(2000);
			
			return mav;
		}
		mav.setViewName("login");
		mav.addObject("errorMsg", "Please check userId and Password are correct.");
		return mav;
	}
	
	@GetMapping("/accsummary")
	public ModelAndView loadAccSummary(HttpServletRequest request, Model model) throws UserException {
		ModelAndView mav = new ModelAndView();
		if(null != request.getSession().getAttribute(Constants.LOGGED_USER)) {
			User user = (User) request.getSession().getAttribute(Constants.LOGGED_USER);
			Account account = new Account();
			try {
				account = accountService.getAccountDetails(user.getUserId(), AccountType.SA.name());
			} catch (AccountException e) {
				logger.info("No account found for current user: "+ user.getUserName());
			}
			mav.addObject("savingsAccount", account);
			mav.setViewName("accountSummary");
			request.getSession().setAttribute(Constants.LOGGED_USER, user);
			request.getSession().setAttribute(Constants.IS_SA_ACCOUNT_EXISTS, account.getAccountId() != 0);
			request.getSession().setMaxInactiveInterval(2000);
			
			return mav;
		}
		mav.setViewName("login");
		return mav;
	}
	
	@PostMapping("/adduser")
	public String addUser(HttpServletRequest request, Model model) {
		return null;
	}
	
	@GetMapping("/logout")
	public String logoutPage(HttpServletRequest request) {
		request.getSession().removeAttribute(Constants.LOGGED_USER);
		request.getSession().invalidate();
		return "login";
	}
}
