package com.system.serviceimpl;

import java.util.List;

import com.system.domain.Product;
import com.system.service.ProductManager;

public class SimpleProductManagerBO implements ProductManager{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Product> products;
	
	public void increasePrice(int percentage) {
		if(products != null){
			for(Product product : products){
				Double newPrice = product.getPrice().doubleValue() * (100 + percentage)/100;
				product.setPrice(newPrice);
			}
		}
		
	}

	public List<Product> getProducts() {
		return products;	
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
