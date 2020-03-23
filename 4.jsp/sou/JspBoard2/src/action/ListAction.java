package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//추가
import lys.board.*;
import java.util.*;

// /list.do=action.ListAction
//각 액션클래스에서 공통으로 사용하는 메서드를 사용하기위해서 상속(CommandAction)
public class ListAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		   String pageNum=request.getParameter("pageNum");
		   //추가(검색분야,검색어)
		   String search=request.getParameter("search");
		   String searchtext=request.getParameter("searchtext");
		   //------------------------------------------------------------
		   int count=0;//총레코드수
		   List articleList=null;//화면에 출력할 레코드를 저장할 변수
		   BoardDAO dbPro=new BoardDAO();
		   count=dbPro.getArticleSearchCount(search,searchtext);//select count(*) from board=>getMemberList()
		   System.out.println("현재 검색된 레코드수(count)=>"+count);
		   
		   //페이징 처리의 처리결과를 담을 Hashtable객체생성
		   Hashtable<String,Integer> pgList=dbPro.pageList(pageNum, count);
		   
		   if(count > 0){                       //startRow,endRow(X)=>pageSize(O)
			   System.out.println(pgList.get("startRow")+","+pgList.get("endRow"));
			   articleList=dbPro.getBoardArticles(pgList.get("startRow"),//첫번째 레코드번호, 끊어서보여줄갯수
					                                              pgList.get("pageSize"),
					                                              search,searchtext);
		   }else {
			   articleList=Collections.EMPTY_LIST;//아무것도 없는 빈 list객체 반환
		   }
		   
		//2.처리결과->list.jsp에게 전달(메모리에 저장->공유시키기 위해서)->request에 저장
		   request.setAttribute("search", search);//${search}
		   request.setAttribute("searchtext", searchtext);//${searchtext}
		   request.setAttribute("pgList", pgList);//페이징 처리에 관련된 10개 저장된 객체하나
		   request.setAttribute("articleList", articleList);
		//3.이동할 페이지명 지정->return "경로포함해서 이동할 페이지명";
		return "/list.jsp";//Controller->/list.jsp->꺼내와서 출력
	}
}

