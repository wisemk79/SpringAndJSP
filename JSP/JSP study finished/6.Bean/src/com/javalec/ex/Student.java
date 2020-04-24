package com.javalec.ex;

public class Student {
	private String name;
	private int age;
	private int grade;
	private int studentNum;
	
	//dto의 getter, setter를 만들어주는 방법은 멤버변수 설정한다음
	// 우클릭 한다음 Source- Generate getter and setter
	public Student() {
		
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getGrade() {
		return grade;
	}
	
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	public int getStudentNum() {
		return studentNum;
	}
	
	public void setStudentNum(int studentNum) {
		this.studentNum = studentNum;
	}
	
}
