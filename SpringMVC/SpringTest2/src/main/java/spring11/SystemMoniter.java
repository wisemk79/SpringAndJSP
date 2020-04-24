package spring11;

//문자를 전송->기간을 정하기(has a 관계)
public class SystemMoniter {

	private long periodTime;//시간
	//has a 관계
	private SmsSender sender;
	
	public void setPeriodTime(long periodTime) {
		this.periodTime = periodTime;
		System.out.println("setPeriodTime()호출됨"+periodTime);
	}
	public void setSender(SmsSender sender) {
		this.sender = sender;
		System.out.println("setSender()호출됨=>"+sender);
	}
	
	public String toString() {
		return "Systemmoniter[periodTime="+periodTime+",sender="+sender+"]";
	}
}




