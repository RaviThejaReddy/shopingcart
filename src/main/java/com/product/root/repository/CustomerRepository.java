package com.product.root.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.product.root.model.Customer;
import com.product.root.model.Order;

@Repository
public interface CustomerRepository{


	Customer login(String email,String password);
	
	Order getorderById(long orderId);
	
	List<Order> ordersForThisCustomer(long customerId);
	
	void createCustomer(Customer customer);
	
}
