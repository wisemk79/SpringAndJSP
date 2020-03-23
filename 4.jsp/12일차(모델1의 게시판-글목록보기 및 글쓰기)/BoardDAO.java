package lys.board;

//has a 관계->서로 관련이 있는 클래스들의 관계설정
import java.sql.*;//DB사용
import java.util.*;//ArrayList,List을 사용하기위해서 

public class BoardDAO { //MemberDAO

	private DBConnectionMgr pool=null;//1.얻어올 객체 선언
	//웹상에서 공통으로 사용할 멤버변수
	private Connection con=null;//DB접속할때 필요
	private PreparedStatement pstmt=null;//훨씬 속도가 더 빠르다 > stmt객체 보다
	private ResultSet rs=null;//select구문->표형태로 얻어오기
	private String sql="";//실행시킬 SQL구문 저장
	
	//2.생성자를 통해서 상대방의 객체를 생성해서 연결하라
	public BoardDAO() {
		try {
			pool=DBConnectionMgr.getInstance();
			System.out.println("pool=>"+pool);
		}catch(Exception e) {
			System.out.println("pool=>"+pool);
		}
	}
	
	//1.페이징처리를 위해서 전체 레코드수를 구해와야 된다.=>메서드
	//select count(*) from board //->select count(*) from member
	public int getArticleCount() {  //public int getMemberCount(){}
		int x=0;//레코드갯수
		
		try {
			con=pool.getConnection();
			System.out.println("con=>"+con);
			sql="select count(*) from board";//sql="select count(*) from member";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			//검색된 레코드갯수가 있다면
			if(rs.next()) {
				x=rs.getInt(1);    //변수명=rs.get자료형(필드명 또는 인덱스번호)
			}        //불러올 데이터가 필드명이 아니기에 select~from사이의 나오는 인덱스번호로 불러옴
		}catch(Exception e) {
			System.out.println("getArticleCount() 메서드 오류=>"+e);
		}finally {
			pool.freeConnection(con,pstmt,rs);
		}
		return x;
	}
	//2.글목록보기에 대한 메서드 구현->레코드가 한개이상->한 페이지당 10개씩 끊어서 보여주는 기술
	//1.레코드의 시작번호         2.불러올 레코드의 갯수(10,15,30~)
	//public Vector<ZipcodeBean>
	public List<BoardDTO> getArticles(int start,int end){
		
		List<BoardDTO> articleList=null;//ArrayList<BoardDTO> articleList=null;
		
		try {
			con=pool.getConnection();
			sql="select * from board order by ref desc,re_step asc limit ?,?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, start-1);//mysql은 레코드순번이 내부적으로 0부터 시작
			pstmt.setInt(2, end);//몇개씩 끊어서 보여줄것인지를 지정
			rs=pstmt.executeQuery();
			//페이징 처리에서는 기본적으로 누적의 개념을 도입
			//기존의 레코드외에 추가된 레코드를 첨부해서 다같이 보여줄려면 누적(do~while)
			if(rs.next()) {//레코드가 존재한다면(최소 만족 1개)
				//articleList=new List()(X)
				//형식) articleList = new 자식클래스명();
				articleList=new ArrayList<BoardDTO>(end);//10->10개만 저장가능한 데이터 저장공간이 만들어진다
			    do {
			    	BoardDTO article=new BoardDTO();//MemberDTO mem=new MemberDTO()
			    	article.setNum(rs.getInt("num"));
			    	article.setWriter(rs.getString("writer"));
			    	article.setEmail(rs.getString("email"));
			    	article.setSubject(rs.getString("subject"));
			    	article.setPasswd(rs.getString("passwd"));
			    	article.setReg_date(rs.getTimestamp("reg_date"));//오늘날짜
			    	//정수값(조회수,답변에 대한 필드)
			    	article.setReadcount(rs.getInt("readcount"));//default->0
			    	article.setRef(rs.getInt("ref"));//그룹번호
			    	article.setRe_step(rs.getInt("re_step"));//답변글의 순서
			    	article.setRe_level(rs.getInt("re_level"));//들여쓰기
			    	article.setContent(rs.getString("content"));//글내용
			    	article.setIp(rs.getString("ip"));//글쓴이의 ip주소
			    	//레코드를 찾을때마다.
			    	articleList.add(article);//vecList.add(zipbean);
			    	//--------------------------
			    }while(rs.next());
			}
			
		}catch(Exception e) {
			System.out.println("getArticles() 메서드 오류발생=>"+e);
		}finally {
			pool.freeConnection(con,pstmt,rs);
		}
		return articleList;
	}
	
	
	
	
	
}
