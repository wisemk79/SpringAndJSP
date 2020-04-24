package spring2;

//사용자로부터 값을 입력->출력->클래스 이름은 다른데 메서드의 기능 같다
public class Message2 implements MessageInter{

	@Override
	public void sayHello(String name) {
		// TODO Auto-generated method stub
		System.out.println("반가워요"+name+"님!");
	}
}
