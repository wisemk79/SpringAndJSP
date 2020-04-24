package com.study.ex;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller//컨트롤러 클래스를 구현하게 하는 어노테이션
public class MyController {
	
	@RequestMapping//url을 컨트롤러의 메서드와 매핑할때 사용하는 어노테이션이다.
	public String memberInput() {
		
		return "memberRegister";
	}
	
	@RequestMapping(value="/post/memberInfo")
	public String memberInfo(Model model) {
		model.addAttribute("name", "삼식이");
		
		return "memberInfo";
	}
	
	@RequestMapping(value="/post/demo")
	public String testModel(Model model) {
		model.addAttribute("address", "서울시 강남구");
		
		return "modelDemo";
	}
	
	@RequestMapping(value="/post/mavview")
	public ModelAndView modelAndView() {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("email", "aaa@aaa.com");//모델객체와는 다르게 addAttribute를 쓰지 않고 값을 addObject로 지정한다.
		mav.setViewName("modelView");//보여줄뷰페이지를 setViewName 으로 지정하고 리턴해준다.
		
		return mav;
	}
	
	@RequestMapping(value="/post/jndi")
	public String jnditest() {
		
		return "datasource";
	}
	
	
	
	
	
	
}
