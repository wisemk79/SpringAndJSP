package com.hwig.shop;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOService implements MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public MemberVO login(String mem_id, String mem_pw) {
		// TODO Auto-generated method stub
		MemberVO result = new MemberVO();
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		result = memberMapper.login(mem_id, mem_pw);
		return result;
	}

	@Override
	public int insertMember(MemberVO memberVO) {
		// TODO Auto-generated method stub
		int result; 
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		result = memberMapper.insertMember(memberVO);
		
		return result;
	}

	@Override
	public int updateMember(String mem_id, String mem_pw, String mem_tel, String mem_name, String mem_addr, String mem_email ) {
		// TODO Auto-generated method stub
		int result;
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		result = memberMapper.updateMember(mem_id, mem_pw, mem_tel, mem_name, mem_addr, mem_email );
		
		return result;
	}

	@Override
	public int deleteMember(String mem_id) {
		// TODO Auto-generated method stub
		int result;
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		result = memberMapper.deleteMember(mem_id);
		
		return result;
	}


	
	
}
