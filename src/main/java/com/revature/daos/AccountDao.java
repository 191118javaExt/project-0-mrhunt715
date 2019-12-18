package com.revature.daos;

import java.util.List;

import com.revature.models.Account;

public interface AccountDao {

	public List<Account> findAll(); 
	public Account findById(int id);
	public List<Account>findByUserId(int id);
	public boolean insert(Account e);
	public boolean update(Account e);
	public List<Account> findStatus();
	public void deleteAccount(int acct_id, int userId);
	public void addUserToAcct(int acct_id, String newUserEmail);
	public void transferMoney(int acct_idFrom, int acct_idTo, double amt);
	public void withdrawFrom(int acct_id, double amt);
	public void depositTo(int acct_id, double amt);
	public Account createAcct(Account acct, int userId);
		
	}
