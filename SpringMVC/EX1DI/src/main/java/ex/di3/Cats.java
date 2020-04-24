package ex.di3;

//실제 기능을 하는 클래스
public class Cats {
	MyCats myCats;
	
	public Cats(MyCats myCats) {
		this.myCats = myCats;
	}
	
	public void getMyCatsInfo() {
		System.out.println("================================");
		System.out.println("야옹이 이름: " + myCats.getName() + "입니다.");
		System.out.println("야옹이 나이: " + myCats.getAge()+"입니다.");
		System.out.println("야옹이 취미: " + myCats.getHobbys() + "입니다.");
		System.out.println("================================");
	}
	
	public void getMyCatsInfo(MyCats myCats) {
		System.out.println("================================");
		System.out.println("야옹이 이름: " + myCats.getName() + "입니다.");
		System.out.println("야옹이 나이: " + myCats.getAge()+"입니다.");
		System.out.println("야옹이 취미: " + myCats.getHobbys() + "입니다.");
		System.out.println("================================");
	}
}
