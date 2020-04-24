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
import javax.naming.*;
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

	@Autowired//서비스 객체를 자동으로 주입한다.
	MemberService service;
	
	@ModelAttribute("cp")
	public String getContextPath(HttpServletRequest request) {
		return request.getContextPath();//request객체를 통해 컨텍스트 패스를 가져온다. /lec20
	}
	
	//@ModelAttribute어노테이션을 메서드 위에 선언하게되면 memRemoveOk.jsp에서 볼 수 있듯이, 어떠한 jsp에서든지
	// 값을 ${ServerTime} 이런식으로 값을 불러 올 수 있다.
	@ModelAttribute("serverTime")
	public String getServerTime(Locale locale) {
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		return dateFormat.format(date);
	}
	
	// Join
	// /member/joinForm.jsp의 맵핑을 /joinForm으로 설정한다
	@RequestMapping("/joinForm")
	public String joinForm(Member member) {
		return "/member/joinForm";
	}
	
	// joinForm에서 회원가입을할떄 action을 /join으로 하고 메소드를 POST로 설정하면 아래의 메서드로 온다.
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String joinReg(Member member) {
		
		//서비스객체에있는 memberRegister메서드를 이용하여 입력받은 멤버 객체의 데이터들을 데이터베이스에 넣는다.
		service.memberRegister(member);
		
		//회원가입이 완료되면 joinOK.jsp로 이동한다.
		return "/member/joinOk";
	}
	
	// Login
	// /member/loginForm.jsp의 맵핑을 /loginForm으로 설정한다
	@RequestMapping("/loginForm")
	public String loginForm(Member member) {
		return "/member/loginForm";
	}
	
	/*
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String memLogin(Member member, HttpServletRequest request) {
		
		Member mem = service.memberSearch(member);
		
		HttpSession session = request.getSession();
		session.setAttribute("member", mem);
		
		return "/member/loginOk";
	}
	*/
	@ResponseBody
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Map<String, Object> memLogin(Member member, HttpSession session) {
		System.out.println("실행");
		//서비스 객체에 있는 memberSearch메서드를 이용하여 멤버 객체를 넣는다.
		Member mem = service.memberSearch(member);
		
		//mem변수의 정보를 세션에 담는다.
		session.setAttribute("member", mem);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "victolee");
		map.put("age", 26);
		return map;//멤버변수에 있는 이름과 나이를 객체형태로 반환해준다.
	}
	
	// Logout
	/*
	@RequestMapping("/logout")
	public String memLogout(Member member, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		return "/member/logoutOk";
	}
	*/
	
	@RequestMapping("/logout")
	public String memLogout(Member member, HttpSession session) {
		//세션값을 삭제한다.
		session.invalidate();
		
		return "/member/logoutOk";
	}
	
	// Modify
	@RequestMapping(value = "/modifyForm", method = RequestMethod.GET)
	public ModelAndView modifyForm(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("member", service.memberSearch(member));
		
		mav.setViewName("/member/modifyForm");
		
		return mav;
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public ModelAndView modify(Member member, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		Member mem = service.memberModify(member);
		session.setAttribute("member", mem);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("memAft", mem);
		mav.setViewName("/member/modifyOk");
		
		return mav;
	}
	
	// Remove
	@RequestMapping("/removeForm")
	public ModelAndView removeForm(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		
		HttpSession session =  request.getSession();
		Member member = (Member) session.getAttribute("member");
		mav.addObject("member", member);
		mav.setViewName("/member/removeForm");
		
		return mav;
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String memRemove(Member member, HttpServletRequest request) {
		
		service.memberRemove(member);
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		return "/member/removeOk";
	}
	
}
