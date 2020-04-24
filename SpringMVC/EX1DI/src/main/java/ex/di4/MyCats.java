package ex.di4;

import java.util.ArrayList;

public class MyCats {
	private String name;
	private int age;
	private ArrayList<String> hobbys;
	private double weight;
	private String color;
	
	//생성자를 통해 name, age, hobbys를 받아와 각각의 필드의 값들을 초기화 시켜줌
	public MyCats(String name, int age, ArrayList<String> hobbys) {
		this.name = name;
		this.age = age;
		this.hobbys = hobbys;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}


	public ArrayList<String> getHobbys() {
		return hobbys;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
}
