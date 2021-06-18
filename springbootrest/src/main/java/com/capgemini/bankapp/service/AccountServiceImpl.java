package com.capgemini.bankapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.bankapp.dao.AccountDao;
import com.capgemini.bankapp.entity.Account;
import com.capgemini.bankapp.exception.AccountException;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountDao accountDao;

	@Override
	public boolean addAccount(Account account) {
		Account accountResult = accountDao.save(account);
		if (accountResult != null) {
			return true;
		} else
			return false;
	}

	@Override
	public boolean transferFund(int from, int to, double amt) throws AccountException {
		Account fromAccount, toAccount;
		Optional<Account> fromAccountOptional = accountDao.findById(from);
		if (fromAccountOptional.isPresent()) {
			fromAccount = fromAccountOptional.get();
		} else {
			throw new AccountException("From Account ID is not present");
		}

		Optional<Account> toAccountOptional = accountDao.findById(to);
		if (toAccountOptional.isPresent()) {
			toAccount = toAccountOptional.get();
		} else {
			throw new AccountException("To Account ID is not present");
		}

		if (fromAccount.getBalance() < amt)
			throw new AccountException("Insufficient Balance");
		fromAccount.setBalance(fromAccount.getBalance() - amt);
		toAccount.setBalance(toAccount.getBalance() + amt);
		accountDao.updateBalance(fromAccount.getBalance(), fromAccount.getAccId());
		accountDao.updateBalance(toAccount.getBalance(), toAccount.getAccId());
		return true;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Account> viewAccount() {
		return accountDao.findAll();
	}

	@Override
	public Boolean delAccount(Integer accId) {
		// TODO Auto-generated method stub

		accountDao.deleteById(accId);

		return true;
	}

	@Override
	public void updateAccount(Account newAccountData) throws AccountException {
		// TODO Auto-generated method stub

		Optional<Account> account = accountDao.findById(newAccountData.getAccId());
		if (account.isPresent()) {
			accountDao.save(newAccountData);

		} else
			throw new AccountException("Account Id Does not exists to update");

	}

}
