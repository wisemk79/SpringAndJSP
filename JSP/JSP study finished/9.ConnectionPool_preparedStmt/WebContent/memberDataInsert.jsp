<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!
		Connection connection;
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String uid = "scott";
		String upw = "tiger";
	%>
	
	<%
		try{
			Class.forName(driver);
			connection = DriverManager.getConnection(url ,uid, upw);
			int n;
			String query = "insert into memberforpre(id, pw, name, phone) values(?,?,?,?)";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1,"abc");
			preparedStatement.setString(2,"123");
			preparedStatement.setString(3,"홍길동");
			preparedStatement.setString(4,"010-1234-5678");
			n = preparedStatement.executeUpdate();
			
			preparedStatement.setString(1,"def");
			preparedStatement.setString(2,"456");
			preparedStatement.setString(3,"홍길자");
			preparedStatement.setString(4,"010-9012-3456");
			n = preparedStatement.executeUpdate();
			
			preparedStatement.setString(1,"ghi");
			preparedStatement.setString(2,"789");
			preparedStatement.setString(3,"홍길순");
			preparedStatement.setString(4,"010-7890-1234");
			n = preparedStatement.executeUpdate();
			
			preparedStatement.setString(1,"AAA");
			preparedStatement.setString(2,"111");
			preparedStatement.setString(3,"이길동");
			preparedStatement.setString(4,"010-1234-1111");
			n = preparedStatement.executeUpdate();
			
			
			if(n == 1){
				out.println("insert success");
			}else{
				out.println("insert fail");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	%>
</body>
</html>