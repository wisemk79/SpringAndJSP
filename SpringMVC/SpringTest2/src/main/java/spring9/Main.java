package spring9;

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
		
		ProtocolHanderFactory protocol=
				  context.getBean("protocolHanderFactory",ProtocolHanderFactory.class);
		System.out.println("protocol=>"+protocol);//moniter.toString()
		/*
		 * setMap()호출 (map)=>{soap=spring9.SoapHandler@6ebc05a6, rest=spring9.RestHandler@6e6c3152}
            protocol=>spring9.ProtocolHanderFactory@1efed156
		 */
		//5.JVM이 종료
		context.close();//JVM이 종료시 컨터이너에 존재하는 모든 빈(객체)도 종료(메모리 해제)
	}

}



