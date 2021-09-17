package com.mvc.validator;

import org.apache.jasper.tagplugins.jstl.core.If;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mvc.entity.Exam;

@Component
public class ExamValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		//�P�w��eclazz�O���OExam�����O
		return Exam.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Exam exam=(Exam)target;
		//�P�wid���i�H�Onull�ΪŪ�
		if(exam.getId()==null || exam.getId().trim().length()==0)
			//field,errorCode,defaultMessage
			//field:�n���Ҫ������ܼ�
			//errorCode:���~�W��(�q�`�O�� errorMessage.properties�ҳ]�w���W��)
			//defaultMessage:�w�]�����~�T��
			errors.rejectValue("id", "exam.id.requird", "�п�J�ǭ��s��");

	
	if(exam.getName()==null || exam.getName().trim().length()==0) {
		errors.rejectValue("name", "exam.name.requird", "�п�ܦҸեN��");
	}
	if(exam.getSlot()==null || exam.getSlot().length==0) {
		errors.rejectValue("slot", "exam.slot.requird", "�п�ܦҸծɬq");
	}
	if(exam.getPay()==null || exam.getPay().trim().length()==0) {
		errors.rejectValue("pay", "exam.pay.requird", "�п��ú�O���p");
	}
	
}
}
