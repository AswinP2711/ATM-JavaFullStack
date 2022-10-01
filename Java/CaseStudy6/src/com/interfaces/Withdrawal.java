package com.interfaces;

import com.exep.InsufficientFundsException;
import com.exep.OverTheLimitException;
import com.main.model.Customer;

public interface Withdrawal {
	double limit=50000;
	void withdrawal(Customer customer,double amount) throws OverTheLimitException,InsufficientFundsException;
}
