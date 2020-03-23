package test;

import java.io.*;//입출력
import javax.servlet.*;//서블릿을 실행
import javax.servlet.annotation.WebServlet;//어노테이션 때문에=>스프링
import javax.servlet.http.*;//웹상에서 어떻게 서블릿을 요청(경로,프로토콜) 정보


@WebServlet("/SimpleController")
public class SimpleController extends HttpServlet {
	
	//요청을 받아서 처리해주는 메서드->request(요청), response(결과를 보내준다.)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request,response);
	}
	
	//Get or Post방식으로 요청에 상관없이 둘다 다 처리할 수 있도록 메서드를 따로 작성
	private void processRequest(HttpServletRequest request, 
			                                    HttpServletResponse response) 
			                                    throws ServletException, IOException {
	    //1.요청명령어를 입력받아서 분석->매개변수->type
		String type=request.getParameter("type");
		System.out.println("type=>"+type);
		//2).greeting=>안녕하세요? ,date->오늘 날짜 출력, X->invalid Type 화면에 출력
		//2.요청명령어에 따른 요청기능을 구현->요청처리 클래스의 객체생성->처리(화면에 보여주는것)
		Object resultObject=null;//String or java.util.Date 둘다 다 처리할려고 Object선언
		if(type==null || type.contentEquals("greeting")) {
			resultObject="안녕하세요!!!";//자식(String)=>부모(Object)=>명령어처리클래스 생성
		}else if(type.contentEquals("date")) {
			resultObject=new java.util.Date();
		}else { //greeting or date외의 다른 매개변수를 전달받으면 X
			resultObject="정확하게 다시한번 알려주세요!!!";
		}
		
		//3.처리결과=>simpleview.jsp에게 전송->화면에 출력
		request.setAttribute("result", resultObject);//메모리에 저장
		
		//4.forward액션태그를 사용(jsp)(X)->forward를 시켜주는 객체필요(RequestDispatcher생성)
		//dispatcher->데이터를 공유받아서 이동할 페이지의 정보를 가진 객체
		RequestDispatcher dispatcher=
				        request.getRequestDispatcher("/simpleview.jsp");//전송할 페이지명
	    //5.forward->데이터를 공유시키면서 페이지를 이동시키는 기능
		dispatcher.forward(request, response);
	   
	}
}




