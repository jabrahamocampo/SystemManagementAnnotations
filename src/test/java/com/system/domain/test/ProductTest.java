package com.system.domain.test;

import com.system.domain.Product;

import junit.framework.TestCase;

public class ProductTest extends TestCase{
	
	private Product product;
	
	protected void setUp() throws Exception{
		product = new Product();
	}
	
	public void testSetAndGetDescription(){
		String description = "TestDescription";
		assertNull(this.product.getDescription());
		this.product.setDescription(description);
		assertEquals(description, this.product.getDescription());
	}
	
	public void testSetAndGetPrice(){
		Double value = 100.0;
		assertNull(this.product.getPrice());
		this.product.setPrice(value);
		assertEquals(value,this.product.getPrice());
		
	}
}
