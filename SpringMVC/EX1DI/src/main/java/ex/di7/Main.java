package ex.di7;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext factory = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		factory.registerShutdownHook();
		
		HomeController homeController = factory.getBean("homeController", HomeController.class);
		
		homeController.display();
		
		factory.close();
	}

}
