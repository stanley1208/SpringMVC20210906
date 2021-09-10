package com.mvc.controller;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/hi")
public class Hi {
	@RequestMapping(value = "/{welcome}",method = { RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public String greet(@PathVariable("welcome") String welcome,
						@RequestParam("name") String name) {
		try {
			welcome=new String(welcome.getBytes("ISO-8859-1"), "UTF-8");

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return welcome+" "+name+"!";
	}
}
