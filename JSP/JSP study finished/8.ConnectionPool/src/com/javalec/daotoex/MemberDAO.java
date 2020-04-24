package com.javalec.daotoex;

import java.sql.*;
import java.util.ArrayList;

public class MemberDAO {
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String uid = "scott";
	private String upw = "tiger";
	
	public MemberDAO() {
		//생성만 하면 드라이버를 로드한다. 
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//memberSelect가 호출된다. 
	public ArrayList<MemberDTO> memberSelect(){
		
		ArrayList<MemberDTO> dtos = new ArrayList<MemberDTO>();
		
		Connection con;
		Statement stmt;
		ResultSet rs;
		
		try {
			con = DriverManager.getConnection(url, uid, upw);
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from member");
			
			while(rs.next()) {
				String name = rs.getString("name");
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String phone1 = rs.getString("phone1");
				String phone2 = rs.getString("phone2");
				String phone3 = rs.getString("phone3");
				String gender = rs.getString("gender");
				
				MemberDTO dto = new MemberDTO(name, id, pw, phone1, phone2, phone3, gender);
				dtos.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return dtos;
		
	
	}
}
