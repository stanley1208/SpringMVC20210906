package com.mvc.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mvc.entity.Exam;

@Component
public class ExamValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		//判定當前clazz是不是Exam的類別
		return Exam.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Exam exam=(Exam)target;
		//判定id不可以是null或空的
		if(exam.getId()==null || exam.getId().trim().length()==0)
			//field,errorCode,defaultMessage
			//field:要驗證的物件變數
			//errorCode:錯誤名稱(通常是指 errorMessage.properties所設定的名稱)
			//defaultMessage:預設的錯誤訊息
			errors.rejectValue("id", null, "id 不可空白");
	
	}
	
}
