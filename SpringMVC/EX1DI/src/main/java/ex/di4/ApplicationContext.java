package ex.di4;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration//스프링 설정에 사용되는 클래스임을 명시해주는 어노테이션
public class ApplicationContext {
	
	@Bean//객체를 생성하는 어노테이션
	public MyCats cat1() {
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("잠자기");
		hobbys.add("꾹꾹이");
		
		MyCats myCats = new MyCats("나비",1, hobbys);
		myCats.setWeight(2.0);
		myCats.setColor("black");
		return myCats;
	}
	
	@Bean//객체를 생성하는 어노테이션
	public MyCats cat2() {
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("우다다");
		hobbys.add("박치기");
		
		MyCats myCats = new MyCats("호랑이",4, hobbys);
		myCats.setWeight(5.4);
		myCats.setColor("yellow");
		return myCats;
	}
	
	@Bean
	public Cats catsInfo() {
		Cats cats = new Cats(this.cat1());
		return cats;
	}
	
}
