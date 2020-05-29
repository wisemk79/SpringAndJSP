package com.board.controller;

import java.io.File;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.board.dao.BoardDao;
import com.board.domain.BoardCommand;
import com.board.util.FileUtil;
import com.board.util.StringUtil;

@Controller
public class DetailController {

	//로그객체 생성
	private Logger log=Logger.getLogger(getClass());
	
	@Autowired
	private BoardDao boardDao; //byType을 이용해서 객체를 자동넣어준다.
	
	//  /board/detail.do?seq=4->boardView.jsp
	@RequestMapping("/board/detail.do")
	public ModelAndView process(@RequestParam("seq") int seq) {
		if(log.isDebugEnabled()) { //src/main/java->log4j.xml이 존재->환경설정이 된 상태
			log.debug("seq=>"+seq);//System.out.println("seq=>"+seq);
		}
		//1.조회수를 증가
		boardDao.updateHit(seq);//int->Integer
		//2.seq에 해당되는 레코드 얻기
		BoardCommand board=boardDao.selectBoard(seq);//int->Integer
		//글내용=>aaaa\r\n=>저장-><pre></pre>
		board.setContent(StringUtil.parseBr(board.getContent()));// \r\n-><br>로 변환
		//boardView.jsp에 출력-><%=board.getContent()%> or ${board.content}
		/*
		ModelAndView mav=new ModelAndView("boardView");//setViewName(페이지)
		mav.addObject("board",board);// ${board}
		return mav;
		 //1.이동할 페이지명,2.전달할 키명 3,전달할값
		*/
		return new ModelAndView("boardView","board",board);		
	}
	//글상세보기와 연관(다운로드)
	@RequestMapping("/board/file.do")
	public ModelAndView download(@RequestParam("filename") String filename) {
		//1.다운로드 받을 파일의 위치와 이름을 알아야 된다.
		File downloadFile=new File(FileUtil.UPLOAD_PATH+"/"+filename);
		//2.스프링에서 다운로드 받을 뷰를 따로 작성->AbstractView를 상속받아서 전용뷰작성
		//1.다운로드받을 뷰객체 2.모델객체명(키명)  3.전달할값(다운로드 받을 파일객체)
		return new ModelAndView("downloadView","downloadFile",downloadFile);
	}

}













