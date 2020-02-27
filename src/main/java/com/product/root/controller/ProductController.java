package com.product.root.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.root.exception.GeneralException;
import com.product.root.model.Product;
import com.product.root.service.ProductService;

@RestController
@CrossOrigin
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@PostMapping
	public Product createAProduct(@RequestBody Product product) throws GeneralException {
		try {
		return productService.createAProduct(product);
		}catch (Exception e) {
			throw new GeneralException("COULDN'T CREATE A PRODUCT");
		}
	}
	
	@GetMapping
	public List<Product> getAllProducts() throws GeneralException{
		try {
		return productService.getAllProducts();
		}catch (Exception e) {
			throw new GeneralException("couldnt get the list of products",e);
		}
	}
	
	@DeleteMapping("/{id}")
	  public String deleteProduct(@PathVariable("id") long id) throws GeneralException {
		try {
		return productService.deleteProduct(id);
		}catch (Exception e) {
			throw new GeneralException("COULDN'T DELETE A PRODUCT",e);
		}
	}

	@PutMapping()
	  public String updateProduct(@RequestBody Product product) throws GeneralException {
		try {
		return productService.updateProduct(product);
		}catch (Exception e) {
			throw new GeneralException("unable to find the product or update the product");
		}
	}
	
	@GetMapping("/{id}")
	 public Optional<Product> getAProduct(@PathVariable long id) {
		  return productService.getAProduct(id);
	  }
}
