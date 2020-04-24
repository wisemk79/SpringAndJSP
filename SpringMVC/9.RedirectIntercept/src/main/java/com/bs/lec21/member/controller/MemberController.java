package com.bs.lec21.member.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bs.lec21.member.Member;
import com.bs.lec21.member.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	MemberService service;
	
	@ModelAttribute("cp")
	public String getContextPath(HttpServletRequest request) {
		return request.getContextPath();
	}
	
	@ModelAttribute("serverTime")
	public String getServerTime(Locale locale) {
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		return dateFormat.format(date);
	}
	
	// Join
	@RequestMapping("/joinForm")
	public String joinForm(Member member) {
		return "/member/joinForm";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String joinReg(Member member) {
		
		service.memberRegister(member);
		
		return "/member/joinOk";
	}
	
	// Login
	@RequestMapping("/loginForm")
	public String loginForm(Member member) {
		return "/member/loginForm";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String memLogin(Member member, HttpSession session) {
		
		Member mem = service.memberSearch(member);
		
		session.setAttribute("member", mem);
		
		return "/member/loginOk";
	}
	
	// Logout
	@RequestMapping("/logout")
	public String memLogout(Member member, HttpSession session) {
		
		session.invalidate();
		
		return "/member/logoutOk";
	}
	
	// Modify
	//여기서 modifyForm으로 오게되면 로그인한 회원의 정보를 변경할 수 있는데,
	//중요한것은 로그인이 되어있지 않은상태에서 회원정보 수정 페이지에 오게되면 의미가 없게된다.
	//따라서 회원 로그인이 되어있지 않은 경우, 리다이렉트로 로그인 페이지로 이동시켜 로그인을 유도해야되는데,
	//이는 세션의 존재여부로 설정해줄 수 있다.
	@RequestMapping(value = "/modifyForm")
	public String modifyForm(Model model, HttpServletRequest request) {
		
		//세션객체를 가져와 세션을 가져온다.<--이는 위에서 HttpSession객체를 직접줘서 구현하는 방법도있음.
		HttpSession session = request.getSession();
		//세션 객체에서 member의 세션값을 가져온다.
		Member member = (Member) session.getAttribute("member");
		
		//만약 위의 getAttribute에서 세션값이 없다면(로그인이 되어있지 않다면) null일것이고, 로그인페이지로 이동시켜줘야한다.
		if(null == member) {
			return "redirect:/member/loginForm";
		} else {
			//세션값이 존재한다면. 모델객체에 서비스객체 메소드인 memberSearch를이용하여 
			//세션에 해당하는 회원정보를 가져와 값으로 넣어주고, modifyForm.jsp로 전달해준다.
			model.addAttribute("member", service.memberSearch(member));
		}
		
		return "/member/modifyForm";
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
		
		//회원삭제도 똑같이 로그인이 되어있지 않다면 로그인페이지로 이동시킨다.
		if(null == member) {
			mav.setViewName("redirect:/member/loginForm");//setViewName란 ModelAndView객체를 이용해서 뷰페이지로 이동시켜주는 것이다.
		} else {
			//만약 로그인이되어있다면 회원 정보를 넣어주고 삭제 폼에 넣어준다.
			mav.addObject("member", member);
			mav.setViewName("/member/removeForm");
		}
		
		
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