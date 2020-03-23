package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// 글삭제-> /deleteForm.do?num=3&pageNum=1->
public class DeleteFormAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		//deleteForm.jsp에서의 자바코드 대신작업
	    //content.jsp->deleteForm.jsp?num=2&pageNum=1
	    int num=Integer.parseInt(request.getParameter("num"));
	    String pageNum=request.getParameter("pageNum");//확인소스코드 생략
	    
	    //2.request객체 저장(공유)
		request.setAttribute("num", num);//삭제할 게시물번호
		request.setAttribute("pageNum", pageNum);//삭제할 게시물이 있는 페이지번호 전달
		
		return "/deleteForm.jsp";
	}
}




