package com.board.dao;
//자료실에서 공통으로 사용할 기능(추상메서드로 선언)
import java.util.*;
import com.board.domain.BoardCommand;

public interface BoardDao {

	 //1.글목록보기
	public List<BoardCommand> list(Map<String,Object> map);//검색분야,검색어
	
	//2.총갯수->페이징 처리때문에 (검색분야,검색어)->검색어에 대해서 갯수가 달라진다.
	public int getRowCount(Map<String,Object> map);
	
	//3.최대글 번호 구하기
	public int getNewSeq();
	
	//4.자료실의 글쓰기
	public void insert(BoardCommand board);
	
	//5.게시물에 대한 레코드 한개 찾는 메서드
	public BoardCommand selectBoard(Integer seq);
	//~(int seq);=>parameterType="Integer"
	//-
	//6.게시물 번호에 해당하는 조회수 증가
	public void updateHit(Integer seq);//~(int seq);
	
	//7.글수정하기
	public void update(BoardCommand board);
	
	//8.글삭제하기
	public void delete(Integer seq);
}












