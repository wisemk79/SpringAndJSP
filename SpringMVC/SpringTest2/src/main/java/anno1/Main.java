package anno1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //1.xml파일이 여러개 존재=>배열로 관리->파일명부여=>resource 자동인식
		String [] configLocation=new String[] {"app2.xml"};
		
		//2.xml파일을 읽어들임->메모리 관리까지 처리해주는 객체가 필요
		AbstractApplicationContext context=
				          new ClassPathXmlApplicationContext(configLocation);
		
		//3.JVM이 종료될때 context객체도 같이 메모리해제
		context.registerShutdownHook();
		
		//4.context->getBean()를 이용해서 객체 얻어오면 된다.
		Camera camera=context.getBean("camera",Camera.class);
		System.out.println("camera=>"+camera);//moniter.toString()
		
		//5.JVM이 종료
		context.close();//JVM이 종료시 컨터이너에 존재하는 모든 빈(객체)도 종료(메모리 해제)
	}

}



