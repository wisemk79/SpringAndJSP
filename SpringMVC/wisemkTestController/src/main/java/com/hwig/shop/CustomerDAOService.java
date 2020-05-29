package com.hwig.shop;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAOService  implements CustomerDAO{
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public ArrayList<NoticeVO> getNoticeList() {
		// TODO Auto-generated method stub
		ArrayList<NoticeVO> list = new ArrayList<NoticeVO>();
		CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
		list = customerMapper.getNoticeList();
		return list;
	}

	@Override
	public NoticeVO getNoticeArticle(int notice_id) {
		// TODO Auto-generated method stub
		NoticeVO result = new NoticeVO();
		CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
		result = customerMapper.getNoticeArticle(notice_id);
		return result;
	}

	@Override
	public int noticeHitUp(int notice_id) {
		// TODO Auto-generated method stub
		int result;
		CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
		result = customerMapper.noticeHitUp(notice_id);
		
		return result;
	}

	
	@Override
	public ArrayList<FaqVO> getFaqList() {
		// TODO Auto-generated method stub
		ArrayList<FaqVO> list = new ArrayList<FaqVO>();
		CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
		list = customerMapper.getFaqList();
		return list;
	}
}
