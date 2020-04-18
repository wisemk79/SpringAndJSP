package anno3;

/*@Resource을 이용한 예제(byName)
 * 
 * 같은 클래스 자료형이 여러개 있을 떄 어떻게 구분해서 각각의 객체를 가져올 수 있는가?
 * @Resource 어노테이션을 이용->멤버변수, 메서드위에 기술이 가능
 * */
public class HomeController {
	private Camera camera2;
	private Camera camera3;
	private Camera camera4;
	/*
	 * 형식) @Resource(name="빈즈의 구분자 id")->멤버변수에 적용하면 setter메서드 생략해도된다. =>자동으로 연결할 의존객체를 찾아서 가져온다.
	 * */
	
	
	public void setCamera3(Camera camera3) {
		this.camera3 = camera3;
	}

	public void setCamera4(Camera camera4) {
		this.camera4 = camera4;
	}
}
