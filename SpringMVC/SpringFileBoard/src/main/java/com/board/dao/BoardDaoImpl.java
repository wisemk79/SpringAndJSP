package com.board.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.board.domain.BoardCommand;

//SqlSessionDaoSupport 상속받는 이유=>SqlSession객체를 자동으로 반환 getSqlsession()
public class BoardDaoImpl extends SqlSessionDaoSupport implements BoardDao {

	//검색분야에 따른 검색어까지 조회(페이징 처리)
	public List<BoardCommand> list(Map<String, Object> map) {
		// TODO Auto-generated method stub
		List<BoardCommand> list=getSqlSession().selectList("selectList",map);
		return list;
	}

	public int getRowCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("selectCount",map);
	}
	// /write.do-->WriteController->호출할 메서드를 선언
	public int getNewSeq() {
		// TODO Auto-generated method stub
		//Object->Integer->int
		int newseq=(Integer)getSqlSession().selectOne("getNewSeq");
		return newseq;
		//return getSqlSession().selectOne("getNewSeq");//내부적으로 형변환돼서 반환됨
	}
	
	public void insert(BoardCommand board) {
		// TODO Auto-generated method stub
		getSqlSession().insert("insertBoard",board);//getMethod호출->#{seq},,,
	}
	
	public void updateHit(Integer seq) {
		// TODO Auto-generated method stub
		getSqlSession().update("updateHit",seq);
	}
	
	public BoardCommand selectBoard(Integer seq) {
		// TODO Auto-generated method stub
		//Object->BoardCommand
		return (BoardCommand)getSqlSession().selectOne("selectBoard",seq);//<
	}
	
	public void update(BoardCommand board) {//parameterType O, resultTypeX
		// TODO Auto-generated method stub
		getSqlSession().update("updateBoard",board);//1.id값지정 2.전달매개변수명
	}
	
	public void delete(Integer seq) {
		// TODO Auto-generated method stub
		getSqlSession().delete("deleteBoard",seq);
	}
}


