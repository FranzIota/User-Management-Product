package com.ttj.usermgmt.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.ttj.usermgmt.dto.ProductDto;
import com.ttj.usermgmt.entity.Product;
import com.ttj.usermgmt.repo.ProductRepo;



@Service
public class ProductService {

	@Autowired
	private ProductRepo productRepo;
	
	public List<Product> getAll() {
		return productRepo.findAll();
	}
	
	public Product newProduct(ProductDto productDto) {
		
		Product newProd = new Product();
		newProd.setId(productDto.getId());
		newProd.setName(productDto.getName());
		newProd.setPrice(productDto.getPrice());
		
		return productRepo.save(newProd);
	}
	
	public void deleteProduct(@PathVariable("id") BigInteger id) {
		productRepo.deleteById(id);
	}
	
}
