package com.myspringmvcproject.controller;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myspringmvcproject.model.Employee;
import com.myspringmvcproject.model.Product;
import com.myspringmvcproject.service.EmployeeService;
import com.myspringmvcproject.service.ProductService;

@Controller
public class MainController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping("/")
	public String showHome(Model model) {//Dependency Injection(DI)
		model.addAttribute("dateVal",LocalDate.now());
		return "home";
	}
	@RequestMapping("/products")
	public String showProducts(HttpServletRequest request) {
		List<Product> list=productService.getAllProducts();
		request.setAttribute("productList", list);
		return "products";
	}
	@RequestMapping("/contact")
	public ModelAndView showContact(ModelAndView mav) {
		mav.addObject("dateVal",LocalDate.now());
		mav.setViewName("contact");
		return mav;
	}
	@RequestMapping("/about")
	public String showAbout() {
		return "about";
	}
	
	@RequestMapping("/show-add-product")
	public String showProductForm() {
		return "add-product";
	}
	
	@RequestMapping("/add-product")
	public String addProduct(@RequestParam("title") String title,
			@RequestParam("price") Double price,
			@RequestParam("vendor") String vendor,
			Product product) {
		product.setTitle(title);
		product.setPrice(price);
		product.setVendor(vendor);
		
		productService.insertProduct(product);
		return "redirect:/products";
	}
	
	@RequestMapping("/employees")
	public String showEmployee(HttpServletRequest request) {
		List<Employee> list = employeeService.getAllEmployees();
		System.out.println(list);
		request.setAttribute("employeeList", list);
		return "employees";
	}
	
	@RequestMapping("/show-add-employee")
	public String showEmployeeForm() {
		return "add-employee";
	}
	
	@RequestMapping("/add-employee")
	public String addEmployee(@RequestParam("name") String name,
			@RequestParam("salary") String salary,
			@RequestParam("branch")String branch,
			Employee employee) {
		employeeService.insertEmployee(employee);
		return "redirect:/employees";
	}
}
