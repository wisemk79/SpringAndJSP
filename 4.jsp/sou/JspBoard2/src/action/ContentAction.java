package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//추가
import lys.board.*;//BoardDTO,BoardDAO필요

// /conent.do?num=2&pageNum=1
public class ContentAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		//content.jsp에서 처리한 자바코드를 분리해서 액션클래스가 대신 수행
		
		   //list.jsp에서 링크 content.do?num=3&pageNum=1
		   int num=Integer.parseInt(request.getParameter("num"));
		   String pageNum=request.getParameter("pageNum");
		   
		   BoardDAO dbPro=new BoardDAO();
		   BoardDTO article=dbPro.getArticle(num);//메서드의 매개변수 자료형이 int
		   //udate board set readcount=readcount+1 where num=?
		   //select * from board where num=?
		   //링크문자열의 길이를 줄이기 위해서,전달해주기 전의 값 확인
		   int ref=article.getRef();
		   int re_step=article.getRe_step();
		   int re_level=article.getRe_level();
		   System.out.println("content.do의 매개변수");
		   System.out.println("ref=>"+ref+",re_step=>"+re_step+",re_level=>"+re_level);
	
		//결과가 있다면 request.setAttribute(키,저장할값)저장=>데이터를 공유
		   request.setAttribute("num", num);
		   request.setAttribute("pageNum", pageNum);
		   request.setAttribute("article", article);//찾은 데이터 전달하기에 저장
		   //ref,re_step,re_level  전달X=>article안에 다 포함이 되어있기때문에
		//이동하는 페이지를 지정
		return "/content.jsp";  //return  "/member/list.jsp"
	}

}




