package lee;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

 //   /retrieve.do->RetrieveActionController
public class DeleteActionController implements Controller {

	BoardDAO dao;//BoardDAO dao=new BoardDAO();
	
	public void setDao(BoardDAO dao) { //<property name="dao"></property>
		this.dao=dao;
		System.out.println("setDao()호출됨(dao)=>"+dao);
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, 
			                                               HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("DeleteActionController의 handleRequest()호출됨!");
		//  /delete.do?num=3
		String num=request.getParameter("num");//삭제할 게시물번호
		dao.delete(num);
		
		ModelAndView mav=new ModelAndView();//(이동할 페이지명)
		mav.setViewName("redirect:/list.do");//ListActionController

		return mav;//Dispatcher->viewResolver(/retrieve.jsp)->view(/retrieve.jsp)화면에 출력
	}
}


