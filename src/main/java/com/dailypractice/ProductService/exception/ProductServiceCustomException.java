
package com.dailypractice.ProductService.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ProductServiceCustomException extends RuntimeException {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	private String errorCode;

	public ProductServiceCustomException(String message, String errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

}
