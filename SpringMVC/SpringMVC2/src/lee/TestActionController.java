package lee;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//모델2 public class TestActionController implements CommandAction {
//                                                       ~implements Controller(인터페이스)
public class TestActionController implements Controller {

	//모델2 public String requestPro(reqest,response){ 처리문장  return "이동할 페이지"}
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, 
			                                               HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TestController의 handleRequest 자동호출됨!");
		ModelAndView mav=new ModelAndView();//이동할 경로와 이동할 페이지정보담고 있다
		//<property name="viewName" value="list(이동할 페이지명" />
		mav.setViewName("list3");//이동할 페이지이름만 작성->경로X, 확장자X
		//모델2=>request.setAttribute("키명",저장할값)->request.getAttribute("키명");
		mav.addObject("greeting","스프링세상!");
		//request.setAttribute("greeting","스프링세상!")
		return mav;//모델2에서는 return "/list3.jsp";
	}
}



