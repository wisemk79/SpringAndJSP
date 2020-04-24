package com.bs.lec23.member.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.bs.lec23.member.Member;
//import com.mchange.v2.c3p0.DriverManagerDataSource;

@Repository
public class MemberDao implements IMemberDao {

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String userid = "scott";
	private String userpw = "tiger";
	
	//connection pool이용을위해서 c3p0 DriverManagerDataSource를 사용한다
	//private DriverManagerDataSource dataSource;
	private DriverManagerDataSource dataSource2;
	private JdbcTemplate template;
//	
//	private Connection conn = null;
//	private PreparedStatement pstmt = null;
//	private ResultSet rs = null;
	
	public MemberDao() {
		//한번 이렇게 생성자에 생성하고 나면 밑에서 기능마다 계속 연결시켜줄 필요가 없다.
		/*c3p0 방식 데이터소스 세팅방법
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClass(driver);
		dataSource.setJdbcUrl(url);
		dataSource.setUser(userid);
		dataSource.setPassword(userpw);
		*/
		
		//spring jdbc방식 세팅방법
		dataSource2 = new DriverManagerDataSource();
		dataSource2.setDriverClassName(driver);
		dataSource2.setUrl(url);
		dataSource2.setUsername(userid);
		dataSource2.setPassword(userpw);
		
		
		//템플릿객체생성을해서 위에 데이터소스를 세팅해주면 밑에서 매번 jdbc연결해줄 필요가 없어진다.
		template = new JdbcTemplate();
		template.setDataSource(dataSource2);
		
		
	}
	
	@Override
	public int memberInsert(Member member) {
		
		int result = 0;
		//쿼리를 준비하고 템플릿 업데이트를 이용하는데 첫번째인자로 쿼리문을 주고 나머지는 각 쿼리문에 맞는 값을 넣어준다.
		String query = "INSERT INTO member (memId, memPw, memMail) values (?,?,?)";
		//insert는 update 메소드를 사용한다.
		result = template.update(query, member.getMemId(), member.getMemPw(), member.getMemMail());
		
		//결과적으로 아래의 긴 과정이 생략된다.
//		try {
////			Class.forName(driver);
////			conn = DriverManager.getConnection(url, userid, userpw);
////			String sql = "INSERT INTO member (memId, memPw, memMail) values (?,?,?)";
////			pstmt = conn.prepareStatement(sql);
////			pstmt.setString(1, member.getMemId());
////			pstmt.setString(2, member.getMemPw());
////			pstmt.setString(3, member.getMemMail());
////			result = pstmt.executeUpdate();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if(pstmt != null) pstmt.close();
//				if(conn != null) conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
		
		return result;
		
	}

	@Override
	public Member memberSelect(Member member) {
		List<Member> members = null;
//		Member mem = null;
		String query = "SELECT * FROM member WHERE memId = ? AND memPw = ?";
		//select에서는 query메서드를 사용하는데 1.쿼리문 2. new PreparedStatementSetter() 3.new RowMapper<Member>()를 받는다.
		members = template.query(query, new Object[]{member.getMemId(), member.getMemPw()}, new RowMapper<Member>() {

			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member mem = new Member();
				//rs를 통해 위 쿼리작동 결과 값을 가져와 멤버 객체에 set해주고 리턴해준다.
				mem.setMemId(rs.getString("memId"));
				mem.setMemPw(rs.getString("memPw"));
				mem.setMemMail(rs.getString("memMail"));
				mem.setMemPurcNum(rs.getInt("memPurcNum"));
				return mem;
			}
			
		});
		
		//데이터가 없다면.
		if(members.isEmpty()) 
			return null;
		
		//데이터가 있다면, 첫번째에있는것을 리턴해준다.
		return members.get(0);
		
//		
//		
//		try {
//			
//			Class.forName(driver);
//			conn = DriverManager.getConnection(url, userid, userpw);
//			String sql = "SELECT * FROM member WHERE memId = ? AND memPw = ?";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, member.getMemId());
//			pstmt.setString(2, member.getMemPw());
//			rs = pstmt.executeQuery();
//			
//			while (rs.next()) {
//				String memId = rs.getString("memid");
//				String memPw = rs.getString("mempw");
//				String memMail = rs.getString("memMail");
//				int memPurcNum = rs.getInt("memPurcNum");
//				
//				mem = new Member();
//				mem.setMemId(memId);
//				mem.setMemPw(memPw);
//				mem.setMemMail(memMail);
//				mem.setMemPurcNum(memPurcNum);
//			}
//			
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if(rs != null) rs.close();
//				if(pstmt != null) pstmt.close();
//				if(conn != null) conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		
//		return mem;
//		
	}

	@Override
	public int memberUpdate(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int memberDelete(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

//	@Override
//	public int memberUpdate(Member member) {
//		
//		int result = 0;
//		
//		try {
//			
//			Class.forName(driver);
//			conn = DriverManager.getConnection(url, userid, userpw);
//			String sql = "UPDATE member SET memPw = ?, memMail = ? WHERE memId = ?";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, member.getMemPw());
//			pstmt.setString(2, member.getMemMail());
//			pstmt.setString(3, member.getMemId());
//			result = pstmt.executeUpdate();
//			
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if(pstmt != null) pstmt.close();
//				if(conn != null) conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		
//		return result;
//		
//	}
//
//	@Override
//	public int memberDelete(Member member) {
//		
//		int result = 0;
//		
//		try {
//			
//			Class.forName(driver);
//			conn = DriverManager.getConnection(url, userid, userpw);
//			String sql = "DELETE member WHERE memId = ? AND memPw = ?";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, member.getMemId());
//			pstmt.setString(2, member.getMemPw());
//			result = pstmt.executeUpdate();
//			
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if(pstmt != null) pstmt.close();
//				if(conn != null) conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		
//		return result;
//		
//	}

}