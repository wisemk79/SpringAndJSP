package com.bs.lec20.member;


//command 객체로 데이터객체를 의미하는데 이것의 매개변수 이름에 따라간다.
//예를들어 컨트롤러에 이객체를 매개변수로주고, input 태그로 회원가입 정보를 받게되면,
//회원가입 input태그 name속성값을 command객체의 멤버변수이름에 맞춰주면 그에맞춰 세터메소드가 실행되어 멤버 변수에 저장되고,
//그것을 컨트롤러에서 el태그로 사용할 수 있게된다.
public class Member {
	
	private String memId;
	private String memPw;
	private String memMail;
	
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemPw() {
		return memPw;
	}
	public void setMemPw(String memPw) {
		this.memPw = memPw;
	}
	public String getMemMail() {
		return memMail;
	}
	public void setMemMail(String memMail) {
		this.memMail = memMail;
	}
}