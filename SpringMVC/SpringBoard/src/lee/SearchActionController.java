package lee;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

 //   /search.do->SearchActionController
public class SearchActionController implements Controller {

	BoardDAO dao;//BoardDAO dao=new BoardDAO();
	
	public void setDao(BoardDAO dao) { //<property name="dao"></property>
		this.dao=dao;
		System.out.println("setDao()호출됨(dao)=>"+dao);
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, 
			                                               HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("SearchActionController의 handleRequest()호출됨!");
		//검색분야,검색어에 해당하는 레코드만 보여줄 수 있도록 레코드 담기
		String searchName=request.getParameter("searchName");//검색분야
		String searchValue=request.getParameter("searchValue");//검색어
		//--------------------------------------------------------------------------
		//DB접속=>레코드 통째 가져와서 담음(ArrayList)=>/list.jsp로 이동
		ArrayList list=dao.search(searchName,searchValue);
		
		ModelAndView mav=new ModelAndView();//실행결과를 담아서 전송
		mav.setViewName("list");//이동할 파일만 사용->/list.jsp->viewResolver
		mav.addObject("list",list); //${list(키명)}
		return mav;//Dispatcher->viewResolver(/list.jsp)->view(/list.jsp)화면에 출력
	}
}



