package ex.di7;

public class Number {
	private int number;
	

	public void setNumber(int number) {
		this.number = number;
	}
	
	@Override
	public String toString() {
		return "[number=" + number + "]";
	}
	
	
}
