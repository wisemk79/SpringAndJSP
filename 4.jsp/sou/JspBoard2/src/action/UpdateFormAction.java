package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// /updateForm.do?num=3&pageNum=1
/*(=스프링 (=컨트롤러)
 * 액션클래스=>1.jsp가 처리해야할 자바코드를 대신 처리
 *                  2.모델에 속한 클래스의 특정 메서드를 호출해서 결과를 리턴 받는다
 *                  3.받은 결과를 jsp가 공유해서 사용할 수 있도록 메모리에 저장
 */
import lys.board.*;//모델의 객체가 필요->메서드를 호출하기위해서 필요

public class UpdateFormAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		//updateForm.jsp에서 전달받은 매개변수처리
		
		   //content.jsp->글수정클릭->updateForm.do?num=1&pageNum=1  
		   int num=Integer.parseInt(request.getParameter("num"));
		   String pageNum=request.getParameter("pageNum");
		   BoardDAO dbPro=new BoardDAO();
		   BoardDTO article=dbPro.updateGetArticle(num);//조회수 증가X->담아서 출력용도

		//처리결과->메모리에 저장
		request.setAttribute("pageNum",pageNum);//수정하는 페이지로 이동필요
		request.setAttribute("article", article);
		//공유시켜주면서 이동
		return "/updateForm.jsp";
	}
}



