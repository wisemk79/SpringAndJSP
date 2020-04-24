<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.javalec.daotoex.*" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		MemberDAO memberDAO = new MemberDAO();
		ArrayList<MemberDTO> dtos = memberDAO.memberSelect();//dto객체를 어레이리스트로 받아 배열을 생성한다. 
		
		for(int i=0; i < dtos.size(); i++){
			MemberDTO dto = dtos.get(i);//dtos에서 하나의 dto객체를 가져온다.
			String name = dto.getName();
			String id = dto.getId();
			String pw = dto.getPw();
			String phone = dto.getPhone1() + " - " + dto.getPhone2() + " - " + dto.getPhone3();
			String gender = dto.getGender();
			
			
			out.println("name: " + name + ", id: " + id + ", pw: " + pw + ", phone: " + phone + ", gender: " + gender + "<br/>");
		}
		
	%>
</body>
</html>