package com.dailypractice.ProductService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dailypractice.ProductService.model.ProductRequest;
import com.dailypractice.ProductService.model.ProductResponse;
import com.dailypractice.ProductService.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping()
	public ResponseEntity<Long> addProduct(@RequestBody ProductRequest productReq){
		
		long productId=productService.addProduct(productReq);
		return new ResponseEntity<>(productId,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductResponse> getProductById(@PathVariable("id") Long productId){
		ProductResponse proResponse=productService.getProductById(productId);
		return new ResponseEntity<>(proResponse,HttpStatus.OK);
	}
	
	@PutMapping("/reducequantity/{id}")
	public ResponseEntity<Void> reduceQuantity(@PathVariable("id") long productId,
									@RequestParam long quantity)
	{
		productService.reduceQuantity(productId,quantity);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
