package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//추가
import lys.board.*;//BoardDTO,BoardDAO필요
import java.sql.Timestamp;//시간(테이블의 필드로써 시간과 연관이 있는 클래스)

// 글쓰기버튼클릭=>action="/JspBoard2/UpdatePro.do요청
public class UpdateProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
	    //한글처리
	    request.setCharacterEncoding("utf-8");
	    String pageNum=request.getParameter("pageNum");//수정할데이터가 있는 페이지이동
	
	   BoardDTO article=new BoardDTO();//수정할 데이터를 담기위해서 필요
	   article.setNum(Integer.parseInt(request.getParameter("num")));//수정데이터찾기
	   article.setWriter(request.getParameter("writer"));
	   article.setEmail(request.getParameter("email"));
	   article.setSubject(request.getParameter("subject"));
	   article.setContent(request.getParameter("content"));
	   article.setPasswd(request.getParameter("passwd"));
	   
	   //readcount->default로 설정한 관계로 자동으로 0이 들어간다.
	    BoardDAO dbPro=new BoardDAO();
	    int check=dbPro.updateArticle(article);//1(수정성공),0(수정실패)
	    
	    //2개의 공유값을 전달
	    request.setAttribute("pageNum", pageNum);//${pageNum}
	    request.setAttribute("check", check);//${check}
	    
		return "/updatePro.jsp"; // list.jsp로 이동
	}
}





