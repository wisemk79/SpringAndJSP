package anno3;

import org.springframework.beans.factory.annotation.Required;

public class Camera {
	
	private int number;//카메라수 -> 기본은 0개
	
	/*	@Required <==반드시 호출할 메서드에 표시, 메서드 위에다 선언해야한다. 
	 *  기능
		 메서드를 호출하지 않으면 에러를 발생시킨다.=>필수 메서드
		 반드시 호출해야되는데 호출하지 않은경우에 대비하기위해서 만들어진 어노테이션
	 */
	@Required
	public void setNumber(int number) {
		this.number = number;
		System.out.println("setNumber() 메소드 호출됨=> " + number);
	}
	
	@Override//미 메소드가 오버라이딩한 메소드임을 알려주는 역할
	public String toString() {
		return "Camera[number=" + number + "]";
	}
	
	
}
