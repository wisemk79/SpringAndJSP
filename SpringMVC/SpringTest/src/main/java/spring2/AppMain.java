package spring2;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

//스프링방식 -> 자주 사용되거나, 반복적으로 사용하는 특정 클래스의 객체(빈즈)가 필요하다면, 
//			미리 만들어서 가져오는 개념이다(대여) -> 직접적으로 new를 이용해서 객체를 만들 필요가 없다. 
//spring2 패키지에 xml환경설정파일이 필요하다. (설명서와 같은 역할)
//new -other 
public class AppMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1.xml파일을 불러올 수 있기위해서 Resource객체 필요 
//		Resource resource = new FileSystemResource("/Users/wisemk/Library/KIC_DATA/SpringMVC/SpringTest/src/main/java/spring2/applicationContext.xml");
		
		//2)상대경로를통해서 불러온다. => 배열형태로 불러오는 경우도있다. 
		Resource resource = new ClassPathResource("/spring2/applicationContxt.xml");
		
		//2.메모리에 클래스에 해당하는 객체를 올린다.-> getBean()호출하기위해서 이 객체 필요 
		BeanFactory factory = new XmlBeanFactory(resource);
		//getBean("불러올객체를 가져오는 id값을 매개변수로 전달") => 형변환 
//		Message2 me = (Message2)factory.getBean("test2");
//		Message1 me = (Message1)factory.getBean("test");
		
		//부모 클래스 인터페이스로 가져오게되면 겉으로는 부모클래스이지만 자식클래스를 가리키고있다. 
		MessageInter me = (MessageInter)factory.getBean("test2");
		me.sayHello("홍길동");
	}

}
