package com.word.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.word.WordSet;
import com.word.dao.WordDao;

public class WordSearchService {
	//@Resource
	//@Inject <--autowird가 일반적으로 많이 쓰이며 똑같은 기능을 가지는데 차이점은 autowired에서 required=false로 exception을 회피하는 기능(보통은 안쓰는걸 권장)과 같은걸 지원하지 않는다.
	//@Inject는 qualifier를 xml에서 따로 작성하지 않으며 같은 데이터타입의 경우 id로 구분을 하는데 그때 같이 쓰는 어노테이션이 @Named(value="wordDao1")이런식으로 한다. 
	@Autowired
	@Qualifier("usedDao")
	private WordDao wordDao;
	
	public WordSearchService() {}
	
	//@Autowired
	public WordSearchService(WordDao wordDao) {
		this.wordDao = wordDao;
	}
	
	public WordSet searchWord(String wordKey) {
		if(verify(wordKey)) {
			return wordDao.select(wordKey);
		} else {
			System.out.println("WordKey information is available.");
		}
		
		return null;
	}
	
	public boolean verify(String wordKey){
		WordSet wordSet = wordDao.select(wordKey);
		return wordSet != null ? true : false;
	}
	
	public void setWordDao(WordDao wordDao) {
		this.wordDao = wordDao;
	}
	
}