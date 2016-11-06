package com.system.controller.test;

import java.util.Map;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import com.system.controller.InventoryController;
import com.system.serviceimpl.SimpleProductManagerBO;

import junit.framework.TestCase;

public class InventoryControllerTest extends TestCase{
/**
 * This test was created to check
 * the String return	
 */
//	public void testHandleRequestView() throws Exception{
//		HelloController helloController = new HelloController();
//		String model = helloController.printHello(new ModelMap());
//		assertNotNull(model);
//		assertEquals("hello", model);
//	}

	public void testHandleRequest() throws Exception{
		InventoryController inventoryController = new InventoryController();
		
		inventoryController.setProductManager(new SimpleProductManagerBO());
		
		ModelAndView modelAndView = inventoryController.requestHandler(new ModelMap());
		
		assertEquals("hello", modelAndView.getViewName());
		assertNotNull(modelAndView.getModel());
		
		Map modelMap = (Map) modelAndView.getModel().get("model");
		
		String nowValue = modelMap.get("now").toString();;
		assertNotNull(nowValue);
		 
	}

}
