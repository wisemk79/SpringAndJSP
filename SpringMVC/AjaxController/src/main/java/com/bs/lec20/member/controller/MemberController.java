package com.bs.lec20.member.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bs.lec20.member.Member;
import com.bs.lec20.member.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {


	
	@ResponseBody
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Map<String, Object> memLogin(Member member, HttpSession session) {
		System.out.println("실행");
		
		session.setAttribute("member", "dddd");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "victolee");
		map.put("age", 26);
		map.put("age", 26);
		return map;
	}

}
