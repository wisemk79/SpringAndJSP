package com.pjt.pjt14;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Login {
/*	Model은 Model 객체를 파라미터로 받아서 데이터를 뷰로 넘길 수 있다.
 * // 데이터만 설정이 가능 model.addAttribute("id", "hongku"); 
 * model.addAttribute("변수이름", "변수에 넣을 데이터값");
 * 	return "board/view";
 * 
 *  * 뷰(.jsp 파일)에서는 ${}를 이용해서 값을 가져온다.
	ex) 당신의 ID는 ${id} 입니다.
	
	---------------------------------
	다른방법
	@RequestMapping("/board/content")
public ModelAndView content() {

    // 데이터와 뷰를 동시에 설정이 가능
    ModelAndView mv = new ModelAndView();
    mv.setViewName("/board/content"); // 뷰의 이름, 경로
    mv.addObject("data", "12341234"); // 뷰로 보낼 데이터 값
    
    return mv;
}

 * */

	@RequestMapping(value="/login", method= RequestMethod.GET)
	public String Login(Model model) {
		
		model.addAttribute("loginKey", "loginValue");
		
		return "login";//login.jsp
	}
}
