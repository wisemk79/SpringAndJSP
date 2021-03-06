package spring10;

//byType,byName을 이용할 예제

public class SystemMoniter {
    //has a 관계 byType(DL)->PhoneCall과 같은 자료형의 객체를찾아서 멤버변수에 저장
	/* (1) byType
	private PhoneCall call;   
	
	//DI(의존객체를 넣어주는 방법->Setter Injection 방법을 사용)
	public void setCall(PhoneCall call) {
		this.call = call;
		System.out.println("setCall()호출(call)=>"+call);
	}
	*/
	//(2)byName->멤버변수의 이름과 동일한 이름을 찾아서 객체를 넣어주는 기법
	private PhoneCall phonecall;//

	public void setPhonecall(PhoneCall phonecall) {
		this.phonecall = phonecall;
		System.out.println("setPhonecall()호출(phonecall)=>"+phonecall);
	}

	public String toString() {
		return "Systemmoniter[phonecall="+phonecall+"]";
	}
}




