package com.interfaces;

import com.main.model.Customer;

public interface Withdrawal {
	double limit=50000;
	void withdrawal(Customer customer,double amount);
}
