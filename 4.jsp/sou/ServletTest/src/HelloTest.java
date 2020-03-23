/*
 * Servlet->Server Side Applet(서버내부에서 실행되는 웹프로그램)=>브라우저에 전송(결과보기)
 *               Cliend Side ->자바스크립트(브라우저 실행)
 *               
 *  서블릿을 만드는 조건(=방법)
 *  
 *  1.import javax.servlet.*;//서블릿
 *     import javax.servlet.http.*;//웹상에서 접속에 관련된 정보
 *  2.반드시 public class로 작성해야 한다.  =>누구나 접속이 가능하게 만들기위해서 
 *  3.반드시 HttpServlet클래스를 상속 받아야 된다.
 *  ->doGet->get으로 접근->doGet()을 자동으로 호출(콜백메서드계열)
 *     doPost->post으로 접근->doPost()을 자동으로 호출
 */

import java.io.IOException;//입출력예외처리
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;//서블릿의 환경설정에 관련된 클래스
import javax.servlet.ServletException;//서블릿의 실행오류에 대한 예외처리클래스명
import javax.servlet.annotation.WebServlet;//서블릿의 어노테이션에 대한 클래스명
import javax.servlet.http.HttpServlet;//상속을 받을 부모클래스명
import javax.servlet.http.HttpServletRequest;//요청을 해주는 역할(투수)
import javax.servlet.http.HttpServletResponse;//요청에 따른 응답을 해주는 인터페이스(포수)

/**
 * Servlet implementation class HelloTest
 */
//@WebServlet("/test/imsi/HelloTest")
public class HelloTest extends HttpServlet {
	

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("서블릿 실행시 제일 먼저 호출되는 메서드(init)");
		System.out.println("생성자와 같은 역할(서블릿의 초기값을 설정할때 필요)");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("서블릿이 종료할때 (메모리 해제될때 자동으로 호출)");
	}

	/**
	 * 사용자로부터 요청(Get방식)을 받을때 자동으로 처리해주는 메서드
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("웹상에서 get방식으로 자동으로 호출됨");
		//1.어떤 형태의 문서를 만들어서 보내줄지 결정=>response객체가 처리
		response.setContentType("text/html;charset=utf-8");//html문서(한글처리)
		//2.PrintWriter클래스->메서드의 반환형을 통해서 얻어오기
		PrintWriter out=response.getWriter();
		out.println("<html><head></head>");//document.write("<html>");
		out.println("<body>");
		//외부에 접속할때 보여줄 내용
		out.println("<h2>Hello Servlet 테스트중입니다. 이연수 !!!</h2>");
		//추가
		out.println("<table border=1>");
		  for(int i=2;i<=9;i++) {//단
			  out.println("<tr>");
			  for(int j=1;j<10;j++) {
				out.println("<td>");
				out.println(""+i+"*"+j+"="+(i*j));
				out.println("</td>");
			  }
			  out.println("</tr>");
		  }
		out.println("</table>");
		out.println("</body>");
	    out.println("</html>");
	}

	/**
	 * 사용자로부터 요청(Post방식)을 받을때 자동으로 처리해주는 메서드(회원로그인,회원가입,파일업로드)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
