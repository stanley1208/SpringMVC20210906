package com.mvc.controller;

import java.util.Date;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/hello")
public class Hello {
	
	@RequestMapping(value = "/greet")
	@ResponseBody
	public String greet() {
		return "Hello SpringMVC";
	}
	
	@RequestMapping(value = "/time")
	@ResponseBody
	public String time() {
		return new Date().toString();
	}
	
	/*
	 * ���|:/sayhi?name=stanley&age=18
	 * �a�J:name�Page��ӰѼ�
	 * */
	@RequestMapping(value = "/sayhi")
	@ResponseBody
	public String sayHi(@RequestParam("name") String name,
			@RequestParam("age") Integer age) {
		
		return "Hello "+name+", "+age;
	}
}
