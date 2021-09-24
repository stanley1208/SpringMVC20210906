package com.mvc.controller;

import javax.enterprise.inject.New;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.entity.products.Product;

@Controller
@RequestMapping(value = "/product")
public class ProductController {
	
	
	
	@RequestMapping(value = {"/","/input"})
	public String index(Model model) {
		model.addAttribute("product",new Product());
		model.addAttribute("action", "save");
		
		
		return "product";
	}
	
}
