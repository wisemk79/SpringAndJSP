package com.ho.lec24.config;

import java.beans.PropertyVetoException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;
//이클래스는 멤버dao에서 자동주입시킨 ComboPooledDataSource dataSource와 동일하며 다만 클래스형으로 설정해준것이다
//둘중하나를 사용해도된다.
@Configuration
public class DBConfig {
	
	@Bean
	public ComboPooledDataSource dataSource() throws PropertyVetoException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		
		dataSource.setDriverClass("oracle.jdbc.driver.OracleDriver");
		dataSource.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUser("scott");
		dataSource.setPassword("tiger");
		dataSource.setMaxPoolSize(200);
		dataSource.setCheckoutTimeout(60000);
		dataSource.setMaxIdleTime(1800);
		dataSource.setIdleConnectionTestPeriod(600);
		
		return dataSource;

	}
	
}