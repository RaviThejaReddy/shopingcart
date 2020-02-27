package com.product.root.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.root.model.Product;
import com.product.root.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	public Product createAProduct(Product product) {
		Product _product=productRepository.save(new Product(product.getProductName(),product.getProductPrice(),product.getProductQuantity()));
		return _product;
	}
	
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
	  public String deleteProduct(long id) {
	    productRepository.deleteById(id); 
	    return "Product has been deleted!";
	}

	  public String updateProduct(Product product) {	 
	    Optional<Product> productData = productRepository.findById(product.getProductId());
	 
	    if (productData.isPresent()) {
	      Product _product = productData.get();
	      _product.setProductName(product.getProductName());
	      _product.setProductPrice(product.getProductPrice());
	      _product.setProductQuantity(product.getProductQuantity());
	      return productRepository.save(_product).toString();
	    } else {
	      return "productNotFound";
	    }
	  } 
	  public Optional<Product> getAProduct(long id) {
		  return productRepository.findById(id);
	  }
	  
	  

}
