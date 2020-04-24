package com.spring.anno5;

//@Resouce을 이용한 예제(byName)
/*
 * 같은 클래스 자료형이 여러개 있을때 어떻게 구분해서 각각의 객체를 가져올 수있는가?
 *  @Resource 어노테이션을 이용 ->멤버변수,메서드위에 기술이 가능
 */
import javax.annotation.*;//@Resource 어노테이션과 연관
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("homeCvn")         //homeCvn
public class HomeController2 { //기본적으로 등록하는 기본 id값이 된다.(homeController2)
	
	@Inject
	private Camera camera;
	
	@Autowired
	private Camera2 camera2;
	
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return "HomeController2[camera="+camera+",camera2="+camera2+"]";
    }
}









