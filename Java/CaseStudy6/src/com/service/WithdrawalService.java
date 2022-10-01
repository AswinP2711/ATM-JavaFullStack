package com.service;

import com.exep.InsufficientFundsException;
import com.exep.OverTheLimitException;
import com.interfaces.Withdrawal;
import com.main.model.Customer;

public class WithdrawalService implements Withdrawal {

	@Override
	public void withdrawal(Customer customer, double amount) throws OverTheLimitException,InsufficientFundsException {
		double bal=customer.getBalance();
		if(amount>bal) {
			throw new InsufficientFundsException("Insufficient Fund");
		}else if (amount>limit) {
			throw new OverTheLimitException("Limit 50000 Exceeded");
		}else {
			double newBalance=bal-amount;
			customer.setBalance(newBalance);
		}
		
		
		
	}

}
