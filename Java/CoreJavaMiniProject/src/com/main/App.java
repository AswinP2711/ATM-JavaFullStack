package com.main;

import java.util.List;
import java.util.Scanner;

import com.main.dto.ProductStatsDto;
import com.main.factory.ProductFactory;
import com.main.model.Product;
import com.main.service.ProductService;

public class App {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in); 
		ProductService productService=new ProductService();
		while(true) {
			System.out.println();
			System.out.println("*******MENU*********");
			System.out.println();
			System.out.println("1. Display all Products");
			System.out.println("2. Insert a Product");
			System.out.println("3. Delete a Product");
			System.out.println("4. Fetch Productd as per the Filter");
			System.out.println("5. Product Statistics-Group By");
			System.out.println("0. Exit");
			System.out.println();
			int input=sc.nextInt();
			if(input==0) {
				System.out.println("Exiting!!!");
				break;
			}
			
			switch (input) {
			case 1:
				ProductFactory.getAllProducts();
				break;
			case 2:
				System.out.println("Enter Product details");
				System.out.println("Enter Product title : ");
				sc.nextLine();
				String title=sc.nextLine();
				System.out.println("Enter product price : ");
				double price=sc.nextDouble();
				System.out.println("Enter vendor : ");
				sc.nextLine();
				String vendor=sc.nextLine();
				Product p=new Product(title, price, vendor);
				productService.inesertProduct(p);
				System.out.println("Product record added to db..");
				break;
			case 3:
				ProductFactory.getAllProducts();
				System.out.println("Enter Product ID to delete: ");
				int id=sc.nextInt();
				boolean isValid=productService.validateId(id);
				if(isValid==true) {
					productService.deleteProductById(id);
					System.out.println("Product Record deleted from the DB..");
				}else {
					System.out.println("Invalid ID, Please try again");
				}
				break;
			case 4:
				System.out.println("Enter the vendor to filter the products : ");
				sc.nextLine();
				String ven=sc.nextLine();
				productService.filterByProduct(ven);
				break;
			case 5:
				System.out.println("***Product Statistics***");
				List<ProductStatsDto> list=productService.fetchStats();
				list.parallelStream().forEach(pro->System.out.println(pro));
				break;
				
			default:
				break;
			}
		}
		sc.close();

	}

}
