package com.javalec.ex;

import java.io.IOException;
import java.io.*;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontCon
 */
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
		actionDo(request, response);
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
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());
		try {
		if(command.equals("/membersAll.do")) {
			System.out.println("들어옴 ");
			response.setContentType("text/html; charset=EUC-KR");
			PrintWriter writer = response.getWriter();
			writer.println("<html><head></head><body>");
			
			//dao에 있는 membersAll() 메소드를 사용하겠다고 선언 
			Service service = new MembersAllService();
			//dtos 어레이리스트에 위의 메소드를 실행한다. 
			ArrayList<MemberDto> dtos = service.execute(request, response);
			
			for(int i=0; i < dtos.size(); i++) {
				System.out.println("실행");
				MemberDto dto = dtos.get(i);
				String id = dto.getId();
				String pw = dto.getPw();
				String name = dto.getName();
				String eMail = dto.geteMail();
				Timestamp rDate = dto.getrDate();
				String address = dto.getAddress();
				
				writer.println(id + "," + pw + "," + name + "," + eMail + "," + rDate.toLocalDateTime() + "," + address);
			}
			
			writer.println("</body></html>");
		}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
	

}
