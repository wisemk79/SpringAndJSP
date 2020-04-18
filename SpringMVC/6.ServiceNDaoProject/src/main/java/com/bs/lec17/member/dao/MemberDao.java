package com.bs.lec17.member.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.bs.lec17.member.Member;

//@Component
@Repository
public class MemberDao implements IMemberDao {

	private HashMap<String, Member> dbMap;
	
	public MemberDao() {
		dbMap = new HashMap<String, Member>();
	}
	
	@Override
	public void memberInsert(String memId, String memPw, String memMail, String memPhone1, String memPhone2, String memPhone3) {
		//매개변수로 데이터베이스에 넣을 값이 제대로 왔는지 확인하기 위함이다.
		System.out.println("memberInsert()");
		System.out.println("memId : " + memId);
		System.out.println("memPw : " + memPw);
		System.out.println("memMail : " + memMail);
		System.out.println("memPhone : " + memPhone1 + " - " + memPhone2 + " - " + memPhone3);
		
		Member member = new Member();//멤버 객체(데이터 관리 객체)에 각 아이디 비밀번호등 회원가입시 필요한 정보들을 저장한다.
		member.setMemId(memId);
		member.setMemPw(memPw);
		member.setMemMail(memMail);
		member.setMemPhone1(memPhone1);
		member.setMemPhone2(memPhone2);
		member.setMemPhone3(memPhone3);
		
		dbMap.put(memId, member);//위에서 저장한 멤버객체를 Map객체에 아이디에따라 정보를 저장한다.
		
		//아래의 멤버데이터 출력과정은 회원이 몇명인지, db(현재는 진짜 데이터베이스가 아닌 Map객체)에 데이터가 잘 적재되었는지 확인하기 위함이다.
		
		/*set 객체와 iterator객체를 사용하는 이유... <---일단 이 예제는 db에 직접 접근하지 않고 Map객체를 사용하기 떄문임
		 * HashSet객체는 순서가 필요없는 데이터를 hash table에 저장. Set 중에 가장 성능이 좋음
		 * 
		 *Map의 전체값을 출력하기위해서는 entrySet()(key와 value값이 모두 필요한경우) 또는 keySet()(key값만 필요한경우)메소드를 사용하면되는데
		 *Iterator 인터페이스는 Map객체가 사용할 수 없어 위의 두 메소드를 사용하여 Set객체로 반환받아 Iterator를 사용한다. 
		 * */
		Set<String> keys = dbMap.keySet();
		Iterator<String> iterator = keys.iterator();
		
		while (iterator.hasNext()) {//이터레이터 객체에 값이 있으면 반복문을 수행한다.
			String key = iterator.next();//이터레이터의 키값을 가져온다. 
			Member mem = dbMap.get(key);//지금 이 예제에서 db로쓰이고 있는 Map객체에서 위에서 받은 키값을 기준으로 멤버객체에서 데이터를 가져온다.
			//가져온 멤버데이터를 출력한다.
			System.out.print("memberId:" + mem.getMemId() + "\t");
			System.out.print("|memberPw:" + mem.getMemPw() + "\t");
			System.out.print("|memberMail:" + mem.getMemMail() + "\t");
			System.out.print("|memberPhone:" + mem.getMemPhone1() + " - " + 
											   mem.getMemPhone2() + " - " + 
											   mem.getMemPhone3() + "\n");
		}
		
	}

	@Override
	public Member memberSelect(String memId, String memPw) {
		Member member = dbMap.get(memId);
		
		return member;
	}

	@Override
	public void memberUpdate() {

	}

	@Override
	public void memberDelete() {

	}

}