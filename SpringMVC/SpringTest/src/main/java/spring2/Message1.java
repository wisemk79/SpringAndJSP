package spring2;


//사용자로부터 값을 입력 -> 출력 
public class Message1 implements MessageInter{
	
	@Override
	public void sayHello(String name) { 
		System.out.println("안녕!"+name+ "씨!");
	}
	
	
	
}
