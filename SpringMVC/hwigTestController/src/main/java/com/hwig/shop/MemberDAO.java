package com.hwig.shop;

public interface MemberDAO {
	public MemberVO login(String mem_id, String mem_pw);
	public int insertMember(MemberVO memberVO);
	public int updateMember(String mem_id, String mem_pw, String mem_tel, String mem_name, String mem_addr, String mem_email );
	public int deleteMember(String mem_id);
}
