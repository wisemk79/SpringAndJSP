package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//추가
import lys.board.*;//BoardDTO,BoardDAO필요
import java.sql.Timestamp;//시간(테이블의 필드로써 시간과 연관이 있는 클래스)

// 글쓰기버튼클릭=>action="/JspBoard2/writePro.do요청
public class WriteProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
	    //한글처리
	    request.setCharacterEncoding("utf-8");
	    //BoardDTO->Setter Method(5)+hidden(4)+2개(작성)=>setWriter,setEmail,,,
	    //BoardDTO article=new BoardDTO();
	    //BoardDAO객체 필요
	
	   BoardDTO article=new BoardDTO();
	   article.setNum(Integer.parseInt(request.getParameter("num")));
	   article.setWriter(request.getParameter("writer"));
	   article.setEmail(request.getParameter("email"));
	   article.setSubject(request.getParameter("subject"));
	   article.setPasswd(request.getParameter("passwd"));
	   article.setReg_date(new Timestamp(System.currentTimeMillis()));//작성날짜,시간
	   //ref,re_step,re_level
	   article.setRef(Integer.parseInt(request.getParameter("ref")));
	   article.setRe_step(Integer.parseInt(request.getParameter("re_step")));
	   article.setRe_level(Integer.parseInt(request.getParameter("re_level")));
	   article.setContent(request.getParameter("content"));
	   article.setIp(request.getRemoteAddr());//원격ip주소 저장
	   //readcount->default로 설정한 관계로 자동으로 0이 들어간다.
	    BoardDAO dbPro=new BoardDAO();
	    dbPro.insertArticle(article);
	    //데이터공유하면서 이동X->그냥 이동->request.setAttribute()을 사용X
		return "/writePro.jsp"; // list.jsp로 이동
	}

}
