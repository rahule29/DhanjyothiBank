package com.dhanjyothi.dao.impl;

import java.util.List;

import javax.security.auth.login.AccountException;
import javax.transaction.Transactional;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.dhanjyothi.dao.AccountDao;
import com.dhanjyothi.database.CustomHibernateDaoSupport;
import com.dhanjyothi.model.Account;
import com.dhanjyothi.model.Beneficiaries;
import com.dhanjyothi.model.Transaction;
import com.dhanjyothi.model.User;

@Repository
@Transactional
@SuppressWarnings({ "unchecked", "deprecation" })
public class AccountDaoImpl extends CustomHibernateDaoSupport implements AccountDao {

	@Override
	public User getUserDetails(User user) {
		return getCurrentSession().load(User.class, user.getUserId());
	}

	@Override
	public Account getAccountDetails(int userId, String accountType) throws AccountException {
		User user = new User();
		user.setUserId(userId);
		List<Account> accounts = getCurrentSession().createCriteria(Account.class).add(Restrictions.eq("user", user))
				.add(Restrictions.eq("accountType", accountType)).list();
		if (accounts.isEmpty()) {
			throw new AccountException("Account not found with userId: " + userId + " And AccountType: " + accountType);
		}
		return accounts.get(0);
	}

	@Override
	public void openSavingsAccount(Account account, boolean isSavingsAccountExists) {
		save(account);
	}

	@Override
	public void openTermAccount(Account account) {
		save(account);
	}

	@Override
	public List<Account> getTermAccountDetails(int userId, String accountType) throws AccountException {
		List<Account> accounts = getCurrentSession().createCriteria(User.class).add(Restrictions.eq("userId", userId))
				.add(Restrictions.eq("accountType", accountType)).list();
		if (accounts.isEmpty()) {
			throw new AccountException("Account not found with userId: " + userId + " And AccountType: " + accountType);
		}
		return accounts;
	}

	@Override
	public void saveBeneficiaries(Beneficiaries beneficiaries) {
		save(beneficiaries);
	}

	@Override
	public Account checkAccountExists(int accountId) {
		return getCurrentSession().get(Account.class, accountId);
	}
	
	@Override
	public List<Beneficiaries> getAllBeneficiaries(User user) {
		return getCurrentSession().createCriteria(Beneficiaries.class)
				.add(Restrictions.eq("user", user)).list();
	}

	@Override
	public void updateTransactionDetails(Transaction transaction) {
		save(transaction);
	}

	@Override
	public List<Transaction> loadAllTransactions(Account account) {
		return getCurrentSession().createCriteria(Transaction.class)
				.add(Restrictions.eq("account", account)).list();
	}

	@Override
	public User isUserNameExists(String name) {
		List<User> users = getCurrentSession().createCriteria(User.class)
			.add(Restrictions.eq("userName", name)).list();
		if(users.isEmpty()) {
			return null;
		}
		return users.get(0);
	}

	@Override
	public User getUserById(int userId) {
		return getCurrentSession().get(User.class, userId);
	}

	@Override
	public Beneficiaries getBenificianyById(long beneficiaryId) {
		return getCurrentSession().get(Beneficiaries.class, beneficiaryId);
	}

	@Override
	public Account getAccount(int accountId) {
		return getCurrentSession().get(Account.class, accountId);
	}
	
	@Override
	public void deleteBeneficiary(Beneficiaries beneficiary) {
		getCurrentSession().delete(beneficiary);
	}

}
