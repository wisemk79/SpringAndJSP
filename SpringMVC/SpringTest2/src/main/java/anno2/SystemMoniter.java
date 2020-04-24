package anno2;

import javax.inject.Inject;//pom.xml에서 등록

//@Autowired기능을 사용하기위해서는 어노테이션과 관련된 클래스 불러온다.
import org.springframework.beans.factory.annotation.Autowired;

//문자를 전송->기간을 정하기(has a 관계)
public class SystemMoniter {

	private long periodTime;//시간
	//has a 관계
	
	//@Autowired
	//@Inject
	private SmsSender sender;
	
	public void setPeriodTime(long periodTime) {
		this.periodTime = periodTime;
		System.out.println("setPeriodTime()호출됨"+periodTime);
	}
	
	
	//@Autowired(required=true)
	@Inject
	public void setSender(SmsSender sender) { //byType(SmsSender)을 내부적찾기
		this.sender = sender;
		System.out.println("@Inject 때문에 자동 setSender()호출됨=>"+sender);
	}
	
	public String toString() {
		return "Systemmoniter[periodTime="+periodTime+",sender="+sender+"]";
	}
}




