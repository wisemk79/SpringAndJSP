package test; //기능별로 분류->회원관리,게시판,관리자...
/*
 * 빈즈클래스를 만드는 조건
 * 
 * 1.반드시 public class로 작성할것=>웹상에서 불러다 사용할 수 있도록 해주기위해서
 *                                               메서드 호출하기위해서 
 * 2.멤버변수(입력받는 부분)을 저장=>반드시 private로 선언해야 한다.
 * 3.Setter,Getter Method 작성
 */
public class BeanDTO {

	private String str;
	private String addr;
	//private int age;
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
		System.out.println("setStr()호출됨!");
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
		System.out.println("setAddr()호출됨!");
	}
}
