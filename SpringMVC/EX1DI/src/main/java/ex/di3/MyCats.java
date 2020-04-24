package ex.di3;

import java.util.ArrayList;

public class MyCats {
	private String name;
	private int age;
	private ArrayList<String> hobbys;
	
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
	
}
