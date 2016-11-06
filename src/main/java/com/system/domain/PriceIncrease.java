package com.system.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PriceIncrease {
	
	/**Logger for this class and subclases*/
	protected final Log logger = LogFactory.getLog(getClass());
	
	private int percentage;
	
	public void setPercentage(int percentage){
		this.percentage = percentage;
		logger.info("Percentage set to: " + percentage);
	}
	
	public int getPercentage(){
		return this.percentage;
	}
	
}
