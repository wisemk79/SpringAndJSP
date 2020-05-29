package com.board.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;//로그클래스를 불러오는 import구문
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.board.dao.BoardDao;
import com.board.domain.BoardCommand;
import com.board.util.PagingUtil;

//추가 관련된 클래스를 불러오기

@Controller
public class ListController {

	//#{start},#{end}->값이 제대로 전달되는지 확인X=>확인하고 싶다.->로그객체를 생성->출력
	//Logger.getLogger(로그객체의 대상이 되는 클래스명.class)
	//private Logger log=Logger.getLogger(ListController.class);
	private Logger log=Logger.getLogger(this.getClass());//현재 클래스명이름을 가져옴
	
	@Autowired
	private BoardDao boardDao;//Setter Method를 호출X->byType
	
	@RequestMapping("/board/list.do")
	public ModelAndView process
	    (@RequestParam(value="pageNum",defaultValue="1") int currentPage,
	     @RequestParam(value="keyField",defaultValue="") String keyField,
	     @RequestParam(value="keyWord",defaultValue="") String keyWord) {
		
		if(log.isDebugEnabled()) {// 로그객체가 디버깅 모드 상태인지 아닌지를 체크
			                                   //디버깅 모드상태->매개변수를 확인->출력하라
			log.debug("currentPage=>"+currentPage);
			log.debug("keyField=>"+keyField);
			log.debug("keyWord=>"+keyWord);
		}
		//검색분야,검색어를 전달->parameterType="map"-><select id="~" 
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("keyField",keyField);//${keyField} 검색분야=>map.get(키명)->#{keyField}
		map.put("keyWord", keyWord);//검색어
		//총레코드수 또는 검색된 글의 총레코드수
		int count=boardDao.getRowCount(map);//map.get(키명)->#{keyField}
		//페이징처리 1.현재페이지 2총레코드수 3.페이지당 게시물수, 4.블럭당 페이지수 5.요청명령어
		PagingUtil page=new PagingUtil(currentPage,count,3,3,"list.do");
		//start=>페이지당 맨 첫번째 나오는 게시물번호
		map.put("start", page.getStartCount());//<->map.get("start")=>#{start}
		map.put("end", page.getEndCount());
		
		List<BoardCommand> list=null;//검색된 레코드를 담을 객체선언
		if(count > 0) {
			list=boardDao.list(map);//keyField,keyWord,start,end전달
		}else {
			list=Collections.emptyList();//0개 적용
		}
		System.out.println("count=>"+count);
		ModelAndView mav=new ModelAndView("boardList");//이동할 페이지명
		mav.addObject("count",count);//총레코드수 ->${count}
		mav.addObject("list",list);
		mav.addObject("pagingHtml",page.getPagingHtml());//링크문자열 전달받음
		
		return mav;
	}
}



