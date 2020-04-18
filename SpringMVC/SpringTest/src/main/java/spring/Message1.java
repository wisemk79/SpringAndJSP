package spring;


//사용자로부터 값을 입력 -> 출력 
public class Message1 {
	
	
	//이 함수를 호출할려면 다른 클래스에서 Message1객체를 new로 생성해야된다....
	public void sayHello(String name) {//객체를 생성 => 호출가능 
		System.out.println("안녕!"+name+ "씨!");
	}
}
