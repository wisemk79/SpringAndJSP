package spring1;

public class AppMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//팀별로 작성=>클래스가 여러개->has a 관계로 연결
		// 수정O ->다른 사람의 내용 수정=>수정=>개발시간 늘어난다.
        //Message1 me=new Message1();//메서드 호출목적
		Message2 me=new Message2();
        me.sayHello("홍길동");
	}

}
