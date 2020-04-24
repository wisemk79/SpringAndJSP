<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//JNDI로부터 DataSource를 얻는다. // Get DataSource
		Context ctx = new InitialContext();
		DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/oracle11g");
		
		Connection conn = null;
		Statement stmt = null;
		
		
		try{
			//데이터소스와 db연결해서 명령객체를 가지고온다.
			conn = ds.getConnection();
			stmt = conn.createStatement();
			
			//쿼리문실행
			try{
				stmt.execute("select * from member");
				
				//결과 레코드 및 메타데이터
				ResultSet r = stmt.getResultSet();
				while(r.next()){
					System.out.println("<br/>" + r.getString("memid"));
					System.out.println("<br/>" + r.getString("mempw"));
				}
				
				//자원해제
				stmt.close();
				conn.close();
				
	        } catch (SQLException se) {
	            out.println(se.toString());
	        } catch (Exception e) {
	            out.println(e.toString());
	        }
	   
	    } finally {
	      
	        try { if(stmt != null) stmt.close(); } catch (Exception e) {}
	        try { if(conn != null) conn.close(); } catch (Exception e) {}
	    }
		
	%>
</body>
</html>