package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//추가
import lys.board.*;

//글삭제->웹상의 암호=DB상의 암호
public class DeleteProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		//deletePro.jsp에서 자바코드를 대신수행=>결과를 공유
		//정상적으로 수정됐을때 수정이 된 레코드로 이동->게시물이 수정된 페이지로 이동하라
	    String pageNum=request.getParameter("pageNum");//hidden
	    //--------------------------------------------------------------------------
	    int num=Integer.parseInt(request.getParameter("num"));//hidden
	    String passwd=request.getParameter("passwd");//직접입력
	    //--------------------------------------------------------------------------
	    BoardDAO dbPro=new BoardDAO();//deleteArticle메서드 호출하기위해서 
	    int check=dbPro.deleteArticle(num,passwd);
	    
	    //공유
	    request.setAttribute("pageNum", pageNum);
	    request.setAttribute("check", check);
	    
		return "/deletePro.jsp";
	}
}



