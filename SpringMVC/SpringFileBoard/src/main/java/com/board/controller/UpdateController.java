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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.board.dao.BoardDao;
import com.board.domain.BoardCommand;
import com.board.util.FileUtil;
import com.board.validator.BoardValidator;

@Controller
public class UpdateController {
    //Logger객체=>제대로 입력했는지 체크해서 그 결과를 콘솔에 출력시켜주는 역할하는 객체
	private Logger log=Logger.getLogger(this.getClass());
	
	private BoardDao boardDao;
	
	@Autowired
	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
		System.out.println("UpdateController의 setBoardDao호출됨!");
	}

	//1.글수정 폼으로 이동(Get방식) /board/update.do?seq=4
	@RequestMapping(value="/board/update.do",method=RequestMethod.GET)
	public ModelAndView form(@RequestParam("seq") int seq) { //메서드명은 임의로 작성
		System.out.println("데이터값을 수정 받기위해서 form()호출됨");
		BoardCommand boardCommand=boardDao.selectBoard(seq);
		//1.이동할 페이지명 2.전달할키명  3.전달할값
		return new ModelAndView("boardModify","command",boardCommand);
	}
	
	//수정
	@RequestMapping(value="/board/update.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("command") BoardCommand command,
			                           BindingResult result) { //입력한값에 대한 에러메세지정보
		if(log.isDebugEnabled()) {
			log.debug("BoardCommand=>"+command);//수정받은값을 출력(toString()호출)
			//로그객체명.debug(출력할내용명 및 대상자)
		}
		//유효성 검사 확인=>command값을 조사->문제발생->문제발생정보->result에러객체에 저장
		new BoardValidator().validate(command, result);//에러메세지를 등록
		//에러정보가 들어있다면
		if(result.hasErrors()) {
			return "boardModify";//->boardModify.jsp로 이동하라
		}
		//변경전의 데이터를 불러오기->board(비밀번호)=웹상에서의 입력비밀번호
		BoardCommand board=null;
		String oldFileName="";
		board=boardDao.selectBoard(command.getSeq());
		//비밀번호 체크(DB상의 암호!=웹상에서 입력한 암호)
		if(!board.getPwd().equals(command.getPwd())) { //비밀번호가 맞지 않다면
			//1.적용필드 2.적용필드에 해당되는 에러코드키명
			result.rejectValue("pwd", "invalidPassword");
			return "boardModify";//암호가 틀리면 다시 수정을 입력받아야되기때문에 전페이지로 이동
		}else { //비밀번호가 맞다면
		    /* 업로드가 이미 된 파일의 경우
		     * 기본파일명->업로드된 파일이 존재->기존 파일 삭제->새로 업로드(새로운 파일명이 생성)
		     * 업로드된 파일이 없으면 ->기존파일은 덮어쓰기->새로 업로드 하지 않은 경우
		     */
			oldFileName=board.getFilename();//DB상의 원래 기존파일명을 불러와서 저장
			if(!command.getUpload().isEmpty()) {
				try {
					//새로 업로드한 파일명을 DB에 저장하기위해서 Setter Method에 저장
					command.setFilename(FileUtil.rename
							                         (command.getUpload().getOriginalFilename()));
				}catch(Exception e) {e.printStackTrace();}
			}else {//새로 업로드하지 않고 기존에 업로드된 파일명을 그대로 사용하는 경우
				   command.setFilename(oldFileName);
			}
		
		   //수정메서드 호출
			boardDao.update(command);
		  //실제로 새로 바뀐 파일을 upload폴더로 전송
			if(!command.getUpload().isEmpty()) {
				try {
					File file=new File(FileUtil.UPLOAD_PATH+"/"+command.getFilename());
					//물리적으로 데이터전송(파일 전송)
					command.getUpload().transferTo(file);//FileUtil.UPLOAD_PATH로 복사해서 전송
				}catch(IOException e) {
					e.printStackTrace();
				}catch(Exception e) {
					e.printStackTrace();
				}
				//기존에 이미 업로드된 파일은 삭제->bbb.jpg(old)->삭제->aaa.jpg(new)
				if(oldFileName!=null) {
					FileUtil.removeFile(oldFileName);
				}
			}//if(!command.getUpload().isEmpty()) {
		}//else(암호가 맞다면)
		return "redirect:/board/list.do"; //ListController->boardList.jsp로 이동
	}
}




