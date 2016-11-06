package com.system.serviceimpt.test;

import java.util.ArrayList;
import java.util.List;

import com.system.domain.Product;
import com.system.service.ProductManager;
import com.system.serviceimpl.SimpleProductManagerBO;

import junit.framework.TestCase;

public class SimpleProductManagerTest extends TestCase{
	
	private SimpleProductManagerBO productManager;
	private List<Product> products;
	
	private static int PRODUCT_COUNT = 2;
	private static Double CHAIR_PRICE = new Double(20.50);
	private static String CHAIR_DESCRIPTION = "Chair desc";
	private static Double TABLE_PRICE = new Double(150.10);
	private static String TABLE_DESCRIPTION = "Table desc";
	
	protected void setUp() throws Exception{
		productManager = new SimpleProductManagerBO();
		products = new ArrayList<Product>();
		//stub up a list of products
		Product product = new Product();
		product.setDescription(CHAIR_DESCRIPTION);
		product.setPrice(CHAIR_PRICE);
		products.add(product);
		
		Product product2 = new Product();
		product2.setDescription(TABLE_DESCRIPTION);
		product2.setPrice(TABLE_PRICE);
		products.add(product2);
		
		productManager.setProducts(products);
	}
	
	public void testGetProducts(){
		List<Product> products = productManager.getProducts();
		assertNotNull(products);
	}
	
	public void testGetProductsWithNoProducts(){
	    SimpleProductManagerBO spm = new SimpleProductManagerBO();
		assertNull(spm.getProducts());
		assertEquals(PRODUCT_COUNT, productManager.getProducts().size());
		
		Product product = productManager.getProducts().get(0);
		assertEquals(CHAIR_DESCRIPTION, product.getDescription());
		assertEquals(CHAIR_PRICE, product.getPrice());
		
		Product product1 = productManager.getProducts().get(1);
		assertEquals(TABLE_DESCRIPTION, product1.getDescription());
		assertEquals(TABLE_PRICE, product1.getPrice());
	}
}
