package com.ttj.usermgmt.rest;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ttj.usermgmt.dto.ProductDto;
import com.ttj.usermgmt.entity.Product;
import com.ttj.usermgmt.service.ProductService;


@RestController
@RequestMapping("/product")
@RefreshScope
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@GetMapping("/getAll")
	public List<Product> getAllProduct(){
		
		return productService.getAll();
	}
	
	@PostMapping("/new")
	public ResponseEntity<?> productNew (@RequestBody ProductDto productDto){
		
		productService.newProduct(productDto);
		return new ResponseEntity<>(productDto, HttpStatus.CREATED);
	}
	
	@GetMapping("/del/{id}")
	public void deleteProd(@PathVariable("id") BigInteger id) {
		productService.deleteProduct(id);
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody ProductDto productDto) {
		productService.newProduct(productDto);
		return new ResponseEntity<>(productDto, HttpStatus.CREATED);
	}
}
