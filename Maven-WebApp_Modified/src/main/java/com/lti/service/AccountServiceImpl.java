package com.lti.service;

import java.util.List;

import com.lti.bean.Account;

import com.lti.dao.AccountDAOImpl;

public class AccountServiceImpl 
{
	private AccountDAOImpl dao=new AccountDAOImpl();

	
	public boolean createNewAccount(Account ob) 
	{
		// TODO Auto-generated method stub
		return dao.insertAccount(ob);
	}

	
	public List<Account> getAllAccounts() 
	{
		// TODO Auto-generated method stub
		return dao.getAllAccount();
	}

	
	public boolean withdraw(Account ob, double amount) {
		// TODO Auto-generated method stub
		double originalbalance=ob.getBalance();
		originalbalance=originalbalance-amount;
		ob.setBalance(originalbalance);
		return dao.updateAccount(ob);
		
	}

	
	public boolean deleteAccount(Account ob) {
		// TODO Auto-generated method stub
		return dao.deleteAccount(ob);
	}

	
	public Account getMyAccount(int accno) {
		// TODO Auto-generated method stub
		return dao.getAccountById(accno);
	}

}
