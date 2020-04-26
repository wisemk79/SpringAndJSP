package com.model.ex;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContryEtcController {
	
	
	
	@RequestMapping(value="/ModelAttributeVO.do")
	public ModelAndView ModelAttributeVO(@ModelAttribute DataReqResVO dataReqResVO, ModelMap model) {
		System.out.println("VO값 확인" + dataReqResVO);
		System.out.println("국가 =>" + dataReqResVO.getCountry());
		System.out.println("ETC =>" + dataReqResVO.getEtc());
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("dataReqResVO", dataReqResVO);
		mav.setViewName("ModelAttributeVo");
		return mav;
	}
	
//	모델 어트리뷰트의 어노테이션을 사용하면 어노테이션 오른쪽에있는 값으로 어느 jsp페이지에서든지 이 속성의 값을 사용할 수있게된다.
	@ModelAttribute("commonCodeMap")
	public Map<String, String> commonCodeMap(){
	    Map<String, String> commonCodeMap = new HashMap<String, String>();
	    commonCodeMap.put("code1", "codeValue1");
	    commonCodeMap.put("code2", "codeValue2");
	    return commonCodeMap;
	}
	
	@RequestMapping(value="/send")
	public String sendDataPage() {

		return "sendDatajsp";
	}
	
	
}
