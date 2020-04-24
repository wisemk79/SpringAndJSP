package ex.di2;

//데이터 처리 클래스
public class MyCats {
	//실제 기능을 하는 클래스를 데이터처리 클래스에 주입 
	Cats cats;
	private String firstCatName;
	private int firstCatAge;
	private String secondCatName;
	private int secondCatAge;


	/*
	 * 예제에서는 Cats클래스에 setter와 실제 작동 하는 메서드를 작성해 주었는데 방법2 예제에서는 Cats와 MyCats로 나눠주었습니다.
 		Cats에는 실제 기능을 하는 메서드를 작성, MyCats에는 필요한 필드들을 선언 후 setter를 만들어 주었고, 
 		catsNameInfo()와 catsAgeInfo() 메서드를 생성하여 직접 처리하지 않고, Cats를 클래스를 사용해서 처리하도록 해줍니다.
	 * */
	public Cats getCats() {
		return cats;
	}

	public void setCats(Cats cats) {
		this.cats = cats;
	}
	
	public void catsNameInfo() {
		cats.catName(firstCatName, secondCatName);
	}
	
	public void catsAgeInfo() {
		cats.catAge(firstCatAge, secondCatAge);
	} 

	public String getFirstCatName() {
		return firstCatName;
	}

	public void setFirstCatName(String firstCatName) {
		this.firstCatName = firstCatName;
	}

	public int getFirstCatAge() {
		return firstCatAge;
	}

	public void setFirstCatAge(int firstCatAge) {
		this.firstCatAge = firstCatAge;
	}

	public String getSecondCatName() {
		return secondCatName;
	}

	public void setSecondCatName(String secondCatName) {
		this.secondCatName = secondCatName;
	}

	public int getSecondCatAge() {
		return secondCatAge;
	}

	public void setSecondCatAge(int secondCatAge) {
		this.secondCatAge = secondCatAge;
	}
}
