package anno3;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1.xml파일이 여러개 존재하면  배열로 관리하여 ->파일명 부여 ->resource자동인식 
		// 콤마해서 다른 xml을 계속 추가하여 참조 할 수 있다. 
		//String [] configLocation = new String[] {"applicationContext.xml"},{"applicationContext.xml"},{"applicationContext.xml"}
		String [] configLocation = new String[] {"app2.xml"};
		
		//2.xml파일을 읽어들임 -> 메모리 관리까지 처리해주는 객체가 필요 (불러올 배열을 넣어줌 )
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(configLocation);
		
		
		//3.JVM이 종료될 때(클라이언트가 종료될때) context 객체도 같이 메모리 해제 
		context.registerShutdownHook();//어플리케이션이 종료되면 자동으로 해제될 수 있도록 예약하는 메서드이다. 
		
		//4.context -> getBean()을 이용해서 객체를 얻어오면 된다. 
		Camera camera= context.getBean("camera",  Camera.class);
		System.out.println("camera=>" + camera);

		
		//5.JVM이 종료
		context.close();//JVM이 종료시 컨테이너에 존재하는 모든빈(객체)도 종료(메모리해제) 
	}

}
