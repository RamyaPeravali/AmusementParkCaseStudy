package com.capgemini.bankapp.service;

import java.util.List;

import com.capgemini.bankapp.entity.Account;
import com.capgemini.bankapp.exception.AccountException;

public interface AccountService {
	boolean addAccount(Account account);
	boolean transferFund(int from, int to, double amt) throws AccountException;
	List<Account> viewAccount();
	Boolean delAccount(Integer accId);
	void updateAccount(Account account);
}
