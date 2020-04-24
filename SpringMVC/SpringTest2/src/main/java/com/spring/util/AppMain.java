package com.spring.util;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.MyBean;
import com.spring.config.AppConfig;//환경설정파일을 불러온다.

//MyBean,AppConfig
public class AppMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //1.xml환경설정파일을 불러온다.-->AppConfig.java(환경설정파일명.class)
		AnnotationConfigApplicationContext ac=
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		//2.Bean정의를 가져온다.->형식)Anno객체명.getBean(가져올 클래스자료형.class);
		MyBean bean=ac.getBean(MyBean.class);
		System.out.println(bean.getBeanName());//My service Bean
		
		//컨텍스트 오브젝트 종료
		ac.close();
	}

}






