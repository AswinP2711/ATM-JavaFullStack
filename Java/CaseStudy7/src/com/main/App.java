package com.main;
import java.util.HashMap;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		HashMap<String,String> map=new HashMap<>();
		map.put("aswin", "aswin123");
		map.put("aiswarya", "aiswarya123");
		map.put("manu", "manu123");
		map.put("kailas", "kailas123");
		map.put("amal", "amal123");
		
		System.out.println("Enter Username : ");
		String uname=sc.next();
		System.out.println("Enter Password : ");
		String pword=sc.next();

		
		boolean isUsername=false;
		
		isUsername = map.containsKey(uname);
		if (isUsername == true) {
			String password=map.get(uname);
			if(pword.equals(password)) {
				System.out.println("Login success, Valid user");
			}else {
				System.out.println("Incorrect Password");
			}
		}else {
			System.out.println("User Does not exists!!!");
		}
		sc.close();
		
		
	}

}
