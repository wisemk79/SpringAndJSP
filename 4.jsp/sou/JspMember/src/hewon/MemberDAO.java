package hewon;

import java.sql.*;//DB관리
import java.util.*;//자료구조->Vector,ArrayList,HashMap,,

//DAO->DB에 연결해서 테이블의 특정자료를 꺼내와서 웹에 출력시켜주는 역할
//CRUD(insert,update,delete,select)를 주로해주는 메서드를 작성

public class MemberDAO {

	//1.DBConnectionMgr와 연결->has a 관계 1
	private DBConnectionMgr pool=null;//1)상대방의 객체를 선언
	//2.공통으로 접속할 경우 필요한 멤버변수
	private Connection con=null;
	private PreparedStatement pstmt=null;//SQL구문
	private ResultSet rs=null;//검색된 데이터 저장
	private String sql="";//실행시킬 SQL구문 저장
	
	//2.생성자를 통해서 객체를 얻어오는 구문 작성->has a 관계 2
	public MemberDAO() {
		try {
			pool=DBConnectionMgr.getInstance();//정적메서드호출
			System.out.println("pool=>"+pool);
		}catch(Exception e) {
			System.out.println("DB연결 실패=>"+e);//e.toString()
		}
	}
	
	//3.업무에 요구분석->어떠한 기능이 필요
	//1)회원 로그인 기능
	//형식) public 반환형 메서드명(입력받은 갯수만큼 매개변수부여){ SQL작성 }
	//select id,passwd from member where id='nup' and passwd='1234';
	public boolean loginCheck(String id,String passwd) {
		//1.DB연결
		boolean check=false;
		//2.실행시킬 SQL구문 처리
		try {
			con=pool.getConnection();
			System.out.println("con=>"+con);
			sql="select id,passwd from member where id=? and passwd=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);//1.?의 순서 2.저장할값(=매개변수)
			pstmt.setString(2, passwd);
			rs=pstmt.executeQuery();
			check=rs.next();//데이터가 존재->true,없으면 false
		}catch(Exception e) {
			System.out.println("loginCheck()실행 에러유발=>"+e);
		}finally {//3.DB연결해제
			pool.freeConnection(con, pstmt, rs);
		}
		
		return check;
	}
	
	//2.회원가입->중복id를 체크해주는 메서드 필요->select(반환형값이 존재),where조건식(매개변수O)
	//SQL> select id from member where id='kkk';
	public boolean checkId(String id) {
		//DB연결
		boolean check=false;
		//SQL구문
		try {
			con=pool.getConnection();
			sql="select id from member where id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			check=rs.next();//데이터 존재 true or 없으면 =>false
		}catch(Exception e) {
			System.out.println("checkId()에러유발=>"+e);
		}finally {//DB메모리 해제
			pool.freeConnection(con, pstmt, rs);
		}
		return check;
	}
	
	
	//3.우편번호->우편번호 검색->자동으로 주소를 입력
	//sql>select * from zipcode where area3 like '미아3동%';
   public Vector<ZipcodeDTO> zipcodeRead(String area3){
	   Vector<ZipcodeDTO> vecList=new Vector();//찾은 데이터를 담아야 되기때문에
	   
	   try {
		   con=pool.getConnection();
		   //sql="select * from zipcode where area3 like '미아3동%'";
		   sql="select * from zipcode where area3 like  '"+area3+"%'";
		   System.out.println("검색된 SQL구문(sql)=>"+sql);
		   pstmt=con.prepareStatement(sql);
		   rs=pstmt.executeQuery();
		   //찾은 레코드가 한개 if(rs.next()), 한개이상->while(rs.next())
		   while(rs.next()) {//찾은 레코드가 있어서 이동할 수 있다면
			   //Vecotr or ZipcodeDTO에 담을 수도 있다.(rs.getXXX(필드명)
			   ZipcodeDTO tempZipcode=new ZipcodeDTO();
			   //필드별로 담고,필드별로 꺼내기가 쉽게 하기위해서
			   tempZipcode.setZipcode(rs.getString("zipcode"));//("142-803")
			   tempZipcode.setArea1(rs.getString("area1"));
			   tempZipcode.setArea2(rs.getString("area2"));
			   tempZipcode.setArea3(rs.getString("area3"));
			   tempZipcode.setArea4(rs.getString("area4"));
			   //벡터또는 ArrayList에 저장구문
			   vecList.add(tempZipcode);
		   }
	   }catch(Exception e) {
		   System.out.println("zipcodeRead() 실행오류=>"+e);
	   }finally {
		  pool.freeConnection(con, pstmt, rs); 
	   }
	   return vecList;//웹상에서 호출한 메서드에게 전달
   }
	
