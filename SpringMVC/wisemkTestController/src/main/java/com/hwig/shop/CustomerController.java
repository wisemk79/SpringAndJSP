package com.hwig.shop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api")
public class CustomerController {
	
	@Autowired
	CustomerDAOService customerDAOService;
	
	@RequestMapping(value="/notice/nlist", method=RequestMethod.GET)
	public ArrayList<NoticeVO> getNoticeList(){
		ArrayList<NoticeVO> result = new ArrayList<NoticeVO>();
		result = customerDAOService.getNoticeList();
		System.out.println(result);
		
		return result;
	}
	
}
