package com.spring;

//MyBean인터페이스를 상속받은 자식클래스
public class MyBeanImpl implements MyBean {

	@Override
	public String getBeanName() {
		// TODO Auto-generated method stub
		return "My service Bean";
	}
}
