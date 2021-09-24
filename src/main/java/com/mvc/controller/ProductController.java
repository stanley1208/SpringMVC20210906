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
	//�Y�n�ϥ� JSR 303 ���ҫh�n�b���Ҹ�Ƽҫ��e���[�W@Valid�׹�
	public String save(@Valid Product product,BindingResult result,Model model) {
		if(result.hasErrors()) {//�O�_�����~�o��?
			model.addAttribute("action", "save");
			
			return "product";//�N���~��T�a�����wjsp����
		}
		productService.save(product);
		return "redirect:/mvc/product/";
	}
}
