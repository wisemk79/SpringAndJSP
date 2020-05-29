package com.hwig.shop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//고객센터 컨트롤러
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api")
public class CustomerController {
	
	@Autowired
	CustomerDAOService customerDAOService;
	
	
	//게시판 리스트 
	@RequestMapping(value="/notice/nlist", method=RequestMethod.GET)
	public ArrayList<NoticeVO> getNoticeList(){
		ArrayList<NoticeVO> result = new ArrayList<NoticeVO>();
		result = customerDAOService.getNoticeList();
		System.out.println(result);
		
		return result;
	}
	
	//게시물 내용
	@RequestMapping(value="/notice/notice_view", method=RequestMethod.GET)
	public NoticeVO getNoticeArticle(@RequestParam(name = "notice_id") int notice_id){
		NoticeVO result = new NoticeVO();
		customerDAOService.noticeHitUp(notice_id);
		result = customerDAOService.getNoticeArticle(notice_id);
		System.out.println(result);
		
		return result;
	}
	
	//자주묻는 질문 리스트 및 내용
	@RequestMapping(value="/faq/flist", method=RequestMethod.GET)
	public ArrayList<FaqVO> getFaqList(){
		ArrayList<FaqVO> result = new ArrayList<FaqVO>();
		result = customerDAOService.getFaqList();
		System.out.println(result);
		
		return result;
	}
}
