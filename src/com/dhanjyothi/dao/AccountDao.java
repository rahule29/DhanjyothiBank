package com.dhanjyothi.dao;

import java.util.List;

import javax.security.auth.login.AccountException;

import com.dhanjyothi.model.Account;
import com.dhanjyothi.model.Beneficiaries;
import com.dhanjyothi.model.Transaction;
import com.dhanjyothi.model.User;

public interface AccountDao {

	User getUserDetails(User user);	
	
	Account getAccountDetails(int userId, String accountType) throws AccountException;	
	
	void openSavingsAccount(Account account,boolean isSavingsAccountExists);
	
	void openTermAccount(Account account);	
	
	List<Account> getTermAccountDetails(int userId, String accountType) throws AccountException;	
	
	void saveBeneficiaries(Beneficiaries beneficiaries);	
	
	Account checkAccountExists(int accountId);	
	
	List<Beneficiaries> getAllBeneficiaries(User user);	
	
	void updateTransactionDetails(Transaction transaction);	
	
	List<Transaction> loadAllTransactions(Account account);	
	
	User isUserNameExists(String name);	
	
	User getUserById(int userId);

	Beneficiaries getBenificianyById(long beneficiaryId);

	Account getAccount(int accountId);

	void deleteBeneficiary(Beneficiaries beneficiary);

}
