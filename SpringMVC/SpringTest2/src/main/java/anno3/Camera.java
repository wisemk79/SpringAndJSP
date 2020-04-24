package anno3;

//어노테이션을 사용하게되면 관련된 클래스를 불러와야 된다.(import)
import org.springframework.beans.factory.annotation.Required;

public class Camera {

	private int number;//카메라수->0
	
	@Required
	public void setNumber(int number) {
		this.number=number;
		System.out.println("setNumber() 호출됨!");
	}
	
	@Override  //이 메서드가 오버라이딩된 메서드임을 알려주는 역할
	public String toString() {
		// TODO Auto-generated method stub
		return "Camera[number="+number+"]";
	}
}
