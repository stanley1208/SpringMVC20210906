package com.mvc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.enterprise.inject.New;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
		model.addAttribute("action", "create");
		return "exam";
	}
	
	//CRUD create,read,update,delete
	@RequestMapping(value = "/create")
	public String create(Exam exam) {
		exams.add(exam);//新增
		System.out.println(exams);
		return "redirect:/mvc/exam/";//重導到首頁
	}
	
	@RequestMapping(value = "/get/{id}")
	public String get(@PathVariable("id") String id,Model model) {
		Optional<Exam>optExam=exams.stream()
							.filter(e->e.getId().equals(id))
							.findFirst();
		model.addAttribute("exam", optExam.isPresent()?optExam.get():new Exam());//給表單使用
		model.addAttribute("exams", exams);//給資料呈現使用
		model.addAttribute("action","update");
		
		return "exam";
	}
	
	@RequestMapping(value = "/update")
	public String update(Exam exam) {
		Optional<Exam> optExam = exams.stream()
				.filter(e -> e.getId().equals(exam.getId()))
				.findFirst();
		if(optExam.isPresent()) {
			// oExam 原本的資料
			// 表單傳來 exam 要修改的資料
			Exam oExam = optExam.get();
			oExam.setName(exam.getName());
			oExam.setSlot(exam.getSlot());
			oExam.setPay(exam.getPay());
			oExam.setNote(exam.getNote());
		}
		
		return "redirect:/mvc/exam/"; // 重導到首頁
	}
}
