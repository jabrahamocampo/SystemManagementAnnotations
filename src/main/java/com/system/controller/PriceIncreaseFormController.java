package com.system.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import com.system.domain.PriceIncrease;
import com.system.service.ProductManager;

public class PriceIncreaseFormController extends SimpleFormController{
	/*Logger for this class and subclases*/
	protected final Log logger = LogFactory.getLog(getClass());
	
	private ProductManager productManager;
	
	public ModelAndView onSubmit(Object command) throws ServletException{
		
		int increase = ((PriceIncrease)command).getPercentage();
		logger.info("Increasing prices by "+ increase + "%");
		
		productManager.increasePrice(increase);
		
		logger.info("returning from PriceIncreaseForm view to: " + getSuccessView());
		
		return new ModelAndView(new RedirectView(getSuccessView()));
	}
	
	protected Object formBackingObject(HttpServletRequest request){
		PriceIncrease priceIncrease = new PriceIncrease();
		priceIncrease.setPercentage(20);
		return priceIncrease;
	}
	
	public void setProductManager(ProductManager productManager){
		this.productManager = productManager;
	}
	
	public ProductManager getProductManager(){
		return this.productManager;
	}
}
