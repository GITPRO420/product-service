package com.dailypractice.ProductService.service;

import com.dailypractice.ProductService.model.ProductRequest;
import com.dailypractice.ProductService.model.ProductResponse;

public interface ProductService {

	long addProduct(ProductRequest productReq);

	ProductResponse getProductById(Long productId);

	void reduceQuantity(long productId, long quantity);

}
