

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Notice
 */
@WebServlet("/Notice")
public class Notice extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");//한글처리
		PrintWriter out=response.getWriter();
		out.println("<html><head><title>공지사항</title></head>");
		out.println("<body>");
		//notice->2020218.txt
		Calendar cal=Calendar.getInstance();//Date d=new Date();
		String fileName="";//불러올 파일명을 저장
		fileName+=cal.get(Calendar.YEAR);//2020
		fileName+=cal.get(Calendar.MONTH)+1;//0~11+1=>1~12=>20202
		fileName+=cal.get(Calendar.DATE);//18->윤년도 자동계산->2020218
		fileName+=".txt";//2020218.txt
		
		//경로는 절대경로
		String realPath="C:/webtest/4.jsp/sou/ServletTest/WebContent/notice/"+fileName;
		System.out.println("realpath=>"+realPath);
		try {
			//FileInputStream(영문) or FileReader(한글)
			BufferedReader br=new BufferedReader(new FileReader(realPath));
			String line="";//한줄씩 읽어들여서 저장할 변수
			
			while((line=br.readLine())!=null) {//더이상 읽어들일 수 없을때까지
				out.println(line+"<br>");//클라이언트의 브라우저로 전송
			}
			br.close();
		}catch(IOException e) {
			System.out.println("불러올 파일의 경로와 파일명을 확인하세요=>"+e);//e.toString()
		}catch(Exception e) {
			System.out.println("오늘 공지사항이 없습니다."+e);
		}
		//---------------------------------
		out.println("<p align=center>");
		out.println("<hr>");
		out.println("<input type='submit' value='창닫기' onclick='window.close()'> ");
		out.println("</body></html>");
	}
}








