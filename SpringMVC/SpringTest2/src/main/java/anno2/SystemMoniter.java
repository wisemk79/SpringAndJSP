package anno2;

import javax.inject.Inject;

//@Autowired기능을 사용하기위해서는 어노테이션과 관련된 클래스 불러온다.
import org.springframework.beans.factory.annotation.Autowired;


//문자를 전송->기간을 정하기(has a 관계)
public class SystemMoniter {

	private long periodTime;//시간
	//has a 관계
	
	//@Autowired를 멤버변수에 사용하면 세터 메소드가 호출되지 않는다. <-- 멤버변수에 선언하게되면 세터메소드 호출 없이 자동적으로 타입을 찾아서 저장한다. 따라서, 세터메소드가 필요없어진다.
	//@Autowired
	/*@Inject를 사용하기위해서는 따로 @Inject에대한 클래스를 메이븐에서 따로 다운로드받아야한다.
	 * <dependency>
			<groupId>javax.inject</groupId>
			<artifactId>javax.inject</artifactId>
			<version>1</version>
		</dependency>
	 * */ 
//	@Inject
	private SmsSender sender;
	
	public void setPeriodTime(long periodTime) {
		this.periodTime = periodTime;
		System.out.println("setPeriodTime()호출됨"+periodTime);
	}
	
	//형식) @키워드(속성1=값, 속성2=값, ....) @Autowired(required=true)<--이게 디폴트임. 유연성있게 객체가 있으면 주입하고 아니면 주입하지말라. 
	//@Autowired => @Inject<-- 비슷한기능인데 요새 사용하는 어노테이션이다. 
//	@Autowired(required=false)
	@Inject
	public void setSender(SmsSender sender) { //byType(SmsSender)을 내부적찾기
		this.sender = sender;
		System.out.println("@Autowired때문에 자동 setSender()호출됨=>"+sender);
	}
	
	public String toString() {
		return "Systemmoniter[periodTime="+periodTime+",sender="+sender+"]";
	}
}




