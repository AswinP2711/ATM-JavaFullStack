package com.main;

import com.main.model.Customer;
import com.service.DepositService;
import com.service.WithdrawalService;

public class App {

	public static void main(String[] args) {
		Customer c1=new Customer(1, "Aswin", 25000);
		Customer c2=new Customer(2, "Amal", 15000);
		System.out.println("Before Deposit Customer 1");
		System.out.println(c1);
		System.out.println();
		System.out.println("Before Withdrawal Customer 2");
		System.out.println(c2);
		System.out.println();
		
		
		DepositService d1=new DepositService();
		d1.deposit(c1, 300);
		System.out.println("After Deposit Customer 1");
		System.out.println(c1);
		System.out.println();
		
		WithdrawalService w1=new WithdrawalService();
		w1.withdrawal(c2, 1500);
		System.out.println("After Withdrawal Customer 2");
		System.out.println(c2);
		
		
	}

}
