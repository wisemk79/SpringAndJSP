package lee;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

 //   /retrieve.do->RetrieveActionController
public class RetrieveActionController implements Controller {

	BoardDAO dao;//BoardDAO dao=new BoardDAO();
	
	public void setDao(BoardDAO dao) { //<property name="dao"></property>
		this.dao=dao;
		System.out.println("setDao()호출됨(dao)=>"+dao);
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, 
			                                               HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("RetrieveActionController의 handleRequest()호출됨!");
		//  /retrieve.do?num=3
		String num=request.getParameter("num");
		Board data=dao.retrieve(num);
		/*
		ModelAndView mav=new ModelAndView();//실행결과를 담아서 전송
		mav.setViewName("retrieve");//이동할 파일만 사용->/list.jsp->viewResolver
		*/
		ModelAndView mav=new ModelAndView("retrieve");//(이동할 페이지명)
		//request.setAttribute("list",list);
		mav.addObject("data",data); //${data(키명)}
		return mav;//Dispatcher->viewResolver(/retrieve.jsp)->view(/retrieve.jsp)화면에 출력
	}
}


