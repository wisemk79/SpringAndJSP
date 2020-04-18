package spring3;

//DI -> 내가 원하는 객체를 얻어와서 어디에 저장시킬것인가? (1.멤버변수에 저장<- 1) 생성자를 통해서 멤버변수에저장 2) setter Method 
public class MessageBeanImplDI implements MessageBeanDI{
	private String name1, name2;//생성자를 통해 값을 저장하려고 나눈것 ->constructor-arg
	private String greeting;//setter method를 통해서 값을 저장 -> setter method injection(세터메소드로 주입한다는 의미) 
	
	//1. 생성자 -> 멤버수의 값을 초기화 (Source- Generate Constructor using Fields 를 이용하여 자동생성 
	//<constructor-arg>태그를 이용해서 값을 임의로 지정해서 값을 전달 
	public MessageBeanImplDI(String name1, String name2) {
		super();
		this.name1 = name1;//this.name1="대한민국";
		this.name2 = name2;//this.name2="서울";
		System.out.println("MessageBeanImplDI 생성자 호출됨!");
	}
	
	//has a 관계 
	private OutFile outF;
	
	public void setOutF(OutFile outF) {
		this.outF = outF;
		System.out.println("setOutF(OutFile outF)");
	}
	

	//2.Setter Method=>  xml에  <property>태그가 있다면 세터메소드 사용하는것 
	public void setGreeting(String greeting) {
		this.greeting = greeting;
		System.out.println("setGreeting() 호출됨!");
	}
	
	
	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
		String message = greeting + name1 + "," + name2 + "1";
		System.out.println("message=>" + message);
	
	
	try {
		outF.out(message);
	}catch(Exception e) {
		e.printStackTrace();
	}
	}

}
