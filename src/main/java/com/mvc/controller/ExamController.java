package com.mvc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.entity.Exam;

@Controller
@RequestMapping("/exam")
public class ExamController {
	
	private static List<Exam>exams=new CopyOnWriteArrayList<>();
	
	@RequestMapping(value = {"/", "/index"})
	public String index(Model model) {
		Exam e = new Exam();
		model.addAttribute("exam", e);//給表單使用
		model.addAttribute("exams", exams);//給資料呈現使用
		return "exam";
	}
	
	//CRUD create,read,update,delete
	@RequestMapping(value = "/create")
	public String create(Exam exam) {
		exams.add(exam);//新增
		System.out.println(exams);
		return "redirect:/mvc/exam/";//重導到首頁
	}
}
