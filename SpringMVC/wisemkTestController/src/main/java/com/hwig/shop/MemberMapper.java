package com.hwig.shop;

public interface MemberMapper {
	public MemberVO login(MemberVO memberVO);
	public MemberVO checkSession(String mem_id);
	public int insertMember(MemberVO memberVO);
	public int updateMember(MemberVO memberVO);
	public int deleteMember(MemberVO memberVO);
	public int checkId(MemberVO memberVO);
	public int checkEmail(MemberVO memberVO);
}
