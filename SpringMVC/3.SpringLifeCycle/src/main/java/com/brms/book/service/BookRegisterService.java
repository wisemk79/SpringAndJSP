package com.brms.book.service;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.brms.book.Book;
import com.brms.book.dao.BookDao;
//implements InitializingBean, DisposableBean 인터페이스를 상속받아서 오버라이드하여 init, distrory 메소드를 사용하는 방법이 있고, xml에서 설정해준 메소드를 사용하는 방법이 있다.
public class BookRegisterService{

	@Autowired
	private BookDao bookDao;
	
	public BookRegisterService() { }
	
	public void register(Book book) {
		bookDao.insert(book);
	}
	
	public void initMethod() {
		System.out.println("BookRegisterService 빈(Bean)객체 생성 단계");
	}
	
	public void destroyMethod() {
		System.out.println("BookRegisterService 빈(Bean)객체 소멸 단계");
	}

//	@Override
//	public void destroy() throws Exception {
//		// TODO Auto-generated method stub
//		System.out.println("BookRegisterService 빈(Bean)객체 소멸 단계");
//	}
//
//	@Override
//	public void afterPropertiesSet() throws Exception {
//		// TODO Auto-generated method stub
//		System.out.println("BookRegisterService 빈(Bean)객체 생성 단계");
//		
//	}
}