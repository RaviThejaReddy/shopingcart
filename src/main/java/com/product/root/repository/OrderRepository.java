package com.product.root.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.root.model.Order;

@Repository
public interface OrderRepository{

	public String updateAOrder(Order order);
	
	public String createAOrder(Order order);
}
