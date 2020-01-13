package com.dhanjyothi.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.security.auth.login.AccountException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.dhanjyothi.dao.AccountDao;
import com.dhanjyothi.enums.AccountType;
import com.dhanjyothi.exception.TransactionException;
import com.dhanjyothi.model.Account;
import com.dhanjyothi.model.Beneficiaries;
import com.dhanjyothi.model.Transaction;
import com.dhanjyothi.model.User;
import com.dhanjyothi.service.AccountService;
import com.dhanjyothi.util.Constants;

@Component
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDao accountDao; 
	
	@Override
	public User getUserDetails(User user) {
		return accountDao.getUserDetails(user);
	}


	@Override
	public Account getAccountById(int accountId) throws AccountException {
		return accountDao.getAccount(accountId);
	}
	
	@Override
	public Account getAccountDetails(int userId, String accountType) throws AccountException {
		return accountDao.getAccountDetails(userId, accountType);
	}

	@Override
	public void openSavingsAccount(User user) {
		Account account = new Account();
		account.setUser(user);
		account.setAccountType("SA");
		account.setAccountDeposit(5000);
		account.setAccountCreatedDate(new Date());
		account.setAccountUpdatedDate(new Date());
		accountDao.openSavingsAccount(account, false);
	}

	@Override
	public void openTermAccount(Account account, User user) {
		account.setUser(user);
		accountDao.openTermAccount(account);
	}

	@Override
	public List<Account> getTermAccountDetails(int userId, String accountType) throws AccountException {
		return accountDao.getTermAccountDetails(userId, accountType);
	}

	@Override
	public Map<Integer, String> getTenureDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkSavingsAccBalance(long termAmt) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateSavingsAccount(Account account, User user) {
		accountDao.openSavingsAccount(account, true);
	}

	@Override
	public void saveBeneficiaries(Account account, Beneficiaries beneficiaries) {
		beneficiaries.setUser(account.getUser());
		accountDao.saveBeneficiaries(beneficiaries);
	}

	@Override
	public boolean checkAccountExists(Beneficiaries beneficiaries) {
		try {
			return accountDao.getAccountDetails(beneficiaries.getUser().getUserId(), AccountType.SA.name()) == null ? false : true;
		} catch (AccountException e) {
			return false;
		}
	}

	@Override
	public List<Beneficiaries> getAllBeneficiaries(User user) {
		return accountDao.getAllBeneficiaries(user);
	}
	
	@Override
	public void updateTransaction(Transaction transaction) {
		accountDao.updateTransactionDetails(transaction);
	}

	@Override
	@Transactional
	public void updateFromAccount(Account account, long transAmt, Transaction transaction) throws TransactionException {
		// Update From account balance
		if(account.getAccountDeposit() - transAmt > Constants.MINIMUM_BALANCE) {
			account.setAccountDeposit(account.getAccountDeposit() - transAmt);
			updateSavingsAccount(account, account.getUser());
		}else {
			throw new TransactionException("No Minimum Balance");
		}
	}

	@Override
	public void updateToAccount(Transaction transaction) {
		// Update To Account Balance 
		Account account = accountDao.getAccount(transaction.getBenificiary().getBeneficiaryAccountNo());
		account.setAccountDeposit(account.getAccountDeposit() + transaction.getTransactionAmount());
		updateSavingsAccount(account, account.getUser());
	}

	@Override
	public List<Transaction> loadAllTransactions(Account account) {
		return accountDao.loadAllTransactions(account);
	}

	@Override
	public boolean isUserNameExists(String name) {
		return accountDao.isUserNameExists(name) != null;
	}

	@Override
	public Account checkAccountExists(int accountId) {
		return accountDao.checkAccountExists(accountId);
	}

	@Override
	public User getUserById(int userId) {
		return accountDao.getUserById(userId);
	}

	@Override
	public void deleteBeneficiaryById(long beneficiaryId) {
		accountDao.deleteBeneficiary(getBenificianyById(beneficiaryId));
	}

	@Override
	public Beneficiaries getBenificianyById(long benificiaryId) {
		return accountDao.getBenificianyById(benificiaryId);
	}
}
