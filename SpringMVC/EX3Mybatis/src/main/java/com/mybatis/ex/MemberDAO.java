package com.mybatis.ex;

import java.util.ArrayList;

/*MemerMapper와 내용은 같으나 DAO를 Mapper의 역활로서 함께 사용시 문제가 발생하기에 따로 구분하여 사용하는 것이 좋다!!! 중요하다!!*/
public interface MemberDAO {
	public ArrayList<Member> getMembers();
	 public void insertMember(Member member);
	    public void updateMember(String name);
	    public void deleteMember(String name);
}
