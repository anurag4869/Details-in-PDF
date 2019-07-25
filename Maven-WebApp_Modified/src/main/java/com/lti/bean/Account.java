package com.lti.bean;

import java.time.LocalDate;

public class Account 
{
	private int aid;
	private String aname;
	private LocalDate dob;
	private double balance;
	
	public Account()
	{
		// TODO Auto-generated constructor stub
	}

	public Account(int aid, String aname, LocalDate dob, double balance) {
		super();
		this.aid = aid;
		this.aname = aname;
		this.dob = dob;
		this.balance = balance;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() 
	{
		return "Account [aid=" + aid + ", aname=" + aname + ", dob=" + dob + ", balance=" + balance + "]";
	}
	
	
}
