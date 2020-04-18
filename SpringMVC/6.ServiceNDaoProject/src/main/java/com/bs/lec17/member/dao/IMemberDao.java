package com.bs.lec17.member.dao;

import com.bs.lec17.member.Member;

//데이터베이스 접근 객체에서 사용할 메서드를 정의한다.
public interface IMemberDao {
	// 회원가입시 멤버정보를 데이터베이스에 넣는기능
	void memberInsert(String memId, String memPw, String memMail, String memPhone1, String memPhone2, String memPhone3);
	//멤버정보를 데이터베이스에서 검색하는 기능(아이디, 패스워드)
	Member memberSelect(String memId, String memPw);
	//회원정보를 변경하는 기능
	void memberUpdate();
	//회원 탈퇴시 회원정보를 삭제하는 기능
	void memberDelete();
}
