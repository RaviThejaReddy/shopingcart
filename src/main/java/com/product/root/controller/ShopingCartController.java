package com.product.root.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.root.exception.GeneralException;
import com.product.root.model.Customer;
import com.product.root.model.Order;
import com.product.root.service.ShopingCart;

@RestController
@CrossOrigin
@RequestMapping("/shopingCart")
public class ShopingCartController {

	@Autowired
	ShopingCart shopingCart;

	@PutMapping("/order")
	public String updateAOrder(@RequestBody Order order) {
		shopingCart.updateAOrder(order);
		return "updated";
	}

	@PostMapping("/order")
	String createAOrder(@RequestBody Order order) throws GeneralException {
		shopingCart.createAOrder(order);
		return "order Created";
	}

	@GetMapping("/{email}/{passowrd}")
	Customer login(@PathVariable("email") String email, @PathVariable("passowrd") String password) {
		return shopingCart.login(email, password);
	}

	@GetMapping("/order/{id}")
	Order getorderById(@PathVariable("id") long orderId) {
		return shopingCart.getorderById(orderId);
	}

	@GetMapping("/customer/order/{id}")
	List<Order> ordersForThisCustomer(@PathVariable("id") long customerId) {
		return shopingCart.ordersForThisCustomer(customerId);
	}

	@PostMapping("/customer")
	public void createCustomer(@RequestBody Customer customer) throws GeneralException {
		shopingCart.createCustomer(customer);
	}

	@GetMapping("/customer/{id}")
	public Customer getACustomer(@PathVariable("id") long id) {
		return shopingCart.getCustomerById(id);
	}
}
