package com.hwig.shop;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api")
public class MemberController {
	
	@Autowired
	MemberDAOService memberDAOService;
	
	//로그인
	@RequestMapping(value="/mlogin/login", method=RequestMethod.POST)
	public Map<String, Object> login(@RequestBody MemberVO memberVO, HttpSession session) {
		System.out.println(memberVO.getMem_id() +" , "+ memberVO.getMem_pw());
		Map<String, Object> result = new HashMap<String,Object>();
		MemberVO  loginData = memberDAOService.login(memberVO);
		
		if(loginData == null) {
			result.put("mem", "");
			result.put("isLogged", false);
		}else {
			session.setAttribute("member", memberVO.getMem_id());
			result.put("mem", loginData);
			result.put("isLogged", true);
		}
		return result;
	}
	
	
	//로그아웃
	@RequestMapping(value="/mlogin/logout", method=RequestMethod.GET)
	public Map<String, Object> logout(HttpSession session){
		Map<String, Object> result = new HashMap<String,Object>();
		
		session.invalidate();
		Enumeration se = session.getAttributeNames();
		Boolean sessionExistCheck = se.hasMoreElements();
		System.out.println(sessionExistCheck);
		
			result.put("mem", "");
			result.put("isLogged", false);
		
		
		return result;
	}
	
	
	//세션체크
	@RequestMapping(value="/mlogin/session", method=RequestMethod.GET)
	public Map<String, Object> checkSession(HttpSession session) {
		System.out.println("세션 체크 실행");
		Map<String, Object> result = new HashMap<String,Object>();
		String sessionId = null;
		MemberVO  sessionData = null;
		
		
		//세션에있는 속성이름들을 가져온다.
		Enumeration se = session.getAttributeNames();
		Boolean sessionExistCheck = se.hasMoreElements();
		while(se.hasMoreElements()){
			String getse = se.nextElement()+"";
			//세션이름들을 출력한다. 		
			System.out.println("@@@@@@@ session : "+getse+" : "+session.getAttribute(getse));
			sessionId = (String) session.getAttribute(getse);
		}
		
		
		if(!sessionExistCheck) {
			System.out.println("세션없음");
			result.put("SESSION", "NO");
			result.put("mem", "");
			result.put("isLogged", false);
		}else {
			System.out.println("세션있음");
			sessionData = memberDAOService.checkSession(sessionId);
			result.put("SESSION", "YES");
			result.put("mem", sessionData);
			result.put("isLogged", true);
		}
		
		return result;
	}
	
	
	//회원가입
	@RequestMapping(value="/members", method=RequestMethod.POST)
	public Map<String, Object> join(@RequestBody MemberVO memberVO,HttpSession session){
		Map<String, Object> result = new HashMap<String,Object>();
		
		int joinData = memberDAOService.insertMember(memberVO);
		System.out.println(joinData);
		if(joinData == 1) {
			result.put("code", 201);
		}else {
			result.put("code", 500);
		}
		
		return result;
	}
	
	//아이디체크
	@RequestMapping(value="/members/check/id", method=RequestMethod.POST)
	public Map<String, Object> checkId(@RequestBody MemberVO memberVO){
		Map<String, Object> result = new HashMap<String,Object>();
		
		int idData = memberDAOService.checkId(memberVO);
		System.out.println(idData);
		if(idData > 0) {
			result.put("duplicated", true);
		}else {
			result.put("duplicated", false);
		}
		
		return result;
	}
	
	//이메일체크
	@RequestMapping(value="/members/check/email", method=RequestMethod.POST)
	public Map<String, Object> checkEmail(@RequestBody MemberVO memberVO){
		Map<String, Object> result = new HashMap<String,Object>();
		
		int emailData = memberDAOService.checkEmail(memberVO);
		System.out.println(emailData);
		if(emailData > 0) {
			result.put("duplicated", true);
		}else {
			result.put("duplicated", false);
		}
		
		return result;
	}
	
	
	
}
