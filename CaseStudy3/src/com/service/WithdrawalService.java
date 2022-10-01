package com.service;

import com.interfaces.Withdrawal;
import com.main.model.Customer;

public class WithdrawalService implements Withdrawal {

	@Override
	public void withdrawal(Customer customer, double amount) {
		double bal=customer.getBalance();
		double newBalance=bal-amount;
		customer.setBalance(newBalance);
		
	}

}
