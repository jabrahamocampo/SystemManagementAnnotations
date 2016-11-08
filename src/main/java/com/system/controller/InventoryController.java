package com.system.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.system.domain.Product;
import com.system.service.ProductManager;
import com.system.serviceimpl.SimpleProductManagerBO;

import org.springframework.ui.ModelMap;


@Controller
@RequestMapping("/hello")
public class InventoryController {
	
	@Autowired
	private ProductManager productManager;
	
	//In the example uses ProductManager Interface for @Autowired
	//but also works with the implementation 
	//private SimpleProductManager productManager;
	
	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView requestHandler(HttpServletRequest request, HttpServletResponse response, ModelMap model){
		
		logger.info(model.getClass().getName() + "*****PASA******");
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(request.getParameter("test")!=null && request.getParameter("increase")!=null){
			model.addAttribute("test", request.getParameter("test"));
			model.addAttribute("increase", request.getParameter("increase"));
			map.put("requestParam", model);
			
			map.put("test", request.getParameter("test"));
			map.put("increase", request.getParameter("increase"));
		}
		
		String now = (new Date()).toString();
		map.put("now", now);
		
		List<Product> products = this.productManager.getProducts();
		map.put("products", products);
		
		return new ModelAndView("hello", "model", map);	
	}

	
	public void setProductManager(ProductManager productManager) {
		this.productManager = productManager;
	}
	
	
	
/**
 * This method was created to check
 * the String return as a view
 * and we can set values in a Map
 */
	
//	@RequestMapping(method = RequestMethod.GET)
//	public String printHello(ModelMap model){
//		
//		logger.info(model.getClass().getName()+"*****PASA******");
//		
//		String now = (new Date()).toString();
//		
////		Map<String,Object> map = new HashMap<String,Object>();
////		
////		map.put("now", now);
////		map.put("message", "Welcome!");
//		
//		model.addAttribute("now", now);
//		model.addAttribute("message", "Welcome!");
//		
//		return "hello";
//	}
}
