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
}
