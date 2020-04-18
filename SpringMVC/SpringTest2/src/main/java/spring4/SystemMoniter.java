package spring4;


//문자를 전송해줄떄 기간을 정하기(has a 관계) 
public class SystemMoniter {
	
	private long periodTime;//시간 
	//has a 관계 
	private SmsSender sender;

	public void setPeriodTime(long periodTime) {
		this.periodTime = periodTime;
		System.out.println("setPeriodTime(long periodTime) 메서드 호출! =>" + periodTime);
	}

	public void setSender(SmsSender sender) {
		this.sender = sender;
		System.out.println("setSender(SmsSender sender) 메서드 호출!=> " + sender);
	}
	
	public String toString() {
		return ("SystemMoniter[periodTime]=" +periodTime + ", sender=" + sender);
	}
}
