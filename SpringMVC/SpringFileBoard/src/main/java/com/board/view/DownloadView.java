package com.board.view;

import java.io.*;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;


//다운로드만 따로 처리해줄 전용뷰 클래스
public class DownloadView extends AbstractView {

	public DownloadView() {
		//다운로드 받는 화면으로 전환
		setContentType("application/download");// text/html에서 변경해야 다운로드창이 열림
	}
	//return new ModelAndView("downloadView","downloadFile",downloadFile);
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model,
			                HttpServletRequest request,
			                HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
        //1.다운로드받을 파일의 정보를 얻어오기
		File file=(File)model.get("downloadFile");//전달받은 다운로드 파일 정보
		System.out.println("file=>"+file);
		//다운로드 받을 파일의 타입,크기를 지정->response객체
		response.setContentType(getContentType());//"application/download"
		response.setContentLength((int)file.length());//다운로드 받을 파일의 길이 설정
		//브라우저별로 한글처리->User-Agent(브라우저 정보가 저장된 매개변수명(헤드값))
		String userAgent=request.getHeader("User-Agent");//setHeader(키,값)
		System.out.println("userAgent=>"+userAgent);//MSIE
		boolean ie=userAgent.indexOf("MSIE") > -1; //못찾으면 -1 리턴 찾은경우 > -1
		String fileName=null;
		
		if(ie) {//IE에서 다운로드 받았다면
			fileName=URLEncoder.encode(file.getName(),"utf-8");//1.파일명 2.캐릭터셋
		}else {
			fileName=new String(file.getName().getBytes("utf-8"),"iso-8859-1");//영어
		}
		//대화상자에서 원하는 위치를 다운로드 대화상자에서 지정
		//Content-Disposition->다운로드 받는 위치,"attachment;filename=다운로드 받은 파일명
		//exe,bat=>이진파일도 다운->Content-Transfer-Encoding을 binary로 지정
		response.setHeader("Content-Disposition", "attachment;filename=\""+fileName+"\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		//서버(출력)==>자기 pc(입력)(입출력객체를 만들어서 전송)
		OutputStream out=response.getOutputStream();//new OutputStream()(X)
		FileInputStream fis=null;
		try {
			fis=new FileInputStream(file);
			//서버로부터 파일을 읽어들여서 다운로드 받음->복사
			FileCopyUtils.copy(fis, out);//1.다운로드 받는쪽 입력객체명,2.서버의출력객체명
		}catch(IOException e) {
			e.printStackTrace();
		}finally {//예외처리와 상관없이 항상 처리해야할 기능->메모리 해제(DB연결해제)
			if(fis!=null)
				try {fis.close();}catch(IOException e) {}
		}//finally
		out.flush();//입출력->출력할 양이 될때까지 그대로 버퍼에 보관X->flush()바로바로 출력
	}
}











