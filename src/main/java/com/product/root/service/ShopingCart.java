package com.product.root.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.root.exception.GeneralException;
import com.product.root.model.Customer;
import com.product.root.model.Order;
import com.product.root.repository.ProductRepository;

@Service
public class ShopingCart {
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	EntityManager entityManager;
	
	public Customer login(String email, String password) {
		Query q=entityManager.createQuery("select c from Customer c where c.customerEmail=:e and c.customerPassword=:p");
		q.setParameter("e", email);
		q.setParameter("p", password);
		return (Customer) q.getSingleResult();
	}

	public Order getorderById(long orderId) {
		return entityManager.find(Order.class,orderId);
	}

	public List<Order> ordersForThisCustomer(long customerId) {
		Query q=entityManager.createQuery("select o from Order o where o.customer.customerId=:cid");
		q.setParameter("cid", customerId);
		return q.getResultList();
	}

	@Transactional
	public void updateAOrder(Order order) {
		Order od=entityManager.find(Order.class, order.getOrderID());
		od.setProducts(order.getProducts());
		entityManager.merge(od);
	}

	@Transactional
	public Order createAOrder(Order order) throws GeneralException {
		Order od=entityManager.merge(order);
		return od;
	}
	
	@Transactional
	public void createCustomer(Customer customer) throws GeneralException {
		try {
		entityManager.merge(customer);
		}catch (Exception e) {
			throw new GeneralException("unable to create a customer try again");
		}
	}

	public Customer getCustomerById(long id) {
		return entityManager.find(Customer.class,id );
	}

}
