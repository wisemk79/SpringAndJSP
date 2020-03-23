

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Servlet implementation class GetDate
 */
@WebServlet("/GetDate")
public class GetDate extends HttpServlet {
	
	/**
	 *  Get or Post방식이든 둘다 다 처리할때 자동으로 호출되는 메서드
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("get,post 요청시 service()가 처리가능합니다.");
		response.setContentType("text/html;charset=utf-8");//html문서(한글처리)
		//2.PrintWriter클래스->메서드의 반환형을 통해서 얻어오기
		PrintWriter out=response.getWriter();
		out.println("<html><head></head>");//document.write("<html>");
		out.println("<body>");
		//추가
		 request.setCharacterEncoding("utf-8");//한글처리
	     
	     String name=request.getParameter("name");
	     String addr=request.getParameter("addr");
	     out.println("name=>"+name+",addr=>"+addr);
		//--------------------------------------------------------
		out.println("</body>");
	    out.println("</html>");
	}

	/*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	/*
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}*/

}
