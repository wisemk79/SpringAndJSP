package ex.di1;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * 첫번째 방법은 A객체가 B와 C객체를 New 생성자를 통해서 직접 생성하는 방법이고, 
			첫번째 방법 예제를 보시면 MainClass는 Cats를 의존하고 있고, MainClass에서 직접 Cats클래스를 생성해서 사용합니다. 
		 */
		Cats cats = new Cats();
		
		cats.catName("순덕","나비");
		cats.catAge(1,2);
	}

}
