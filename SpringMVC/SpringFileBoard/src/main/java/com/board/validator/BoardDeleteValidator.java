package com.board.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.board.domain.BoardCommand;

//스프링에서 유효성검사를 할려면 반드시 Validator인터페이스를 상속을 받아야 된다.
public class BoardDeleteValidator implements Validator { //MemberValidator

	//1.유효성감사를 할 클래스명을 지정해주는 메서드
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		//형식) return DTO클래스명.class.isAssignableFrom(clazz)
		return BoardCommand.class.isAssignableFrom(clazz);
		//return MemberCommand.class.isAssignableFrom(clazz);
	}

	//2.유효성검사를 해주는 메서드->실질적으로 테이블에 저장되기전에 검사
	//1.target(데이터 적용대상자(DTO객체),2.error(검사할때 발생된 에러메세지 정보를 저장할 에러객체)
	//입력하지 않았거나 공백을 체크해주는 메서드->에러정보를 저장
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		//1.에러객체명 2.에러메세지가 적용시킬 필드명 3.적용시킬 에러코드명(=키명)
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"pwd","required");//requried.pwd
	}
}







