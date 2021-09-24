package com.mvc.controller;

import javax.enterprise.inject.New;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mvc.entity.products.Product;
import com.mvc.service.ProductService;

@Controller
@RequestMapping(value = "/product")
@SessionAttributes(value = {"groups","products"})
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = {"/","/input"})
	public String index(Model model) {
		model.addAttribute("product",new Product());
		model.addAttribute("groups", productService.groups.values());
		model.addAttribute("products", productService.query());
		model.addAttribute("action", "save");
		
		
		return "product";
	}
	
	@PostMapping(value = "/save")
	//若要使用 JSR 303 驗證則要在驗證資料模型前面加上@Valid修飾
	public String save(@Valid Product product,BindingResult result,Model model) {
		if(result.hasErrors()) {//是否有錯誤發生?
			model.addAttribute("action", "save");
			
			return "product";//將錯誤資訊帶給指定jsp頁面
		}
		productService.save(product);
		return "redirect:/mvc/product/";
	}
}
