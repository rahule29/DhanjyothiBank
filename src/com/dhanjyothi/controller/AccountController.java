package com.dhanjyothi.controller;

import java.util.ArrayList;

import javax.security.auth.login.AccountException;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dhanjyothi.exception.UserException;
import com.dhanjyothi.model.Account;
import com.dhanjyothi.model.Transaction;
import com.dhanjyothi.model.User;
import com.dhanjyothi.service.AccountService;
import com.dhanjyothi.util.Constants;

@Controller
@RequestMapping("/accounts")
public class AccountController {
	
	private static final Logger logger = Logger.getLogger(AccountController.class);
	
	@Autowired
	private AccountService service;

	@GetMapping("/createsavingsaccount")
	public String loadAccountCreationPage(Model model,HttpServletRequest request) throws UserException, AccountException {
		if(null == request.getSession().getAttribute(Constants.LOGGED_USER)) {
			throw new UserException("No LoggedIn User found in Current Session");
		}
		User user = (User) request.getSession().getAttribute(Constants.LOGGED_USER);
		Account account = null;
		try {
			account = service.getAccountDetails(user.getUserId() , "SA");
		} catch (AccountException e) {
			logger.error("Error while getting account details: " + e.getMessage());
		}
		if(null == account) {
			service.openSavingsAccount(user);
			account = service.getAccountDetails(user.getUserId() , "SA");
		}
		
		model.addAttribute(account);
		request.getSession().setAttribute(Constants.IS_SA_ACCOUNT_EXISTS, account.getAccountId() != 0);
		
		return "savingsAccount";
	}
	
	@GetMapping(value = "/loadtermaccount")
	public String loadTermAccount(@ModelAttribute("account") Account account,Model model) {
		return null;
	}
	
	@PostMapping(value = "/createtermaccount")
	public String createTermAccount(@ModelAttribute("account") Account account,Model model,HttpServletRequest request,BindingResult bindingResult) {
		return null;
	}
	
	@GetMapping("/viewtransactions")
	public ModelAndView loadTransactionDetails(Model model,HttpServletRequest request) throws UserException {
		if(null == request.getSession().getAttribute(Constants.LOGGED_USER)) {
			throw new UserException("No LoggedIn User found in Current Session");
		}
		User user = (User) request.getSession().getAttribute(Constants.LOGGED_USER);
		Account account = null;
		ModelAndView mav = new ModelAndView();
		try {
			account = service.getAccountDetails(user.getUserId() , "SA");
			mav.addObject("transactions", service.loadAllTransactions(account));
		} catch (AccountException e) {
			logger.error("Error while getting account details: " + e.getMessage());
			mav.addObject("transactions", new ArrayList<Transaction>());
		}
		
		mav.setViewName("viewTransactions");
		return mav;
	}
	
	@GetMapping("/chequeBookRequest")
	public String chequeBookRequest() {
		return "chequeBookRequest";
	}
	
}