	//4.회원가입->오라클(실무)(트랜잭션처리) or MySQL(외부의 도메인 등록업체)(트랜잭션처리X)
   //insert into member values(?,?,,,,)=>SQL의 성공유무=>반환값 1(성공) 0 (실패)
   //메서드의 반환값X  매개변수 O
	public boolean memberInsert(MemberDTO member) {//웹에서 이미 저장된 상태
		boolean check=false;//회원가입 성공유무
		
		try {
			con=pool.getConnection();
			//-트랜잭션 시작처리->여러개의 SQL구문을 하나의 작업단위로 묶어주는것
			con.setAutoCommit(false);//자동 commit을 하지 못하도록 설정
			//SQL->insert와 update는 기본 데이터 저장 로직은 같다.(SQL구문만 다르다.)
			sql="insert into member values(?,?,?,?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);//NullPointerException
			pstmt.setString(1, member.getMem_id());
			pstmt.setString(2, member.getMem_passwd());
			pstmt.setString(3, member.getMem_name());
			pstmt.setString(4, member.getMem_email());
			pstmt.setString(5, member.getMem_phone());
			pstmt.setString(6, member.getMem_zipcode());
			pstmt.setString(7, member.getMem_address());
			pstmt.setString(8, member.getMem_job());
			int insert=pstmt.executeUpdate();//1(성공),0(실패)
			System.out.println("insert(데이터 입력유무)=>"+insert);//1 or 0
			con.commit();//실질적으로 테이블에 저장이 된다.
			if(insert > 0) { //if(insert==1){
				check=true;//데이터 성공확인
			}
		}catch(Exception e) {
			System.out.println("memberInsert() 실행오류=>"+e);
		}finally {
			pool.freeConnection(con, pstmt);
		}
		return check;
	}
	//5)회원수정->회원수정을 하기위한 회원 찾는 메서드=>특정상품 코드 찾기
	//select * from member where id='nup';
	public MemberDTO getMember(String mem_id) {  //public Scanner getScan()
		MemberDTO member=null;//id값에 해당되는 레코드 한개
		
		try {
			con=pool.getConnection();
			sql="select * from member where id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, mem_id);
			rs=pstmt.executeQuery();
			//찾은 레코드가 한개 있다면
			if(rs.next()) {
				member=new MemberDTO();
				//찾은 필드값->Setter Method 저장->웹에 출력->필드별로 Getter Method 호출
				member.setMem_id(rs.getString("id"));
				member.setMem_passwd(rs.getString("passwd"));
				member.setMem_name(rs.getString("name"));
				member.setMem_phone(rs.getString("phone"));
				member.setMem_zipcode(rs.getString("zipcode"));
				member.setMem_address(rs.getString("address"));
				member.setMem_email(rs.getString("e_mail"));
				member.setMem_job(rs.getString("job"));
				//ArrayList에 저장하고 나서 계속 담는 작업->list.add(member);
			}
		}catch(Exception e) {
			System.out.println("getMember() 실행오류=>"+e);
		}finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return member;
	}
	
	//6)찾은 회원을 가지고 수정(회원수정)
	public boolean memberUpdate(MemberDTO member) {//변경된 수정,나머지는 그대로
		
     boolean check=false;//회원수정 성공유무
		
		try {
			con=pool.getConnection();
			//-트랜잭션 시작처리->여러개의 SQL구문을 하나의 작업단위로 묶어주는것
			//insert,update,delete만 트랜잭션 처리해준다.
			con.setAutoCommit(false);//자동 commit을 하지 못하도록 설정
			//SQL->insert와 update는 기본 데이터 저장 로직은 같다.(SQL구문만 다르다.)
			sql="update member set passwd=?,name=?,e_mail=?,phone=?,"
					+" zipcode=?,address=?,job=?  where id=?";
			pstmt=con.prepareStatement(sql);//NullPointerException
			
			pstmt.setString(1, member.getMem_passwd());
			pstmt.setString(2, member.getMem_name());
			pstmt.setString(3, member.getMem_email());
			pstmt.setString(4, member.getMem_phone());
			pstmt.setString(5, member.getMem_zipcode());
			pstmt.setString(6, member.getMem_address());
			pstmt.setString(7, member.getMem_job());
			pstmt.setString(8, member.getMem_id());//id값에 해당되는 데이터를 찾기위해서
			
			int update=pstmt.executeUpdate();//1(성공),0(실패)
			System.out.println("update(데이터 수정유무)=>"+update);//1 or 0
			con.commit();//실질적으로 테이블에 저장이 된다.
			if(update==1) {
				check=true;//데이터 수정성공확인
			}
		}catch(Exception e) {
			System.out.println("memberUpdate() 실행오류=>"+e);
		}finally {
			pool.freeConnection(con, pstmt);
		}
		return check;
	}
	
	//7)회원 탈퇴=>sql구문
	//하나의 메서드에 여러개의 SQL구문이 나올 수가 있다.=>All or Nothing(원자성)
	//select passwd from member where id=?
	//delete from member where id=?
	public int deleteMember(String id,String passwd) {
		String dbpasswd="";//DB상에서 찾은 암호를 저장
		int x=-1;//회원탈퇴 유무->1(성공),0(실패)
		
		try {
			con=pool.getConnection();
			con.setAutoCommit(false);//트랜잭션 시작
			//1.id값에 해당하는 암호를 먼저 찾기
			pstmt=con.prepareStatement("select passwd from member where id=?");
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			//암호가 존재한다면
			if(rs.next()) {
			    dbpasswd=rs.getString("passwd");//rs.getString(1)
			    System.out.println("dbpasswd=>"+dbpasswd);//암호 확인용->나중에 제거
				//2.dbpasswd(DB상에서 찾은 암호)==passwd(웹상에서 입력한 값)
			    if(dbpasswd.contentEquals(passwd)) {
			    	pstmt=con.prepareStatement("delete from member where id=?");
			    	pstmt.setString(1, id);
			    	int delete=pstmt.executeUpdate();
			    	System.out.println("delete(회원탈퇴 성공유무)=>"+delete);
			    	con.commit();
			    	x=1;//회원 탈퇴 성공
			    }else {
			    	x=0;//회원탈퇴 실패->암호가 틀린 경우
			    }	
			}else {
				x=-1;//암호가 존재하지 않은 경우
			}
		}catch(Exception e) {
			System.out.println("deleteMember()오류 확인=>"+e);
		}finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return x;//-1,1,0
	}
	//회원리스트->페이징 처리->게시판의 페이징처리를 배운뒤에 할것.
}









