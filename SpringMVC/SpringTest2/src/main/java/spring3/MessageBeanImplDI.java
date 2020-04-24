package spring3;

//DI->내가 원하는 객체를 얻어와서 어디에 저장시킬것인가?(1.멤버변수에 저장<-1)생성자 2.Setter Method
public class MessageBeanImplDI implements MessageBeanDI{

	private String name1,name2;//생성자를 통해서 값을 저장->constructor-arg태그를 이용
	private String greeting;//Setter Method를 통해서 값을 저장=>Setter Method injection
	
	//------------has a 관계----------------------------------------------------
	private OutFile outF; //private OutFileImpl outF; 인터페이스형으로 받아옴
	
	public void setOutF(OutFile outF) {
		this.outF = outF;
		System.out.println("setOutF()메서드 호출됨=>"+outF);
	}
	//-----------------------------------------------------------------------------
	//1.생성자->멤버변수의 값을 초기화
	//<constructor-arg>태그를 이용해서 값을 임의로 지정해서 값을 전달
	public MessageBeanImplDI(String name1, String name2) {
		this.name1 = name1;//this.name1="대한민국";
		this.name2 = name2;//this.name2="서울";
		System.out.println("MessageBeanImplDI 생성자 호출됨!");
	}

	//2.Setter Method=><property>태그
	public void setGreeting(String greeting) {
		this.greeting=greeting;
		System.out.println("setGreeting() 호출됨!");
	}
	
	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
		String message=greeting+name1+","+name2+"!";
		System.out.println("message=>"+message);
		//파일에 내용을 출력
		try {
			outF.out(message);//상대방의 객체를 이용해서 메서드호출
		}catch(Exception e) {
			e.printStackTrace();
		}
		//------------------------------------------------------------
	}
}




