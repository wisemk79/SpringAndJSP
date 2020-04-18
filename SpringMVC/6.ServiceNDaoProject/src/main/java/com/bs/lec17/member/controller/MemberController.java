package com.bs.lec17.member.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bs.lec17.member.Member;
import com.bs.lec17.member.service.MemberService;

@Controller
//@RequestMapping(value="/member")
public class MemberController {

//	MemberService service = new MemberService();
//	@Autowired
	@Resource(name="memService")
	MemberService service;
	//만약 클래스 맨 상단에 맵핑을 위처럼 추가한다면, 맵핑 경로는 /member/memJoin 이 될것이다.
	//이 예제에서는 memJoin.html에서 post방식으로 action에 /lec17/memJoin라는 패스로 설정해주어 이 컨트롤러가 작동하게된다.
	@RequestMapping(value="/memJoin", method=RequestMethod.POST)
	public String memJoin(Model model, HttpServletRequest request) {
		//여기서 매개변수로 받은 모델 객체는 view로 데이터를 전달해주는 역할을 수행한다.
		
		/*폼태그로부터 전달받은 값을 각 변수에 넣어준다.
		 * HttpServletRequest request를 이용하는경우 request.getParameter를이용하여 스트링으로 값을 받게된다.
		 * */
		String memId = request.getParameter("memId");//이것은 HttpServletRequest request을이용하지 않는경우 HttpServletRequest reques를 지우고 어노테이션으로 바꿔서 사용이 가능하다.
		String memPw = request.getParameter("memPw");//public String memJoin(Model model, @RequestParam("memId") String memId,@RequestParam("memPw") String memPw)<--이런식으
		String memMail = request.getParameter("memMail");//만약 @RequestParam(value="memId", required="true, defaultValue="1234") String memId
		String memPhone1 = request.getParameter("memPhone1");// 위처럼 하게되면 변수에 값이 없는경우 에러를 발생하며, false인 경우 에러를 발생하지 않는다.
		String memPhone2 = request.getParameter("memPhone2");//defaultValue를 주게되면 값이 없을때 고정값을 지정할 수 있다.
		String memPhone3 = request.getParameter("memPhone3");
		
		/*만약, 위와같이 하고싶지 않다면 다른 방법이 있는데 dto(member.java)객체를 이용하는방법이있다.
		 * 	@RequestMapping(value="/memJoin", method=RequestMethod.POST)
				public String memJoin(Member member) { 이런식으로 매개변수로 멤버 클래스 객체를 주면 멤버클래스의 세터를 이용해 들어온값들을 각 매개변수에 세팅해준다.
				
				그리고 멤버 레지스터 디비에 값을 넣어주기 위해 게터를 이용하여 값을 넣어준다. 
				service.memberRegister(member.getMemId(), member.getMemPw(), member.getMemMail(), member.getMemPhone1(), member.getMemPhone2(), member.getMemPhone3());
				
				이렇게하면 모델에 어트리뷰트를 추가하는 작업이 필요없어지고, 
				
				JoinOk.jsp에서
					<h1> memJoinOk </h1>
					ID : ${member.memId}<br />  member.memId 앞에 member.으로 게터메서드로 접근하여 직접 jsp에서 값을 가져올 수 있게된다.
					PW : ${member.memPw}<br />
					Mail : ${member.memMail} <br />
					Phone : ${member.memPhone} <br />
		 * */
		
		//서비스 객체에서 멤버 레지스터 메소드를 통해 데이터 값을 적재한다. 
		service.memberRegister(memId, memPw, memMail, memPhone1, memPhone2, memPhone3);
		
		//데이터값을 jsp에 전달하도록 set해준다.
		model.addAttribute("memId", memId);
		model.addAttribute("memPw", memPw);
		model.addAttribute("memMail", memMail);
		model.addAttribute("memPhone", memPhone1 + " - " + memPhone2 + " - " + memPhone3);
		
		return "memJoinOk";//회원가입이 완료되면 memJoinOk로 이동하여 값을 전달한다
	}
	
	@RequestMapping(value="/memLogin", method=RequestMethod.POST)
	public String memLogin(Model model, HttpServletRequest request) {
		
		String memId = request.getParameter("memId");
		String memPw = request.getParameter("memPw");
		
		//서비스객체에서 memberSearch메서드를 이용하여 회원의 정보를 검색한다.
		Member member = service.memberSearch(memId, memPw);
		
		try {
			//회원정보에서 필요한 id와 pw를 추출하기위해 getter메서드를 이용하여 추출한후 모델객체에 각각의 키값으로 넣어준다.
			model.addAttribute("memId", member.getMemId());
			model.addAttribute("memPw", member.getMemPw());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//로그인이 완료되면 memLoginOk로 보낸다.		
		return "memLoginOk";
	}
	
}