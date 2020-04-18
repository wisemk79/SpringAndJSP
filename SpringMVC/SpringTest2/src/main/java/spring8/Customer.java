package spring8;


//고객, 도서 (서버에접속-> ip주소, 접속시간을 설정, 책대여수까지 관리)
import java.util.Set;//같은데이터는 저장이되지 않음. 

public class Customer extends Object {
	private Set<Integer> subSet;//책대여수 
	
	public void setSubSet(Set<Integer> subSet) {
		this.subSet = subSet;
	}
	
	
	
	@Override //<--어노테이션이 없다면 toString()이라는 오브젝트의 메소드를 사용하는것이 아니라 새로운 toString이라는 메서드를 만든것이된다. 
	public String toString() {
		return "Customer[subSet="+ subSet + "]";
	} 
}
