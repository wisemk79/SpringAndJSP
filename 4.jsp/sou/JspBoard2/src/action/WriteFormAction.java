package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 글쓰기버튼을 클릭->요청->/writeForm.do=action.WriteFormAction
public class WriteFormAction implements CommandAction {

	 //모델1에서 대신 처리해줬던 자바코드를 대행해주는 액션클래스->writeForm.jsp
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		//1.jsp가 처리할 문장대신 수행
	    //list.jsp(글쓰기)->신규글, content.jsp(글상세보기)=>답변글
	     int num=0,ref=1,re_step=0,re_level=0;//insertArticle(BoardDTO articel)
	  
	      //content.jsp에서 매개변수가 전달된것이라면
	      if(request.getParameter("num")!=null){//양수라면
	    	  num=Integer.parseInt(request.getParameter("num"));//"3"=>3
	    	  ref=Integer.parseInt(request.getParameter("ref"));
	    	  re_step=Integer.parseInt(request.getParameter("re_step"));
	    	  re_level=Integer.parseInt(request.getParameter("re_level"));
	    	  System.out.println("content.jsp에서  넘어온 매개변수 확인");
	    	  System.out.println("num="+num+",ref="+ref+
	    			                       ",re_step="+re_step+",re_level=>"+re_level);
	      }
		//2.처리결과->request객체에 저장->ModelAndView객체에 저장
		  request.setAttribute("num", num);//<->request.getAttribute("num")->${num}
		  request.setAttribute("ref", ref);
		  request.setAttribute("re_step", re_step);
		  request.setAttribute("re_level", re_level);
		  //3.이동할 페이지를 지정
		return "/writeForm.jsp";//ControllerAction클래스가 받아서->/writeForm.jsp이동
	}

}





