package com.bs.lec17.member.service;

import com.bs.lec17.member.Member;

//서비스 인터페이스에는 구현할 기능에 대한 메서드를 작성한다.
public interface IMemberService {
	
	// 회원가입 기능 
	void memberRegister(String memId, String memPw, String memMail, String memPhone1, String memPhone2, String memPhone3);
	
	// 회원정보 검색 기능
	Member memberSearch(String memId, String memPw);
	
	// 회원정보 수정 기능
	void memberModify();
	
	// 회원 탈퇴 기능
	void memberRemove();
}
