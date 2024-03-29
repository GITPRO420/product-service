package com.dailypractice.ProductService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ProductResponse {

	private long productId;
	private String productName;
	private long price;
	private long quantity;

}
