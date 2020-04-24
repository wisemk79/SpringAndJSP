package spring7;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //1.xml파일이 여러개 존재=>배열로 관리->파일명부여=>resource 자동인식
		String [] configLocation=new String[] {"applicationContext.xml"};
		
		//2.xml파일을 읽어들임->메모리 관리까지 처리해주는 객체가 필요
		AbstractApplicationContext context=
				          new ClassPathXmlApplicationContext(configLocation);
		
		//3.JVM이 종료될때 context객체도 같이 메모리해제
		context.registerShutdownHook();
		
		//4.context->getBean()를 이용해서 객체 얻어오면 된다.
		//객체를 얻어오는 방식->2.5방식의 코딩(Object->형변환)->3.x버전대 부터 코딩방식(형변환)
		//SystemMoniter moniter3=(SystemMoniter)context.getBean("moniter3");//<bean id="moniter"~>
		//getBean("의존성 객체를 얻어올 id",형변환을 할 클래스명.class)
		PerformanceMoniter moniter=context.getBean
				                    ("/performanceMoniter",PerformanceMoniter.class);
		System.out.println("moniter=>"+moniter);//moniter.toString()
		
		//5.JVM이 종료
		context.close();//JVM이 종료시 컨터이너에 존재하는 모든 빈(객체)도 종료(메모리 해제)
	}

}



