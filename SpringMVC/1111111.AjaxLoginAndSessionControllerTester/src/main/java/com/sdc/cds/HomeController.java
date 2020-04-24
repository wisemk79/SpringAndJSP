package com.sdc.cds;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	
	//로그인시 세션 생성
	@ResponseBody
//	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/api/mlogin/p_login", method = RequestMethod.POST)
	public Map<String, Object> memLogin( HttpSession session, @RequestBody HashMap<String, Object> map) {
		System.out.println("로그인 실행");
		System.out.println(map);
		System.out.println(map.get("mem_id") + ", " + map.get("mem_pw"));
		String reqId = (String)map.get("mem_id");
		String reqPw = (String)map.get("mem_pw");
		String id = "abcde";
		String pw = "1234";
		Map<String, Object> responseData = new HashMap<String, Object>();
		
		if(reqId.equals(id) && reqPw.equals(pw)) {
			session.setAttribute("member", map.get("mem_id"));
			responseData.put("mem_id", map.get("mem_id"));
			responseData.put("mem_pw", map.get("mem_pw"));
			responseData.put("mem_name", "victolee");
			responseData.put("isLogged", true);
		}else {
			responseData.put("isLogged", false);
		}
		
		//member  ddd 라는 유저의 세션값 생성
//		session.setAttribute("member", "dddd");
		
		//임의로 json으로 응답한데이터 
		
//		responseData.put("name", "victolee");
//		responseData.put("age", 26);
//		responseData.put("isLogged", true);
		
		
		return responseData;
		//ajax콜을 하면 세션 생성시 자동으로 ajax request header에 세션값을 담아서 클라이언트에 자동으로 저장한다.
		
	}
	
	
	@ResponseBody
//	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/api/mlogin/p_logout", method = RequestMethod.GET)
	public Map<String, Object> memLogout( HttpSession session) {
		System.out.println("로그아웃 실행");
		Map<String, Object> responseData = new HashMap<String, Object>();
		
		final String id1="abcde";
		final String id2="efghi";
		
		//세션에있는 속성이름들을 가져온다.
		Enumeration se = session.getAttributeNames();
		System.out.println(se.hasMoreElements());//
		while(se.hasMoreElements()){
			String getse = se.nextElement()+"";
			//세션이름을 출력한다. <--아마 이 세션이름으로 유저정보를 추출할 수 있을거라 추측됨.
			
			System.out.println("@@@@@@@ session : "+getse+" : "+session.getAttribute(getse));
			session.removeAttribute((String)getse);
			System.out.println("세션 삭제");
		}
		
		System.out.println(se.hasMoreElements());
		if(!se.hasMoreElements()) {
			System.out.println("세션 없음");
			responseData.put("SESSION", "NO");
			responseData.put("isLogged", false);
		}
		
		responseData.put("logout", "OK");
		
		
		return responseData;
		//ajax콜을 하면 세션 생성시 자동으로 ajax request header에 세션값을 담아서 클라이언트에 자동으로 저장한다.
		
	}
	
	/* 세션 체크 요청
	 * 클라이언트에서 ajax get요청을 할때 withCredentials:true로 ajax call 요청을하면
	 * 아까 로그인시 받았던 세션 값을 자동으로 request header에 담아서 아래의 session 컨트롤러에 반환해준다.
	 * 
	 * ajax요청은 아래와 같이 한다.
	 *  
	 * $.ajax({

        url: api_server + '/api/datakey',

        type: 'GET',

        dataType: 'json',

        crossDomain: true,

        contentType: "application/x-www-form-urlencoded; charset=utf-8",

        xhrFields: {

          withCredentials: true

        },

        success: function(data) {

        },

        error: function(jqXHR, textStatus, errorThrown)

        {

          console.log(jqXHR,textStatus,errorThrown);

        }

      })
	 * */
	@ResponseBody
//	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/api/mlogin/session", method = RequestMethod.GET)
	public Map<String, Object> SessionCheck( HttpSession session) {
		System.out.println("세션 체크 실행");
		Map<String, Object> responseData = new HashMap<String, Object>();
		
		final String id1="abcde";
		final String id2="efghi";
		
		
		Map<String, Object> sendjson = new HashMap<String, Object>();
		//세션에있는 속성이름들을 가져온다.
		Enumeration se = session.getAttributeNames();
		System.out.println("세션확인1=> " + se.hasMoreElements());//
		Boolean sessionExistCheck = se.hasMoreElements();
		while(se.hasMoreElements()){
			System.out.println("와일문 실행");
			String getse = se.nextElement()+"";
			//세션이름을 출력한다. <--아마 이 세션이름으로 유저정보를 추출할 수 있을거라 추측됨.
			
			System.out.println("@@@@@@@ session : "+getse+" : "+session.getAttribute(getse));
			switch((String)session.getAttribute(getse)){
				case id1:
					System.out.println("스위치문 실행 id1");
					responseData.put("mem_id", (String)session.getAttribute(getse));
					responseData.put("mem_pw", "1234");
					responseData.put("mem_name", "victolee");
					responseData.put("mem_tel", "01021312123");
					responseData.put("mem_email", "avds@dsfa.com");
					sendjson.put("mem", responseData);
					sendjson.put("isLogged", true);
					break;
				case id2:
					System.out.println("스위치문 실행 id2");
					responseData.put("mem_id", (String)session.getAttribute(getse));
					responseData.put("mem_pw", "43534");
					responseData.put("mem_name", "jason");
					responseData.put("mem_tel", "01032435435");
					responseData.put("mem_email", "dsdcs@scdcd.com");
					sendjson.put("mem", responseData);
					sendjson.put("isLogged", true);
					break;
			}
			
			/*	
			 	- 결과값
				세션 체크 실행
				@@@@@@@ session : member : dddd
			 * */
		}
		
		
		
		System.out.println("세션확인2=>"+ sessionExistCheck);
		if(!sessionExistCheck) {
			System.out.println("세션확인2실행");
			sendjson.put("SESSION", "NO");
			sendjson.put("isLogged", false);
		}
		
		
		
		
		
		return sendjson;
	}
	
	
	@ResponseBody
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/api/qna/qlist", method = RequestMethod.GET)
	public List<Object> QNALIST( HttpSession session) {
		System.out.println("세션 체크 실행");
		List<Object> list = new ArrayList<Object>();
		
		
		for(int i = 0; i < 10; i++) {
			Map<String, Object> responseData = new HashMap<String, Object>();
			responseData.put("qna_id", "2");
			responseData.put("qna_category", "[기타문의]");
			responseData.put("qna_subject", "기타문의 테스트");
			responseData.put("qna_content", "기타문의 테스트 내용이라");
			responseData.put("mem_id", "bread");
			responseData.put("qna_regdate", "2020-03-18");
			responseData.put("reply_content", "[cdscdscsdcs]");
			
			
			list.add(responseData);
		}
		
		
		
		return list;
	}
	
}
