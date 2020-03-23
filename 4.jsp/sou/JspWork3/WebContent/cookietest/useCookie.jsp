<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키를 확인</title>
</head>
<body>
  <h1>웹브라우저에 저장된 쿠키를 가져오는 예제</h1>
  <%
    Cookie  cookies[]=request.getCookies();//모든 쿠키를 가져오는 메서드(배열로 받아옴)
    if(cookies!=null){//검색할 쿠키의 정보가 들어있다면
    	for(int i=0;i<cookies.length;i++){
    		//mycookie찾기(쿠키값,쿠키이름)
    		if(cookies[i].getName().equals("mycookie")){ %>
    			cookieName:<%=cookies[i].getName()%><br>
    			cookieValue:<%=cookies[i].getValue()%><br>
 <% 
    		}//inner if
    	}//inner for
    }//outer if
  
  %>
</body>
</html>





