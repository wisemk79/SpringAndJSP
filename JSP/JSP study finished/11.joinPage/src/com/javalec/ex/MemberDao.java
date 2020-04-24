package com.javalec.ex;

import java.sql.*;
import javax.sql.*;
import javax.naming.*;

public class MemberDao {
	
	public static final int MEMBER_NONEXISTENT = 0;
	public static final int MEMBER_EXISTENT = 1;
	public static final int MEMBER_JOIN_FAIL = 0;
	public static final int MEMBER_JOIN_SUCCESS = 1;
	public static final int MEMBER_LOGIN_PW_NO_GOOD = 0;
	public static final int MEMBER_LOGIN_SUCCESS = 1;
	public static final int MEMBER_LOGIN_IS_NOT = -1;
	public static final int MEMBER_UPDATE_SUCCESS = 1;
	
	private DataSource dataSource;
	
	//	싱글톤 패턴 
	// memberDao의 생성자는 private이다 . 
	private static MemberDao instance = new MemberDao();//자신이 자신의 클래스를 생성해서 자신을 참조하고 있는 변수 (싱글톤 패턴)
	//이렇게하면 이객체는 하나만 만들어지고 그 하나만 만들어진 객체를 모든곳에서 공유해서 사용할 수 있다.
	
	private MemberDao() {
	//이생성자는 private으로 선언되었기 때문에 생성자에 접근이 불가하여 생성할 수 없다. 
	//대신 getInstance()메소드는 static이기 때문에 바로 접근할 수 있다.
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static MemberDao getInstance() {// 인스턴스를 가져오는 getter 
		return instance;
	}
	
	
	public int insertMember(MemberDto dto) {
		int ri = 0;
		
		Connection connection;
		PreparedStatement pstmt;
		String query = "insert into members values(?,?,?,?,?,?)";
		
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.geteMail());
			pstmt.setTimestamp(5, dto.getrDate());
			pstmt.setString(6, dto.getAddress());
			pstmt.executeUpdate();
			ri = MemberDao.MEMBER_JOIN_SUCCESS;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return ri;
	}
	
	
	public int confirmId(String id) {
		int ri = 0;
		
		Connection connection;
		PreparedStatement pstmt;
		ResultSet resultSet;
		String query = "select id from members where id = ?";
		
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, id);
			resultSet = pstmt.executeQuery();
			
			//데이터가 있다면, 아이디가 일치한다면 
			if(resultSet.next()) {
				ri = MemberDao.MEMBER_EXISTENT;
			}else {
				//데이터가 없다 아이디가 불일치하다면 
				ri = MemberDao.MEMBER_NONEXISTENT;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return ri;
	}
	
	public int userCheck(String id, String pw) {
		int ri = 0;
		String dbPw;
		
		Connection connection;
		PreparedStatement pstmt;
		ResultSet resultSet;
		String query = "select pw from members where id = ?";
		
		
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, id);
			resultSet = pstmt.executeQuery();
			
			if(resultSet.next()) {
				dbPw = resultSet.getString("pw");
				if(dbPw.equals(pw)) {
					ri = MemberDao.MEMBER_LOGIN_SUCCESS;//login ok
				}else {
					ri =MemberDao.MEMBER_LOGIN_PW_NO_GOOD;// password no
				}
			}else {
				ri = MemberDao.MEMBER_LOGIN_IS_NOT;// 회원 아님 
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
			
		return ri;
	}
	
	public MemberDto getMember(String id) {
		Connection connection;
		PreparedStatement pstmt;
		ResultSet resultSet;
		String query = "select * from members where id=?";
		MemberDto dto = null;
		
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, id);
			resultSet = pstmt.executeQuery();
			
			if(resultSet.next()) {
				dto = new MemberDto();
				dto.setId(resultSet.getString("id"));
				dto.setPw(resultSet.getString("pw"));
				dto.setName(resultSet.getString("name"));
				dto.seteMail(resultSet.getString("eMail"));
				dto.setrDate(resultSet.getTimestamp("rDate"));
				dto.setAddress(resultSet.getString("address"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return dto;
	}
	
	public int updateMember(MemberDto dto) {
		int ri = 0;
		Connection connection;
		PreparedStatement pstmt;
		String query = "update members set pw=?, eMail=?, address=? where id=?";
		
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, dto.getPw());
			pstmt.setString(2, dto.geteMail());
			pstmt.setString(3, dto.getAddress());
			pstmt.setString(4, dto.getId());
			pstmt.executeUpdate();
			ri = MEMBER_UPDATE_SUCCESS;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ri;
	}
	
	}

