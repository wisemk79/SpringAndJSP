package kr.spring.tiles.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Menu2Controller {  

	@RequestMapping("/menu2.do")
	public String process() { 
		return "menu2";//<definition name="menu2" template="/WEB-INF/~body-menu2.jsp"
	}
}




