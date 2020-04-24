package ex.di2;

//실제 기능을 하는 클래스
public class Cats {
	
	public void catName(String firstCatName, String secondCatName) {
		System.out.println("catName()");
		System.out.println("첫번째 고양이 이름은 " + firstCatName + "입니다.");
		System.out.println("두번째 고양이 이름은 " + secondCatName + "입니다.");
	}
	
	public void catAge(int firstCatAge, int secondCatAge) {
		System.out.println("catAge()");
		System.out.println("첫번째 고양이 나이는 " + firstCatAge + "입니다.");
		System.out.println("두번째 고양이 나이는 " + secondCatAge + "입니다.");
	}
	
}
