package com.service;

import com.interfaces.Deposit;
import com.main.model.Customer;

public class DepositService implements Deposit{

	public void deposit(Customer customer, double amount) {
		double bal=customer.getBalance();
		double newBalance=bal+amount;
		customer.setBalance(newBalance);
	}

}
