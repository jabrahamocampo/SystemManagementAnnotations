package com.system.domain;

import java.io.Serializable;

public class Product implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String description;
	private Double price;
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public String toString(){
		StringBuffer st = new StringBuffer();
		st.append("Description: "+this.description + "; ");
		st.append("Price: "+this.price +";");
		return st.toString();
	}
}
