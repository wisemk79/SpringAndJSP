package lee;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

public class UpdateActionController extends AbstractCommandController {
  
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
		System.out.println("UpdateActionController 실행됨!");
		request.setCharacterEncoding("utf-8");
		BoardCommand data=(BoardCommand)command;//Setter Method호출확인
		//hidden객체를 쓰지 않고 매개변수를 전달
		/* before
		String num=request.getParameter("num");
		//--------------------------------------------------
		String author=data.getAuthor();
		String content=data.getContent();
		String title=data.getTitle();
		dao.update(num,author, title, content);//dao.update(data);//통째로 저장
		*/
		//after
		dao.update(data);//#{num},#{title}->getNum(),getTitle()호출해서 값이 각 필드에
		                          //저장이 된다.
		return new ModelAndView("redirect:/list.do");
	}
}






