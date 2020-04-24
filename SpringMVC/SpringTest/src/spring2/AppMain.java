package spring2;

import javax.annotation.Resource;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

//스프링 방식->자주 사용이 되거나 반복적인 특정 클래스의 객체가 필요하다면
//                미리 만들어서 가져오자(대여) 빈즈->new 사용X
//xml 환경설정파일이 필요(설명서와 같은 역할)

public class AppMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1.
		/*
		Resource resource=new FileSystemResource
				("C:/webtest/4.jsp/sou/SpringTest/src/spring2/applicationContext.xml");
		*/
		//2)상대경로를 통해서 불러온다.=>배열형태로 불러오는 경우도 있다.
		Resource resource=new ClassPathResource("/spring2/applicationContext.xml");
		//2.메모리에 클래스에 해당하는 객체를 올린다.->getBean()호출하기위해서 이 객체필요
		BeanFactory factory=new XmlBeanFactory(resource);
		//getBean("불러올 객체를 가져오은 id값을 매개변수 전달)=>형변환
		//Message2 me=(Message2)factory.getBean("test2");
		//Message1 me=(Message1)factory.getBean("test");
		MessageInter me=(MessageInter)factory.getBean("test2");
		//Message2 me=new Message2();
        me.sayHello("홍길동");
	}

}





