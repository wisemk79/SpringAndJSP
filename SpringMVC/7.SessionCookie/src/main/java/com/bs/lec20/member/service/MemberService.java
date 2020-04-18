package com.bs.lec20.member.service;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.lec20.member.Member;
import com.bs.lec20.member.dao.MemberDao;

@Service
public class MemberService implements IMemberService {
	
	@Autowired//데이터베이스 접근 객체를 자동 주입한다.
	MemberDao dao;
	
	@Override
	public void memberRegister(Member member) {
		//printMembers 메서드는 dao.memberInsert(member)를 수행하면서 회원정보를 데이터베이스에 적재한후에
		//반환되는 데이터베이스에 있는 회원정보에 대한 정보를 출력하기위해서 설정된 것이다.
		printMembers(dao.memberInsert(member));
	}

	//회원정보검색
	@Override
	public Member memberSearch(Member member) {
		// 회원의 정보를 데이터 접근 객체에서 추출하여 mem변수에 담아준뒤, 출력한다.
		Member mem = dao.memberSelect(member);
		printMember(mem);
		
		return mem;//mem변수를 반환한다.
	}

	//회원정보 수정
	@Override
	public Member memberModify(Member member) {
		
		//데이터 접근 객체에있는 memberUpdate메서드를 이용하여 정보를 변경한후에 반환되는 해당 회원의 정보를 담아서 출력한다.
		Member memAft = dao.memberUpdate(member);
		printMember(memAft);
		
		return memAft;//해당 회원의 정보를 반환한다.
	}
	
	//회원삭제
	@Override
	public void memberRemove(Member member) {
		//데이터 접근객체에있는 memberDelete메서드를 이용하여 회원정보를 삭제하고 반환되는 데이터베이스 객체를 출력하여 전체 회원정보를 확인한다.
		printMembers(dao.memberDelete(member));
	}
	
	
	//멤버객체에 대한 정보들을 iterator자료형으로 변환하여 전체 회원정보를 출력하기 위한 메서드
	private void printMembers(Map<String, Member> map) {
		
		Set<String> keys = map.keySet();
		Iterator<String> iterator = keys.iterator();
		
		while (iterator.hasNext()) {
			String key = iterator.next();
			Member mem = map.get(key);
			printMember(mem);
		}
		
	}
	
	// 회원정보(아이디, 패스워드, 이메일)를 출력하기 위한 메서드 
	private void printMember(Member mem) {
		
		System.out.print("ID:" + mem.getMemId() + "\t");
		System.out.print("|PW:" + mem.getMemPw() + "\t");
		System.out.print("|MAIL:" + mem.getMemMail() + "\n");
		
	}

}
