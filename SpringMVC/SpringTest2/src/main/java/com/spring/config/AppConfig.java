package com.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.MyBean;
import com.spring.MyBeanImpl;
//MyBean->MyBeanImpl,,,,
@Configuration
public class AppConfig { //HomeController2->Camera,Camera2
	  //멤버변수 또는 Setter Method를 사용해서 가져오는 것이 아니라. 직접 메서드를 사용->가져온다.
	  //<bean id="myBeanImpl"  class="com.spring.MyBeanImpl" />
	@Bean
	public MyBean getBeanName() {
		return new MyBeanImpl();  //MyBeanImpl my=new MyBeanImpl() return my;
	}
	//Camera,Camera2관련 메서드 작성 @Bean
	
}
