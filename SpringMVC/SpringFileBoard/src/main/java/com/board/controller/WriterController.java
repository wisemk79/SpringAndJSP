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
import com.board.validator.BoardValidator;

@Controller
public class WriterController {
    //Logger객체=>제대로 입력했는지 체크해서 그 결과를 콘솔에 출력시켜주는 역할하는 객체
	private Logger log=Logger.getLogger(this.getClass());
	
	@Autowired
	private BoardDao boardDao;
	/*
	 * 요청명령어-->하나의 컨트롤러만 작성
	 * 하나의 컨트롤러->서로 관련이 있는 여러개의 요청명령어를 통합해서 하나의 컨트롤러에 작성이 가능
	 * ex) 글쓰기(글쓰기 폼이동->데이터저장),글수정하기(수정폼 이동->데이터저장),
	 *                 하나의 요청명령어->Get->Post방식으로 구분해서 호출이 가능
	 *      글삭제하기(암호->확인->저장)
	 *      관련이 있는 요청명령어->1)각각 따로 요청명령어를 구분해서 호출
	 *                                    2)요청명령어는 같게 설정하고 
	 *                                        method=RequestMethod.GET과 POST로 구분작성
	 */
	//1.글쓰기 폼으로 이동(Get방식)
	//@RequestMapping("/board/write.do") ->각자 요청명령어를 다르게 주는 경우
	@RequestMapping(value="/board/write.do",method=RequestMethod.GET)
	public String form() { //메서드명은 임의로 작성
		System.out.println("데이터값을 입력받기위해서 form()호출됨");
		return "boardWrite";//<definition name="(boardWrite)이름"
	}
	
	//2.에러메세지가 출력->다시 전에 저장된 값은 초기화->새로 값을 저장(DTO)
	//형식) @ModelAttribute("커맨드객체의 별칭명") 커맨드객체->DTO객체
	@ModelAttribute("com")
	public BoardCommand forBacking() {//형식) 반환형(DTO형) 임의의 메서드명
		System.out.println("forBacking() 호출됨!");
		return new BoardCommand();//BoardCommand bc=new BoardCommand();
	}
	//@RequestMapping("/board/writePro.do")
	//입력을 받을때 (1.DTO객체만 입력->유효성검사X
	//입력을 받을때 (1.DTO객체, 2.BindingResult result->유효성감사 O
	
	@RequestMapping(value="/board/write.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("com") BoardCommand command,
			                           BindingResult result) { //입력한값에 대한 에러메세지정보
		if(log.isDebugEnabled()) {
			log.debug("BoardCommand=>"+command);//입력받은값을 출력(toString()호출)
			//로그객체명.debug(출력할내용명 및 대상자)
		}
		//유효성 검사 확인
		new BoardValidator().validate(command, result);//에러메세지를 등록
		//에러정보가 들어있다면
		if(result.hasErrors()) {
			return form();//"boardWrite"->boardWrite.jsp로 이동하라
		}
		//에러정보가 없으면 정상적으로 데이터를 테이블에 저장->파일업로드->업로드위치에 파일전송
		try {
			String newName="";//업로드한 파일의 변경된 파일명을 저장
			//업로드가 되어있다면
			if(!command.getUpload().isEmpty()) {
				//탐색기에서 선택한 파일이름->getOriginalFileName();
				newName=FileUtil.rename(command.getUpload().getOriginalFilename());
				System.out.println("newName=>"+newName);
				//DTO에도 바뀐이름 저장->테이블에도 바뀐이름 저장
				command.setFilename(newName);//null->업로드가 안된상태
			}
			//최대값+1
			int newSeq=boardDao.getNewSeq()+1;//2
			System.out.println("newSeq=>"+newSeq);//1->2
			//게시물번호=>계산->DTO에 저장
		    command.setSeq(newSeq);//1->2로 저장
			boardDao.insert(command);//테이블에 저장
			//실제로 upload폴더로 업롣한 파일을 전송(복사)
			if(!command.getUpload().isEmpty()) {
				File file=new File(FileUtil.UPLOAD_PATH+"/"+newName);
				//물리적으로 데이터전송(파일전송)
				command.getUpload().transferTo(file);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}catch(Exception e2) {
			e2.printStackTrace();
		}
		//글쓰기 성공하고나서 return "redirect:요청명령어"<--return "이동할 페이지명";
		return "redirect:/board/list.do"; //ListController->boardList.jsp로 이동
		//return "redirect:/board/write.do";//글쓰기폼으로 이동
	}
}




