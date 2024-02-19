package com.dailypractice.ProductService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailypractice.ProductService.entity.Product;
import com.dailypractice.ProductService.exception.ProductServiceCustomException;
import com.dailypractice.ProductService.model.ProductRequest;
import com.dailypractice.ProductService.model.ProductResponse;
import com.dailypractice.ProductService.repository.ProductRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepo;

	@Override
	public long addProduct(ProductRequest productReq) {
		log.info("Adding Product...");
		Product product = Product.builder().productName(productReq.getProductName()).quantity(productReq.getQuantity())
				.price(productReq.getPrice()).build();
		productRepo.save(product);
		log.info("Product Created...");
		return product.getProductId();
	}

	@Override
	public ProductResponse getProductById(Long productId) {
		log.info("Get Product by productID{}" + productId);
		Product product = productRepo.findById(productId).orElseThrow(
				() -> new ProductServiceCustomException("Product with Given id not Found", "PRODUCT_NOT_FOUND"));
		ProductResponse response = ProductResponse.builder().productId(product.getProductId())
				.productName(product.getProductName()).price(product.getPrice()).quantity(product.getQuantity())
				.build();
		return response;
	}

	@Override
	public void reduceQuantity(long productId, long quantity) {

		log.info("Reduce Quantity{} for Id{}", quantity, productId);
		Product product = productRepo.findById(productId).orElseThrow(
				() -> new ProductServiceCustomException("PRODUCT with Give Id is Not Found", "PRODUCT_NOT_FOUND"));
		if (product.getQuantity() < quantity) {
			throw new ProductServiceCustomException("PRODUCT doesn't have sufficient Quantity",
					"INSUFFICIENT_QUANTITY");
		}
		product.setQuantity(product.getQuantity() - quantity);
		productRepo.save(product);
		log.info("Product Quantity updated Successfully...");

	}

}
