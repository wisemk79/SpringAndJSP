

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RepeatServlet
 */
@WebServlet("/RepeatServlet")
public class RepeatServlet extends HttpServlet {
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");//html문서(한글처리)
		//2.PrintWriter클래스->메서드의 반환형을 통해서 얻어오기
		PrintWriter out=response.getWriter();
		out.println("<html><head></head>");//document.write("<html>");
		out.println("<body>");
		//추가
		 request.setCharacterEncoding("utf-8");//한글처리
	     
		 String msg=request.getParameter("msg");//안녕하세요?
	      int number=Integer.parseInt(request.getParameter("number"));
	      System.out.println("msg=>"+msg+",number="+number);
	      //for,while
	      int count=0;//반복할 횟수 0
	      while(number>count){    //while(5>0) 5>1,5>2,5>3,5>4,5>5
	    	  out.println(msg+"<br>");
	          count++;
	      } 
		out.println("</body>");
	    out.println("</html>");
	}
}
