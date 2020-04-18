package spring7;

import java.util.List;

//의존객체가 List형의 객체를 가져올때 어떻게 xml환경설정을 하느냐?
public class PerformanceMoniter {
	
	private List<Double> number;//성능의 차이

	public void setNumber(List<Double> number) {
		this.number = number;
		System.out.println("setNumber(List<Double> number) 메소드 호출 =>" + number);
	}
	
	
}
