package anno4;

//@Resouce을 이용한 예제(byName)
/*
 * 같은 클래스 자료형이 여러개 있을때 어떻게 구분해서 각각의 객체를 가져올 수있는가?
 *  @Resource 어노테이션을 이용 ->멤버변수,메서드위에 기술이 가능
 */
import javax.annotation.*;//@Resource 어노테이션과 연관

public class HomeController2 {
	
	private Camera camera;
	
    @Resource(name="camera5")
	public void setCamera(Camera camera) {
		this.camera = camera;
		System.out.println("setCamera() camera5이름을 가진 메서드 호출됨");
	}
    
    @PostConstruct
    public void init() {
    	System.out.println("빈즈객체(camera) 생성전에 초기화작업(init) 호출됨!");
    }
    
    @PreDestroy
    public void close() {
    	System.out.println("빈즈객체(camera) 생성후에 메모리해제(close() 호출됨!");
    }
}









