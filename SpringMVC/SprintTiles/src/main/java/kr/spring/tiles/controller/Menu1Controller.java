package kr.spring.tiles.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Menu1Controller {  

	@RequestMapping("/menu1.do")
	public String process() { 
		return "menu1";//<definition name="menu1" template="/WEB-INF/~body-menu1.jsp"
	}
}




