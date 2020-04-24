package lee;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/*
 * 컨트롤러 클래스=>사용자로부터 요청을 받아서 처리해주는 클래스(=액션클래스)
*/
//public class WriteActionController extends AbstractCommandController {
@Controller
public class WriteActionController{
  
	@Autowired
    BoardDAO dao;//메서드 위에 선언->Setter Method가 필요없다.
	
	/*
	public void setDao(BoardDAO dao) { //<property name="dao"></property>
		this.dao=dao;
		System.out.println("setDao()호출됨(dao)=>"+dao);
	}*/
	
	@RequestMapping("/write.do")
	protected ModelAndView test(@RequestParam("title") String title,
			                                     @RequestParam("author") String author,
			                                     @RequestParam("content") String content)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("WriteActionController의 test()호출됨 !");
		//request.setCharacterEncoding("utf-8");
		/*
		 * String author=request.getParameter("author");와 동일한 기능->어노테이션
		 * String content=request.getParameter("content");
		 * String title=request.getParamert("title");
		 * ,,
		 */
		BoardCommand data=new BoardCommand();//Setter Method호출확인
		//최대값
		int newNum=dao.getNewNum()+1;//기존의 번호+1=새로운 번호를 입력
		data.setNum(newNum);//새로운 게시물번호
		//추가(입력받은 갯수만큼)
		data.setTitle(title);
		data.setAuthor(author);
		data.setContent(content);
		//---------------------------------
		dao.write(data);
		return new ModelAndView("redirect:/list.do");
	}
}






