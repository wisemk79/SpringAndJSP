package lee;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;
/*
 * 컨트롤러 클래스=>사용자로부터 요청을 받아서 처리해주는 클래스(=액션클래스)
 * 1) 보편적인 컨트롤러(Controller 인터페이스) 상속=>글목록보기,글상세보기
 * 
 * 2)사용자로부터 값을 입력을 처리해주는 컨트롤러
 *    (글쓰기,글수정,로그인->AbstractCommandController)
 *   <property name="commandClass" value="lee.BoardCommand" />
 */
public class WriteActionController extends AbstractCommandController {
  //commandClass->AbstractCommandController의 멤버변수
	
	/*
	 * 1.request(요청객체) 2.response(응답객체) 3.입력받은값을 저장한 객체(Object)
	 * 4.BindException->사용자로부터 값을 입력해서 연결시킬때 에러가 발생되는 객체(정보기록)
	 */
    BoardDAO dao;//BoardDAO dao=new BoardDAO();
	
	public void setDao(BoardDAO dao) { //<property name="dao"></property>
		this.dao=dao;
		System.out.println("setDao()호출됨(dao)=>"+dao);
	}
	@Override
	protected ModelAndView handle(HttpServletRequest request, 
			                                         HttpServletResponse response,
			                                         Object command, BindException error)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("WriteActionController 실행됨!");
		request.setCharacterEncoding("utf-8");
		BoardCommand data=(BoardCommand)command;//Setter Method호출확인
		String author=data.getAuthor();
		String content=data.getContent();
		String title=data.getTitle();
		/*
		 * String author=request.getParameter("author");
		 * String content=request.getParamter("content");
		    String title=request.getParamter("title");
		 */
		dao.write(author, title, content);//dao.write(data);//통째로 저장
		//response.sendRedirect("list.jsp")=>형식) redirect:/요청명령어
		//write.do->/list.do->ListActionController->/list.jsp웹상에 출력
		/*
		ModelAndView mav=new ModelAndView("redirect:/list.do");
		return mav;
		*/
		return new ModelAndView("redirect:/list.do");
	}

}






