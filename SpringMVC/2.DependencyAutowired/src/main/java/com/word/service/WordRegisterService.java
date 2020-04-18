package com.word.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.word.WordSet;
import com.word.dao.WordDao;

public class WordRegisterService {
	//만약 멤버변수 또는 세터 메소드에 오토와이어드를 쓰고 싶다면 오른쪽 처럼 디폴트 생성자를 사용해야한다. public WordRegisterService() {}
	//@Resource
	@Autowired 
	@Qualifier("usedDao")
	private WordDao wordDao;
	
	public WordRegisterService() {}
	
	//<constructor-arg ref="wordDao"></constructor-arg> <--이거 대신 사용할 수 있으며 생성자의 arg 데이터 타입에 맞게 알아서 주입한다.  
	//@Autowired
	public WordRegisterService(WordDao wordDao) {
		this.wordDao = wordDao;
	}
	
	public void register(WordSet wordSet) {
		String wordKey = wordSet.getWordKey();
		if(verify(wordKey)) {
			wordDao.insert(wordSet);
		} else {
			System.out.println("The word has already registered.");
		}
	}
	
	public boolean verify(String wordKey){
		WordSet wordSet = wordDao.select(wordKey);
		return wordSet == null ? true : false;
	}
	
	public void setWordDao(WordDao wordDao) {
		this.wordDao = wordDao;
	}
	
}