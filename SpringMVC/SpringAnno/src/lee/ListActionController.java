package lee;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//Autowired,Required와 연관된 클래스 또는 인터페이스를 불러온다.
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
//
import org.springframework.stereotype.Controller;//@Controller
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.Controller; //이름이 같기때문에 충돌(주석)

 //   /list.do->ListActionController
//public class ListActionController implements Controller {
@Controller
public class ListActionController { //ListActionController->컨트롤러 클래스가 된다는의미

	BoardDAO dao;//BoardDAO dao=new BoardDAO();
	
	@Required
	@Autowired
	public void setDao(BoardDAO dao) { //<property name="dao"></property>
		this.dao=dao;
		System.out.println("setDao()호출됨(dao)=>"+dao);
	}
	
    @RequestMapping("/list.do")
	public ModelAndView handleRequest(HttpServletRequest request, 
			                                               HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("ListActionController의 handleRequest()호출됨!");
		//DB접속=>레코드 통째 가져와서 담음(ArrayList)=>/list.jsp로 이동
		//ArrayList list=dao.list();
		List list=dao.list();//NullPointerException ->객체생성X 메서드 호출하는 경우
		//------------------------------
		ModelAndView mav=new ModelAndView();//실행결과를 담아서 전송
		mav.setViewName("list");//이동할 파일만 사용->/list.jsp->viewResolver
		//request.setAttribute("list",list);
		mav.addObject("list",list); //${list(키명)}
		return mav;//Dispatcher->viewResolver(/list.jsp)->view(/list.jsp)화면에 출력
	}
}



