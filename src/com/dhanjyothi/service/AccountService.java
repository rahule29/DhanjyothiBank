package com.dhanjyothi.service;

import java.util.List;
import java.util.Map;

import javax.security.auth.login.AccountException;

import org.springframework.stereotype.Service;

import com.dhanjyothi.exception.TransactionException;
import com.dhanjyothi.model.Account;
import com.dhanjyothi.model.Beneficiaries;
import com.dhanjyothi.model.Transaction;
import com.dhanjyothi.model.User;

@Service
public interface AccountService {
	
	Account getAccountById(int accountId) throws AccountException;

	User getUserDetails(User user);
	
	Account getAccountDetails(int userId, String accountType) throws AccountException;
	
	void openSavingsAccount(User user);
	
	void openTermAccount(Account account, User user);
	
	List<Account> getTermAccountDetails(int userId, String accountType) throws AccountException;
	
	Map<Integer, String> getTenureDetails();
	
	boolean checkSavingsAccBalance(long termAmt);
	
	void updateSavingsAccount(Account account, User user);
	
	void saveBeneficiaries(Account account,Beneficiaries beneficiaries);
	
	boolean checkAccountExists(Beneficiaries beneficiaries);
	
	List<Beneficiaries> getAllBeneficiaries(User user);
	
	void updateFromAccount(Account account,long transAmt,Transaction transaction) throws TransactionException;
	
	void updateToAccount(Transaction transaction);
	
	List<Transaction> loadAllTransactions(Account account);
	
	boolean isUserNameExists(String name);
	
	Account checkAccountExists(int accountId);
	
	User getUserById(int userId);

	void updateTransaction(Transaction transaction);

	Beneficiaries getBenificianyById(long benificiaryId);

	void deleteBeneficiaryById(long beneficiaryId);

}
