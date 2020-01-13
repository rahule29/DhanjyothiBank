package com.dhanjyothi.controller;

import java.util.Date;

import javax.security.auth.login.AccountException;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dhanjyothi.enums.AccountType;
import com.dhanjyothi.enums.TransactionType;
import com.dhanjyothi.exception.TransactionException;
import com.dhanjyothi.exception.UserException;
import com.dhanjyothi.model.Account;
import com.dhanjyothi.model.Beneficiaries;
import com.dhanjyothi.model.Transaction;
import com.dhanjyothi.model.User;
import com.dhanjyothi.service.AccountService;
import com.dhanjyothi.util.Constants;

@Controller
@RequestMapping("/fundTransfer")
public class FundTransferController {

	@Autowired
	private AccountService accountService;

	@GetMapping("/loadbeneficiary")
	private ModelAndView loadBeneficiaryPage(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("addBeneficiary");
		mav.addObject("pageStatus", "new");
		mav.addObject(new Beneficiaries());
		User user = (User) request.getSession().getAttribute(Constants.LOGGED_USER);
		mav.addObject("allBeneficiaries", accountService.getAllBeneficiaries(user));
		return mav;
	}

	@GetMapping("/loadtransfer")
	private ModelAndView loadTransferPage(@ModelAttribute("transaction") Transaction transaction, Model model,
			HttpServletRequest request) throws UserException, AccountException {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("fundTransfer");
		mav.addObject("pageStatus", "new");

		if (null == request.getSession().getAttribute(Constants.LOGGED_USER)) {
			throw new UserException("No LoggedIn User found in Current Session");
		}
		User user = (User) request.getSession().getAttribute(Constants.LOGGED_USER);
		mav.addObject("beneficiries", accountService.getAllBeneficiaries(user));
		return mav;
	}

	@GetMapping("/beneficiarywithinbank")
	private String beneficiaryWithinBank(@ModelAttribute("beneficiary") Beneficiaries beneficiary, Model model) {
		return null;
	}

	@GetMapping("/beneficiaryotherbank")
	private String beneficiaryOtherBank(@ModelAttribute("beneficiary") Beneficiaries beneficiary, Model model) {
		return null;
	}

	@PostMapping("/savebeneficiary")
	private ModelAndView saveBeneficiary(@ModelAttribute("beneficiary") Beneficiaries beneficiary, Model model,
			BindingResult bindingResult, HttpServletRequest request) throws UserException, AccountException {
		// Add Validations
		if (null == request.getSession().getAttribute(Constants.LOGGED_USER)) {
			throw new UserException("No LoggedIn User found in Current Session");
		}
		User user = (User) request.getSession().getAttribute(Constants.LOGGED_USER);
		Account account = accountService.getAccountDetails(user.getUserId(), AccountType.SA.name());
		ModelAndView mav = new ModelAndView();
		if(null != accountService.getAccountById(beneficiary.getBeneficiaryAccountNo())) {
			accountService.saveBeneficiaries(account, beneficiary);
			mav.addObject("MSG", "Successfully added beneficiary");
			mav.addObject("pageStatus", "view");
		}else {
			mav.addObject("MSG", "No Beneficiary Account Found");
		}
		mav.setViewName("addBeneficiary");
		mav.addObject(beneficiary);
		mav.addObject("allBeneficiaries", accountService.getAllBeneficiaries(user));
		return mav;
	}
	
	@GetMapping("/deleteBeneficiary/{beneficiaryId}")
	public String changeRole(@PathVariable("beneficiaryId") long beneficiaryId) throws UserException {
		accountService.deleteBeneficiaryById(beneficiaryId);
		return "success";
	}

	@PostMapping("/transferamt")
	private ModelAndView transferAmount(@ModelAttribute("beneficiary") Beneficiaries beneficiary, Model model,
			BindingResult bindingResult, HttpServletRequest request)
			throws UserException, AccountException, NumberFormatException, TransactionException {

		if (null == request.getSession().getAttribute(Constants.LOGGED_USER)) {
			throw new UserException("No LoggedIn User found in Current Session");
		}
		User user = (User) request.getSession().getAttribute(Constants.LOGGED_USER);
		
		
		Account debitAccount = accountService.getAccountDetails(user.getUserId(), AccountType.SA.name());
		Transaction debitTransaction = new Transaction();
		debitTransaction.setBenificiary(beneficiary);
		debitTransaction.setTransactionAmount(Long.parseLong(request.getParameter("amount")));
		debitTransaction.setTransactionDescription(request.getParameter("remarks"));
		debitTransaction.setTransactionDate(new Date());
		debitTransaction.setBenificiary(accountService.getBenificianyById(Long.parseLong(request.getParameter("beneficiary"))));
		debitTransaction.setAccount(debitAccount);
		debitTransaction.setTransactionType(TransactionType.DEBIT.getDesc());
		
		accountService.updateFromAccount(debitAccount, Long.parseLong(request.getParameter("amount")), debitTransaction);

		accountService.updateToAccount(debitTransaction);
		
		// update Debit Transaction
		accountService.updateTransaction(debitTransaction);
		
		// Update Credit Transaction
		Account creditAccount = accountService.getAccountById(debitTransaction.getBenificiary().getBeneficiaryAccountNo());
		Transaction creditTransaction = new Transaction();
		creditTransaction.setTransactionAmount(Long.parseLong(request.getParameter("amount")));
		creditTransaction.setTransactionDescription(request.getParameter("remarks"));
		creditTransaction.setTransactionDate(new Date());
		creditTransaction.setAccount(creditAccount);
		//creditTransaction.setBenificiary(accountService.getBenificianyById(debitTransaction.getAccount().getAccountId()));
		creditTransaction.setTransactionType(TransactionType.CREDIT.getDesc()); 
		accountService.updateTransaction(creditTransaction);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("fundTransfer");
		mav.addObject("transaction", debitTransaction);
		mav.addObject("pageStatus", "view");
		mav.addObject("beneficiries", accountService.getAllBeneficiaries(user));

		return mav;
	}
}
