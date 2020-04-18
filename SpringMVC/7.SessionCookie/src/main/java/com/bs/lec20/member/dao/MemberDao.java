package com.bs.lec20.member.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bs.lec20.member.Member;

@Repository
public class MemberDao implements IMemberDao {
	//멤버 데이터 처리 객체를 hashMap 자료형의 value값으로 사용하여 맵 객체를 생성한다.	
	private HashMap<String, Member> dbMap;
	
	//dao 객체가 생성될 때 마다 맵 객체를 생성한다.
	public MemberDao() {
		dbMap = new HashMap<String, Member>();
	}
	
	
	//회원정보를 넣을 때 사용되는 메소드이다. 멤버 데이터 객체를 매개변수로 넣어준다.
	@Override
	public Map<String, Member> memberInsert(Member member) {
		
		//맵 객체에 키값으로 매개변수로받은 멤버 데이터의 아이디를 주고 value로 매개변수로 받은 멤버 객체의 데이터들을 넣어준다.
		dbMap.put(member.getMemId(), member);
		return dbMap;//해당 맵 객체를 반환한다.
		
	}

	//로그인시 회원의 데이터를 가져온다. 
	@Override
	public Member memberSelect(Member member) {
		
		//멤버 객체에 데이터베이스에 있는 입력받은 멤버객체의 아이디를 매개변수로 넣어 데이터베이스에서 해당 회원의 정보를 꺼내온다.
		Member mem = dbMap.get(member.getMemId());
		return mem;// 해당 회원의 정보를 반환한다.
		
	}

	//회원 정보를 수정한다.
	@Override
	public Member memberUpdate(Member member) {
		
		//입력받은 멤버객체의 아이디를 키값으로 주어 그 멤버 객체의 데이터 값을 입력받은 멤버데이터로 교체한다.
		//현재 예제에서는 데이터 베이스를 맵객체로 사용하고있으며, 맵객체의 특성상 키값의 중복을 허용하지않기 때문에
		//데이터베이스(맵객체)에서 해당 아이디에 대한 정보가 있어도 바뀔 수 있다.
		dbMap.put(member.getMemId(), member);
		return dbMap.get(member.getMemId());//해당 회원정보를 반환한다.
		
	}

	@Override
	public Map<String, Member> memberDelete(Member member) {
		
		//입력받은 멤버객체의 아이디를 기준으로 데이터베이스에서 삭제한다.
		dbMap.remove(member.getMemId());
		return dbMap;//데이터베이스 객체를 반환한다.
		
	}

}
