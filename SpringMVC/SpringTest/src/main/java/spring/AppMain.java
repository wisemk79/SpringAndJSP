package spring;

public class AppMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//팀병로 작성=> 클래스가 여러개 -> has a 관계로 연결 
		// 내부분을 수정하게되면, -> 다른사람의 내용도 수정해야된다. => 개발시간이 늘어난다.
		//그렇기에 스프링에선 이 객체를 xml에서 설정해주어 new로 직접 생성하지 않는 방법으로 불러와 개발시간을 줄인다.
		//Message1 me = new Message1();//메서드 호출목적 
		Message2 me = new Message2();
		me.sayHello("홍길동");
	}

}
