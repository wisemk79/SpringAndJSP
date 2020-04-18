<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!
		Connection connection;
		Statement statement;
		ResultSet resultSet;
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String uid = "scott";
		String upw = "tiger";
		String query = "select * from member";
	%>
	
	<%
		
			Class.forName(driver);//"oracle.jdbc.driver.OracleDriver"
			connection = DriverManager.getConnection(url,uid,upw);//"jdbc:oracle:thin:@localhost:1521:xe"
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);//resultSet으로 쿼리 결과값을 받아온다. 

			/*
			resultSet관련 메소드 
			next(): 다음 레코드로 이동 
			previous(): 이전 레코드로 이동
			first(): 처음으로 이동 
			last(): 마지막으로 이동 
			getString: get메소드 
			getInt: get메소드 
			*/
			
			//resultSet의 각각의 로우 데이터를 가져온다.
			while(resultSet.next()){
				String id = resultSet.getString("id");
				String pw = resultSet.getString("pw");
				String name = resultSet.getString("name");
				String phone1 = resultSet.getString("phone1");
				
				
				out.println("아이디: " + id + ", 비밀번호: " + pw + ",이름: " + name + ", 전화번호: " + phone1 +"<br/>");
			}

			try{
				if(resultSet != null) resultSet.close();
				if(statement != null) statement.close();
				if(connection != null) connection.close();
			}catch(Exception e){}
		
	
	%>
</body>
</html>