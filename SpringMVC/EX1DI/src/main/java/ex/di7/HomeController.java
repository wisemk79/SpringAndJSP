package ex.di7;

import javax.annotation.Resource;

public class HomeController {
	private Number num1;
	
	@Resource(name="num2")
	private Number num2;
	
	@Resource(name="num1")
	public void setNum1(Number num1) {
		this.num1 = num1;
	}
	
	public void display() {
		System.out.println("num1: " + num1);
		System.out.println("num2: " + num2);
	}
	
/*
 * 정리 @Autowired는 byType으로 주입시키며 required 속성이 false인경우 프로퍼티를 안넣어도 오류가 발생하지 않도록 설정이 가능하다.
 * @Inject는 Autowired와 같은 기능을 하지만 required속성과 같은 것을 지정해줄수없다.
 * @Resource는 byName으로 구분해주며 name속성으로 같은 타입의 객체라도 구분해서 사용할 수있다.
 * 
 * */	
	
}
