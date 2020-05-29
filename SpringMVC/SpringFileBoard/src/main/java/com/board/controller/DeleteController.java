package com.board.controller;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.board.dao.BoardDao;
import com.board.domain.BoardCommand;
import com.board.util.FileUtil;
import com.board.validator.BoardDeleteValidator;

@Controller
public class DeleteController {
    //Logger객체=>제대로 입력했는지 체크해서 그 결과를 콘솔에 출력시켜주는 역할하는 객체
	private Logger log=Logger.getLogger(this.getClass());
	
	@Autowired
	private BoardDao boardDao;
	
	//1.글삭제 폼으로 이동(Get방식)
	@RequestMapping(value="/board/delete.do",method=RequestMethod.GET)
	public String form() { //메서드명은 임의로 작성
		System.out.println("데이터값을 삭제받기위해서 form()호출됨");
		return "boardDelete";//<definition name="(boardDelete)이름"
	}
	
	//2.에러메세지가 출력->다시 전에 저장된 값은 초기화->새로 값을 저장(DTO)
	//형식) @ModelAttribute("커맨드객체의 별칭명") 커맨드객체->DTO객체
	@ModelAttribute("com")
	public BoardCommand forBacking() {//형식) 반환형(DTO형) 임의의 메서드명
		System.out.println("다시 암호를 재입력하기위해서 초기화 시킴");
		return new BoardCommand();//BoardCommand bc=new BoardCommand();
	}
	//@RequestMapping("/board/writePro.do")
	//입력을 받을때 (1.DTO객체만 입력->유효성검사X
	//입력을 받을때 (1.DTO객체, 2.BindingResult result->유효성감사 O
	
	@RequestMapping(value="/board/delete.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("com") BoardCommand command,
			                           BindingResult result) { //입력한값에 대한 에러메세지정보
		if(log.isDebugEnabled()) {
			log.debug("BoardCommand=>"+command);//입력받은값을 출력(toString()호출)
			//로그객체명.debug(출력할내용명 및 대상자)
		}
		//유효성 검사 확인
		new BoardDeleteValidator().validate(command, result);//에러메세지를 등록
		//에러정보가 들어있다면
		if(result.hasErrors()) {
			return form();//"boardDelete"->boardDelete.jsp로 이동하라
		}
		
		BoardCommand board=null;
		board=boardDao.selectBoard(command.getSeq());//암호,파일업로드부분까지 고려
		//비밀번호 체크
		if(!board.getPwd().contentEquals(command.getPwd())) {
			result.rejectValue("pwd", "invalidPassword");
			return form();//boardDelete.jsp로 이동
		}else {//비밀번호가 일치한다면
			boardDao.delete(command.getSeq());//실제 DB상의 데이터 삭제
			//업로드한 파일까지 삭제
			if(board.getFilename()!=null) {//업로드된 파일이 존재한다면
				FileUtil.removeFile(board.getFilename());
			}
		}
		//글쓰기 성공하고나서 return "redirect:요청명령어"<--return "이동할 페이지명";
		return "redirect:/board/list.do"; //ListController->boardList.jsp로 이
	}
}





