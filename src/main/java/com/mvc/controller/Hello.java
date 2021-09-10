package com.mvc.controller;

import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PathVariable;
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
	 * 路徑:/sayhi?name=stanley&age=18
	 * 帶入:name與age兩個參數
	 * */
	@RequestMapping(value = "/sayhi")
	@ResponseBody
	public String sayHi(@RequestParam(value = "name",defaultValue = "unknown",required =false ) String name,
			@RequestParam("age") Integer age) {
		
		return "Hello "+name+", "+age;
	}
	
	/*
	 * Lab:
	 * 路徑:/bmi?h=170&w=60
	 * 帶入:h與w兩個參數
	 * 結果:bmi=20.76
	 * */
	
	@RequestMapping(value = "/bmi")
	@ResponseBody
	public String BMI(@RequestParam("h") Double h,
			@RequestParam("w") Double w) {
		double bmi=w/(Math.pow(h/100, 2));
		return String.format("bmi=%.2f", bmi);
	}
	
	/*
	 * PathVariable
	 * 路徑:/exam/75 ->結果:pass
	 * 路徑:/exam/45 ->結果:fail
	 * 
	 * */
	@RequestMapping(value = "/exam/{score}")
	@ResponseBody
	public String exam(@PathVariable("score") Integer score) {
		return score+" "+((score>=60)?"Pass":"Fail");
	}
	
	/*
	 * Lab:PathVariable+RequestParam
	 * 路徑:/calc/add?x=30&y=20 ->結果:50
	 * 路徑:/calc/sub?x=30&y=20 ->結果:fail
	 * 
	 * */
	@RequestMapping(value = "/calc/{exp}")
	@ResponseBody
	public String calc(@PathVariable("exp") String exp,
			           @RequestParam(value = "x", required = false) Optional<Integer> x,
			           @RequestParam(value = "y", required = false) Optional<Integer> y) {
		if(x.isPresent() && y.isPresent()) {
			switch (exp) {
				case "add":
					return x.get() + y.get() + "";
				case "sub":
					return x.get() - y.get() + "";
				default:
					return "None";
			}
		}
		if(x.isPresent()) {
			return x.get() + "";
		}
		if(y.isPresent()) {
			return y.get() + "";
		}
		return "0";
	}
	
	/*
	 * 常見的PathVariable萬用字元*任意多字,?任意一字
	 * 
	 * */
	@RequestMapping(value = "/any/*/java?")
	@ResponseBody
	public String any() {
		return "Any";
	}
	/*
	 * 得到多筆資料
	 * 路徑:/age?a=18&a=19&a=20
	 * 結果:age of average=19
	 * */
	@RequestMapping("/age")
	@ResponseBody
	public String age(@RequestParam("a") List<Integer>ageList) {
		double avg=ageList.stream().mapToInt(age->age).average().getAsDouble();
		return String.format("%s , age of average=%d", ageList,(int)avg);
		
	}
	
}

