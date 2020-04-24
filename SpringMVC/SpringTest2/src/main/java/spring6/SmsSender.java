package spring6;

//문자전송 시스템
public class SmsSender {
	//--문자가 제대로 전달됐는지 체크할 멤버변수 선언
	boolean flag;
	
	//constructor-arg이용
	public SmsSender(boolean flag) {
		this.flag=flag;
	}
	//----------------------------------------
	public String toString() {
		return "SmsSender 호출";
	}
}
