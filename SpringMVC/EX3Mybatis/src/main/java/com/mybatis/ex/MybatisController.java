	package com.mybatis.ex;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//컨트롤러 부분으로서 DB로부터 가져온값을 view화면으로 보내어준다.
@Controller
public class MybatisController {
	
	@Autowired
	private MemberDAOService memberDAOService;
	
	private static Logger logger = LoggerFactory.getLogger(MybatisController.class);
	
	//시작메인화면
    @RequestMapping("/main")
    public ModelAndView main(Locale locale, Model model) {
        logger.info("Welcome main.", locale);
 
        // view 화면인 main.jsp에 DB로부터 읽어온 데이터를 보여준다.
        ModelAndView result = new ModelAndView();
        //addObject view에 넘어가는 데이터
        List<Member> memberList = memberDAOService.getMembers();
        result.addObject("result", memberList);
        result.setViewName("main");
        System.out.println(result);
        return result;
    }
    
    //insert 버튼 클릭시 값을 가져와서 result.jsp로 화면전환을 해준다.
    // 중요!! 404오류난다면 서버 패스가 루트 컨텍스트들어가있는것을 의심하고 프로젝트 오른쪽클릭해서 properties들어가서 web project setting 에서 /로 바꿔주면된다.
    @RequestMapping(value="/insert", method= RequestMethod.POST)
    public ModelAndView insert(HttpServletRequest request, Member member) {
    	//HttpServletRequest 객체를 이용하여 main.jsp로부터 값을 가져온다. getParameter로는 id값을 가져옴
    	member.set_name((String)request.getParameter("name"));
    	member.set_email((String)request.getParameter("email"));
    	member.set_phone((String)request.getParameter("phone"));
    	System.out.println(request.getParameter("phone") + ", " + (String)request.getParameter("email") + ", " +(String)request.getParameter("name"));
    	
    	memberDAOService.insertMember(member);
    	System.out.println("insert complete");
    	
    	//아래부분은 select값을 result.jsp 파일에 보여주기 위해 또 사용
    	ModelAndView result = new ModelAndView();
    	List<Member> memberList = memberDAOService.getMembers();
    	result.addObject("result", memberList);
    	result.setViewName("result");
    	
    	return result;
    }
    
    
}
