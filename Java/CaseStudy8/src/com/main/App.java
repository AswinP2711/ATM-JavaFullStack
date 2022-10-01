package com.main;

import java.util.Scanner;

import com.main.factory.ProductFactory;
import com.main.model.Product;
import com.main.service.ProductService;

public class App {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		ProductService productService = new ProductService();
		
		
		while(true) {
			System.out.println();
			System.out.println("*******MENU*********");
			System.out.println();
			System.out.println("1. Insert a Product");
			System.out.println("2. Display all Products");
			System.out.println("3. Delete a Product");
			System.out.println("0. Exit");
			System.out.println();
			int input=sc.nextInt();
			if(input==0) {
				System.out.println("Exiting!!!");
				break;
			}
			
			switch (input) {
			case 1:
				System.out.println("Enter Product details");
				System.out.println("Enter Name");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.println("Enter Price");
				double price = sc.nextDouble();
				System.out.println("Enter Descrition");
				String description = sc.next();
				Product p=new Product(name, price, description);
				productService.insertProduct(p);
				System.out.println("Product record added to db..");
				break;
				
			case 2:
				ProductFactory.getAllProduct();
				break;
			case 3:
				ProductFactory.getAllProduct();
				System.out.println("Enter Product ID to delete: ");
				int id=sc.nextInt();
				boolean isValid=productService.validateId(id);
				if(isValid == true) {
					productService.deleteProduct(id);
					System.out.println("Product Record deleted from the DB..");
				}else {
					System.out.println("Invalid ID, Please try again");
				}
				break;

			default:
				break;
			}
		}
		sc.close();

	}

}
