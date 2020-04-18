package com.bs.lec17.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bs.lec17.member.Member;
import com.bs.lec17.member.dao.MemberDao;

//@Service  <--이 아래에있는 모든 어노테이션은 사용용도가 동일하며, 서블릿 컨텍스트에 객체를 생성하여 오토와이어드로 자동주입시킬수 있도록하는 것이다.
//@Service("memService")
//@Component
//@Component("memService")
//@Repository
@Repository("memService")
public class MemberService implements IMemberService {

	@Autowired//오토와이어드로 데이터 접근 객체를 자동 주입시킨다.
	MemberDao dao;
	
	//회원가입기능 구현(회원가입은 회원데이터를 넣기만하기 때문에 반환하는 값이 없어 void로 선언한다.)
	@Override
	public void memberRegister(String memId, String memPw, String memMail,
			String memPhone1, String memPhone2, String memPhone3) {
		System.out.println("memberRegister()");
		System.out.println("memId : " + memId);
		System.out.println("memPw : " + memPw);
		System.out.println("memMail : " + memMail);
		System.out.println("memPhone : " + memPhone1 + " - " + memPhone2 + " - " + memPhone3);
		
		//데이터 접근 객체에서 memberInsert메서드를 이용하여 회원의 데이터를 데이터베이스에 넣는다.
		dao.memberInsert(memId, memPw, memMail, memPhone1, memPhone2, memPhone3);
	}

	//회원정보 검색기능 (회원정보 검색기능은 회원정보를 반환해야하기 떄문에 Memeber객체를 반환한다.)
	@Override
	public Member memberSearch(String memId, String memPw) {
		System.out.println("memberSearch()");
		System.out.println("memId : " + memId);
		System.out.println("memPw : " + memPw);
		
		//데이터 
		Member member = dao.memberSelect(memId, memPw);
		
		return member;
	}

	@Override
	public void memberModify() {
		
	}

	@Override
	public void memberRemove() {
		
	}

}