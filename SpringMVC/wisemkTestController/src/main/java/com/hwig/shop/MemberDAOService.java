package com.hwig.shop;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOService implements MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public MemberVO login(MemberVO memberVO) {
		// TODO Auto-generated method stub
		MemberVO result = new MemberVO();
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		result = memberMapper.login(memberVO);
		
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
	public int updateMember(MemberVO memberVO) {
		// TODO Auto-generated method stub
		int result;
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		result = memberMapper.updateMember(memberVO);
		
		return result;
	}

	@Override
	public int deleteMember(MemberVO memberVO) {
		// TODO Auto-generated method stub
		int result;
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		result = memberMapper.deleteMember(memberVO);
		return result;
	}

	@Override
	public MemberVO checkSession(String mem_id) {
		// TODO Auto-generated method stub
		MemberVO result = new MemberVO();
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		result = memberMapper.checkSession(mem_id);
		System.out.println("세션값은?=> " + result);
		return result;
	}

	@Override
	public int checkId(MemberVO memberVO) {
		// TODO Auto-generated method stub
		int result;
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		result = memberMapper.checkId(memberVO);
		
		return result;
	}

	@Override
	public int checkEmail(MemberVO memberVO) {
		// TODO Auto-generated method stub
		int result;
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		result = memberMapper.checkEmail(memberVO);
		
		return result;
	}
	
	



	
	
}
