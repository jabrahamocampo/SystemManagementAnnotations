package com.system.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import com.system.domain.PriceIncrease;
import com.system.service.ProductManager;

@Controller
public class PriceIncreaseFormController{
	/*Logger for this class and subclases*/
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	private ProductManager productManager;
	
	@RequestMapping(value="/increaseForm", method= RequestMethod.GET)
	public ModelAndView increaseForm(){
		
		//logger.info("***INCREASEFORM METHOD *** " + getClass().getName()+"----"+increaseForm().getViewName()+"---"+increaseForm().getClass() );
		
		return new ModelAndView("/priceincrease","command", new PriceIncrease());
	}
	
	@RequestMapping(value = "/priceIncreaseFormController", method=RequestMethod.POST)
	public ModelAndView onSubmit(@ModelAttribute("priceIncrease")PriceIncrease priceIncrease, ModelMap model)
			throws ServletException{
		
		int increase = priceIncrease.getPercentage();
		//int increase = ((PriceIncrease)command).getPercentage();
		logger.info("Increasing prices by "+ increase + "%");
		
		productManager.increasePrice(increase);
		
		logger.info("returning from PriceIncreaseForm view to: hello");
		
		model.addAttribute("test", "testing");
		model.addAttribute("increase", priceIncrease.getPercentage());
		
		return new ModelAndView(new RedirectView("hello"));
	}
	
//	protected Object formBackingObject(HttpServletRequest request){
//		PriceIncrease priceIncrease = new PriceIncrease();
//		priceIncrease.setPercentage(20);
//		return priceIncrease;
//	}
	
	public void setProductManager(ProductManager productManager){
		this.productManager = productManager;
	}
	
	public ProductManager getProductManager(){
		return this.productManager;
	}
}
