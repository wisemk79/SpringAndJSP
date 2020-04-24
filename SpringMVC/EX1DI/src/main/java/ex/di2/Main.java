package ex.di2;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//bean을 저장한 xml파일이 있는 위치 지정
		String configLocation = "classpath:applicationContext.xml";
		//지정한 위치를 참고하여 설정파일을 열어옴
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		
		//설정파일에서 Bean을 가져옴
		//getBean()을 이용해서 MyCats타입에서 myCats를 얻어와서 객체 생성
		// 방법 1에서 처럼 직접생성이 아닌 외부에서 얻어온다.
		MyCats myCat = ctx.getBean("myCats", MyCats.class);
		
		//호출
		myCat.catsNameInfo();
		myCat.catsAgeInfo();
		
	}

}
