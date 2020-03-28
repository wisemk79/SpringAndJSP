package com.javalec.ex;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontCon
 */

//.do로 맵핑해줘서 do에 대한 요청은 전부 이 서블릿에서 처리한다.
@WebServlet("*.do")
public class FrontCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontCon() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet");
		actionDo(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost");
		actionDo(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("actionDo");
		
		String uri= request.getRequestURI();
		System.out.println("uri: " + uri);///15.frontController/update.do
		String conPath = request.getContextPath();
		System.out.println(conPath);//15.frontController
		String command = uri.substring(conPath.length());//conPath의 길이만큼 자른다.
		
		
		if(command.equals("/insert.do")) {
			System.out.println("insert");
			System.out.println("------------------");
		}else if(command.equals("/update.do")) {
			System.out.println("update");
			System.out.println("------------------");
		}else if(command.equals("/select.do")) {
			System.out.println("select");
			System.out.println("------------------");
		}else if(command.equals("/delete.do")) {
			System.out.println("delete");
			System.out.println("------------------");
		}
	}
	
	

}