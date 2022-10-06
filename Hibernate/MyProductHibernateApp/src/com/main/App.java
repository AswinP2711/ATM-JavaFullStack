package com.main;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.main.factory.ProductFactory;
import com.main.model.Product;
import com.main.model.Review;
import com.main.model.Vendor;

public class App {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mydb");

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("-----Product-----");
			System.out.println("1. Insert Vendor");
			System.out.println("2. Insert Product");
			System.out.println("3. Insert Review");
			System.out.println("4. Fetch products based on vendor ID");
			System.out.println("5. Show reviews based on product ID");
			System.out.println("6. Update Product");
			System.out.println("7. Delete Product");
			System.out.println("0. Exit");
			int input = sc.nextInt();
			if (input == 0) {
				System.out.println("Exiting");
				break;
			}
			entityTransaction.begin();
			Vendor v=new Vendor();
			Product p=new Product();
			Review r=new Review();
			switch (input) {
			case 1:
				System.out.println("Enter Vendor name : ");
				sc.nextLine();
				String vname = sc.nextLine();
				System.out.println("Enter city : ");
				String vcity = sc.nextLine();
				v.setName(vname);
				v.setCity(vcity);
				entityManager.persist(v);
				System.out.println("Record Inserted in DB");
				break;
			case 2:
				System.out.println("Enter product name : ");
				sc.nextLine();
				String pname=sc.nextLine();
				System.out.println("Enter price : ");
				double price=sc.nextDouble();
				p.setName(pname);
				p.setPrice(price);
				List<Vendor> listVendor=ProductFactory.getInstance().getAllVendors(entityManager);
				listVendor.parallelStream().forEach(ve->System.out.println(ve));
				System.out.println("Enter vendor ID : ");
				int vid=sc.nextInt();
				v=listVendor.parallelStream()
						.filter(ve->ve.getId()==vid)
						.collect(Collectors.toList()).get(0);
				p.setVendor(v);
				entityManager.persist(p);
				System.out.println("Record Inserted in DB");
				break;
			case 3:
				List<Product> listProduct=ProductFactory.getInstance().getAllProducts(entityManager);
				listProduct.parallelStream().forEach(pr->System.out.println(pr));
				System.out.println("Enter Product ID : ");
				int pid=sc.nextInt();
				p=listProduct.parallelStream()
						.filter(pr->pr.getId()==pid)
						.collect(Collectors.toList()).get(0);
				r.setProduct(p);
				System.out.println("Enter Rating : ");
				int rating=sc.nextInt();
				System.out.println("Enter Review : ");
				sc.nextLine();
				String review=sc.nextLine();
				r.setRating(rating);
				r.setReview_text(review);
				entityManager.persist(r);
				System.out.println("Record Inserted in DB");
				break;
			case 4:
				listVendor=ProductFactory.getInstance().getAllVendors(entityManager);
				listVendor.parallelStream().forEach(ve->System.out.println(ve));
				System.out.println("Enter vendor ID : ");
				vid=sc.nextInt();
				
				List<Product> list =ProductFactory.getInstance().getProductsByVendorId(entityManager,vid);
				list.parallelStream().forEach(prod->System.out.println(prod));
				break;
			case 5:
				listProduct=ProductFactory.getInstance().getAllProducts(entityManager);
				listProduct.parallelStream().forEach(pr->System.out.println(pr));
				System.out.println("Enter Product ID : ");
				pid=sc.nextInt();
				
				List<Review> rlist =ProductFactory.getInstance().getReviewsByProductId(entityManager,pid);
				rlist.parallelStream().forEach(rev->System.out.println(rev));
				break;
			case 6:
				listProduct=ProductFactory.getInstance().getAllProducts(entityManager);
				listProduct.parallelStream().forEach(pr->System.out.println(pr));
				System.out.println("Enter product ID to update");
				pid=sc.nextInt();
				p=entityManager.find(Product.class, pid);
				if (p==null) {
					System.out.println("ID invalid");
					break;
				}
				System.out.println("Enter product name : ");
				sc.nextLine();
				pname=sc.nextLine();
				System.out.println("Enter price : ");
				price=sc.nextDouble();
				p.setName(pname);
				p.setPrice(price);
				listVendor=ProductFactory.getInstance().getAllVendors(entityManager);
				listVendor.parallelStream().forEach(ve->System.out.println(ve));
				System.out.println("Enter vendor ID : ");
				vid=sc.nextInt();
				v=listVendor.parallelStream()
						.filter(ve->ve.getId()==vid)
						.collect(Collectors.toList()).get(0);
				p.setVendor(v);
				entityManager.persist(p);
				break;
			case 7:
				listProduct=ProductFactory.getInstance().getAllProducts(entityManager);
				listProduct.parallelStream().forEach(pr->System.out.println(pr));
				System.out.println("Enter Product ID to delete : ");
				pid=sc.nextInt();
				p = entityManager.find(Product.class,pid);
				if (p==null) {
					System.out.println("ID invalid");
					break;
				}
				rlist =ProductFactory.getInstance().getReviewsByProductId(entityManager,pid);
				if(rlist.size()==0) {
					entityManager.remove(p);
					System.out.println("Product Deleted");
				}else {
					for (int i = 0; i < rlist.size(); i++) {
						entityManager.remove(rlist.get(i));
					}
					entityManager.remove(p);
					System.out.println("Product Deleted");
				}
				break;
			default:
				break;
			}// End switch
			entityTransaction.commit();
		} // End While
		sc.close();
	}// End Main
}
