package lee;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.dao.DataAccessException;

public class SqlMapBoardDao extends SqlSessionDaoSupport implements BoardDAO {

	 //SqlSession sqlSession;//멤버변수선언->가져와야 된다.
	 //글목록보기->ListActionController->list()
	@Override
	public List list() throws DataAccessException {
		// TODO Auto-generated method stub
		/*  반환값이 String,Integer,,레코드한개
		 * 형식) sqlSession객체명.selectOne(실행시킬 sql구문의 id,전달할 매개변수명)
		 *   반환값이 레코드 여러개
		 * 형식) sqlSession객체명.selectList(실행시킬 sql구문의 id,전달할 매개변수명)
		 *        sqlSession객체명.selectList(실행시킬 sql구문의 id) 매개변수가 없는 경우
		 */
		return getSqlSession().selectList("list");//<select id="list" resultType="board"></
	}
	//  /write.do->WriteActionController
	@Override
	public int getNewNum() throws DataAccessException {
		// TODO Auto-generated method stub
		//메모리상의 값(Object)->Integer->int
		/*
		int newNum=(Integer)getSqlSession().selectOne("getNewNum");
		return newNum; */
		return (Integer)getSqlSession().selectOne("getNewNum");
	}
	
	@Override
	public void write(BoardCommand data) throws DataAccessException {
		// TODO Auto-generated method stub
		//insert태그->형식)sqlSession객체명.insert("실행시킬 id",매개변수명)
		getSqlSession().insert("write",data);//<insert id="write" par~>inser~
	}
	// /retrieve.do  ->RetrieveActionController->retrieve.jsp전송->화면 출력
	@Override
	public void updateReadcnt(String num) throws DataAccessException {
		// TODO Auto-generated method stub
		//update태그->형식)sqlSession객체명.update("실행시킬 id",매개변수명)
		getSqlSession().update("updateReadcnt",num);//#{num}->getNum()
	}
	
	@Override
	public BoardCommand retrieve(String num) throws DataAccessException {
		// TODO Auto-generated method stub
		return (BoardCommand)getSqlSession().selectOne("retrieve",num);
	}
	
	@Override
	public void update(BoardCommand data) throws DataAccessException {
		// TODO Auto-generated method stub
		//형식) SqlSession객체.update("실행시킬 id이름",매개변수) or 매개변수X
		getSqlSession().update("update",data);//data->필드별로 Getter Method호출
	}
	
	@Override
	public void delete(String num) throws DataAccessException {
		// TODO Auto-generated method stub
		//형식) SqlSession객체.delete("실행시킬 id이름",매개변수) or 매개변수X
				getSqlSession().delete("delete",num);//<delete id="delete" par~
	}
	
	@Override
	public List search(BoardCommand data) throws DataAccessException {
		// TODO Auto-generated method stub
		//selectOne()->레코드 한개,필드 한개이상 자료형을 기술할때도 필요
		//selectList()=>여러개의 레코드를 반환받을때 사용(ArrayList,List 사용할때)
		return getSqlSession().selectList("search",data);//#{searchName},#{searchValue}
	}
}





