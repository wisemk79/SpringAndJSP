package ex.di4;

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
        System.out.println("야옹이 몸무게 : "+myCats.getWeight());
        System.out.println("야옹이 색 : "+myCats.getColor());
		System.out.println("================================");
	}
	
	//받아온 myCats값을 넣어줌
    public void setMyCatsInfo(MyCats myCats){
        this.myCats = myCats;
    }
    
}
