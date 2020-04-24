package lee;

import java.util.*;//List
import org.springframework.dao.DataAccessException;//스프링의 예외처리클래스

//게시판에서 공통으로 사용할 기능->추상메서드

public interface BoardDAO{
	
	//1.글목록보기
	public List list() throws DataAccessException;
	
	//2.최대값과 글쓰기
	public int getNewNum() throws DataAccessException;
	
	public void write(BoardCommand data) throws DataAccessException;
	
	//3.조회수증가(특정 게시물번호) 및 글상세보기
	public void updateReadcnt(String num) throws DataAccessException;
	
	public BoardCommand retrieve(String num) throws DataAccessException;
	
	//4.글수정하기->글쓰기와 동일
	public void update(BoardCommand data) throws DataAccessException;
	
	//5.글삭제하기
	public void delete(String num) throws DataAccessException;
	
	//6.글검색하기->(String searchName,String searchValue)=>HashMap이용
	//따로 클래스를 하나 작성=>BoardCommand에 멤버변수를 추가
	public List search(BoardCommand data)throws DataAccessException;
}
/*
package lee;

import java.sql.*;//DB연동
import java.util.*;//ArrayList,List
//--------JNDI를 사용---------------------------------------------------------------
import javax.sql.*;//DataSource객체(DB연동이 가능)->getConnection()를 이용
import javax.naming.*;//Context(인터페이스),InitialContext객체(자식)
                                   //lookup('찾고자하는 JNDI명')
//-----------------------------------------------------------------------------------
public class BoardDAO{
   
	DataSource ds;//DBConnectionMgr pool=null;  //has a 관계
	
   public BoardDAO(){
		//생성자 : DataSource 얻어오기 :  InitialContext  와  JNDI 명
		try {
			//1.Context객체를 얻어오기->lookup메서드를 호출하기위해서
			//InitialContext ctxt=new InitialContext(); 자식클래스를 통해서도 가능
			Context ctx=new InitialContext();
			//형식) lookup("java:comp/env/찾고자하는 JNDI명")
			ds=(DataSource)ctx.lookup("java:comp/env/jdbc/orcl");
			System.out.println("ds=>"+ds);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public ArrayList  list(){  // 1.글목록보기->검색->페이징처리하기
		//1.레코드 한개이상 저장  2.레코드 한개만 저장->DTO객체 3.필드한개(자료형)
		//필드 한개이상->DTO
		
		ArrayList list = new ArrayList();
		try{ //checked Exception
			String sql = "SELECT * FROM springboard ORDER BY num desc";
			Connection con = ds.getConnection();//pool.getConnection
			System.out.println("con=>"+con);
			//sql구문 실행->stmt,pstmt객체 필요
			PreparedStatement stmt = con.prepareStatement(sql);
			//select구문->ResultSet
			ResultSet rs = stmt.executeQuery();//executeUpdate(insert,update,delete)
			while(rs.next()){//화면에 보여줄 레코드가 존재한다면 레코드포인트 이동하라
				Board data = new Board();//DTO객체
				data.setNum( rs.getInt( "num" ) );//rs.getInt(정수)
				data.setAuthor(rs.getString( "author" ));//rs.getString(문자열)
				data.setTitle(rs.getString( "title"));
				data.setContent(rs.getString( "content" ));
				data.setDate(rs.getString( "writeday" ));
				data.setReadcnt(rs.getInt( "readcnt" ));
				list.add( data );
			}//end while
			rs.close();	stmt.close(); con.close();
		}catch(Exception e){ e.printStackTrace(); }
		
		return  list;
	}//end list
	
	public int getNewNum(){ //글의 최대값 구하기
		int newNum=1;//저장할 게시물번호 디폴트 설정값1
		try {
			String sql="select max(num) from springboard";
			Connection con=ds.getConnection();
			PreparedStatement stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery(sql);
			if(rs.next()) { //레코드가 한개라도 존재한다면=>최대값+1
				newNum=rs.getInt(1)+1;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return newNum;
	}//end getNewNum();
	
	 //글쓰기
	//public void write(Board board){~}
	//Spring에서 매개변수를 받았을때 <jsp:setProperty name="빈즈객체" property="*" />
	public void write(String author, String title , String content){
		try{
			int newNum = getNewNum();//최대값을 구해주는메서드
			//보안때문에 ?을 써야 된다.->로그객체를 생성->출력
			String sql ="insert into springboard(num,author,title,content) values(";
			sql +=  newNum + ",'" + author + "','" + title + "','" + content + "')";
			System.out.println(sql);//한글이 깨지는지 안깨지는 확인하기위해서 필요
			
	  	  	Connection con = ds.getConnection();
	  	  	PreparedStatement stmt = con.prepareStatement(sql);
	  	  	//stmt.execute(sql);
	  	  	int insert=stmt.executeUpdate(sql);
	  	  	System.out.println("데이터 입력성공유무(insert)=>"+insert);
	  	  	stmt.close(); con.close();
	  	}catch(Exception e ) {e.printStackTrace();}
	}//end write
	
	//1.조회수 증가 2.게시물번호에 해당되는 데이터를 검색
	//select * from springboard where num=3
	public Board retrieve(String num){ // 글상세보기 
		Board data=new Board();//레코드 한개를 담을 객체선언
		
		try {
			//1.조회수를 증가
			String sql="update springboard set readcnt=readcnt+1 where num="+num;
			Connection con=ds.getConnection();
			PreparedStatement stmt=con.prepareStatement(sql);
			int update=stmt.executeUpdate(sql);//성공 1, 실패 0
			System.out.println("조회수 증가유무(update)=>"+update);
			stmt=null;//전에 저장된 정보를 제거
			sql="select * from springboard where num="+num;
			//stmt객체를 얻어오는 구문이 누락
			stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery(sql);
			
			if(rs.next()) {
				data.setNum(rs.getInt("num"));
				data.setAuthor(rs.getString("author"));
				data.setTitle(rs.getString("title"));
				data.setContent(rs.getString("content"));
			}
			rs.close(); stmt.close(); con.close();//메모리 해제는 생성된 순서의 역순
		}catch(Exception e) {
			e.printStackTrace();
		}
	  return data;
	}//end retrieve
    //수정하는 메서드는 글쓰기와 같다.(insert into 대신에 update 테이블명~)
	//public void update(Board board){~}
	//보안=>? 대신에 한글이 제대로 입력되는지 확인하기위해서 ?을 안쓴상태
	public void update( String num , String author, 
			                       String title , String content){ // 글수정하기
	     try{
		  String sql ="update springboard set title='" + title + "',";
		  sql += " content='" + content+"',";
		  sql += " author ='" + author+"'";
		  sql += " where num=" + num; //게시물 번호->매개변수로 전달(입력X hidden객체)
		  System.out.println(sql);//한글깨짐을 확인

		  Connection con = ds.getConnection();
		  PreparedStatement stmt = con.prepareStatement(sql);  
		  int update=stmt.executeUpdate(sql);
		  System.out.println("테이블의 수정유무확인(update)=>"+update);//1 수정성공 0 실패
		  stmt.close();  con.close();
	     }catch(Exception e){e.printStackTrace();}
	  }//end update
      //delete from springboard where num=3;
	  public void delete(String num){ //글삭제하기
			try {
				String sql="delete from springboard where num="+num;
				Connection con=ds.getConnection();
				PreparedStatement stmt=con.prepareStatement(sql);
				int delete=stmt.executeUpdate(sql);//성공 1, 실패 0
				System.out.println("데이터 삭제유무(delete)=>"+delete);
				stmt.close(); con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
	  }//end delete
       //검색분야,검색어=>페이지번호,게시물번호=>페이징 처리X
	  public ArrayList search( String name , String value ){ //검색하기
		   //List list=new ArrayList();
		     ArrayList list = new ArrayList();//검색분야,검색어에 따른 검색된 결과를 담을 객체필요
		                                                   //필드로 매개변수로 전달받은 이유
		    try{
		  	  String sql = "SELECT * FROM springboard";
			  sql += " WHERE  " + name + " LIKE  '%" + value + "%' "; 
			  System.out.println( sql );//검색된 SQL->로그객체로 만들어서 출력
		  
			      Connection con = ds.getConnection();
		    	  PreparedStatement stmt = con.prepareStatement(sql);
		    	  ResultSet rs = stmt.executeQuery( sql );
		    	  while( rs.next()){
		    		Board data = new Board();//검색어에 해당되는 데이터만 저장
		    		data.setNum(rs.getInt( "num" ));
		    		data.setAuthor(rs.getString( "author" ));
		    		data.setTitle(rs.getString( "title"));
		    		data.setContent(rs.getString( "content" ));
		    		data.setDate(rs.getString( "writeday" ));
		    		data.setReadcnt(rs.getInt( "readcnt" ));
		    		list.add( data );//맨나중에 추가->저장
		    	  }
		    	  rs.close();	stmt.close(); con.close();
		    	}catch( Exception e){ e.printStackTrace();}
		    	return list;
    }
}
*/