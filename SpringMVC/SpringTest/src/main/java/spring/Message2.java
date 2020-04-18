package spring;


//사용자로부터 값을 입력 -> 출력 -> 클래스 이름은 다른데 메서드의 기능이 같다. 
public class Message2 {
	
	
	//이 함수를 호출할려면 다른 클래스에서 Message1객체를 new로 생성해야된다....
	public void sayHello(String name) {//객체를 생성 => 호출가능 
		System.out.println("반가워요!"+name+ "님!");//메세지가 Message1과 다르다 
	}
}
