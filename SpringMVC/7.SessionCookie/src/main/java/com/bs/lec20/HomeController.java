package com.bs.lec20;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	
	/*
	 * request.getContextPath()는 프로젝트 path만 얻어온다.

			요청 : http://localhost/ZESTINE/test.jsp 경우
			
			→ /ZESTINE 경로만 얻는다
			
			
			request.getRequestURI()는 프로젝트와 파일 경로까지 얻어온다.
			
			요청 : http://localhost/ZESTINE/test.jsp 경우
	 * */
	
	@ModelAttribute("cp")
	public String getContextPath(HttpServletRequest request) {
		return request.getContextPath();
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "/index";
	}
	
}