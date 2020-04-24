package anno3;

//@Resouce을 이용한 예제(byName)
/*
 * 같은 클래스 자료형이 여러개 있을때 어떻게 구분해서 각각의 객체를 가져올 수있는가?
 *  @Resource 어노테이션을 이용 ->멤버변수,메서드위에 기술이 가능
 */
import javax.annotation.Resource;//@Resource 어노테이션과 연관

public class HomeController {
	
	@Resource(name="camera2")//<bean id="camera2" class="anno3.Camera" />
     private Camera camera2;
     private Camera camera3;
     private Camera camera4;
     /*
      *  형식) @Resource(name="빈즈의 구분자id")->멤버변수에 적용=>setXXX메서드 생략
      *                                                           ->자동으로 연결할 의존객체을 찾아서 가져온다.
      * 
      */
     /*
	public void setCamera2(Camera camera2) {
		this.camera2 = camera2;
		System.out.println("setCamera2()  호출됨");
	}*/
    @Resource(name="camera3")
	public void setCamera3(Camera camera3) {
		this.camera3 = camera3;
		System.out.println("setCamera3()  호출됨");
	}
    
    @Resource(name="camera4")
	public void setCamera4(Camera camera4) {
		this.camera4 = camera4;
		System.out.println("setCamera4()  호출됨");
	}
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return "HomeController[camera2="+camera2+
    			   ",camera3="+camera3+",camera4="+camera4+"]";
    } 
}



