package spring8;
//고객,도서(서버에 접속->ip주소,접속시간을  설정,책대여수 까지 관리)
import java.util.Set;

public class Customer extends Object{
    private Set<Integer> subSet;//책대여수
    
    public void setSubSet(Set<Integer> subSet) {
    	this.subSet=subSet;
    }
    //어노테이션도 하나의 기능을 가지고 있다. 
    //@키워드->오버라이딩 되어있는지 확인해주는 기능
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return "Customer[subSet="+subSet+"]";
    }
}
