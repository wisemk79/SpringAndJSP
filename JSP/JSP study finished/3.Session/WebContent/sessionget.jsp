<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- Enumeration은 import 해줘야한다.  -->
<%@ page import="java.util.Enumeration" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//get으로 가져온 세션값은 가져올때 처음 Object형태이기 때문에 String으로 변환시켜줘야한다.
		Object obj1 = session.getAttribute("mySessionName");
		String mySessionName = (String)obj1;
		out.println(mySessionName + "<br/>");
		//세션을 2개 만들었기 때문에 오브젝트 2개에 대한 값을 가져오고 각 값의 형태에맞게 형변환 시켜줘야한다.
		
		Object obj2 = session.getAttribute("myNum");
		Integer myNum = (Integer)obj2;
		out.println(myNum + "<br/>");
		
		out.println("=================<br/>");
		
		
		/*
		Enumertation 인터페이스 메서드는 아래와 같다.
		hasMoreElements() : 읽어올 요소가 남아있는지 확인. 있으면 true, 없으면 false. Iterator의 hasNext()와 같음
		nextElement() : 다음 요소를 읽어 옴. Iterator의 next()와 같음
		*/
		
		String sName, sValue;
		Enumeration enumeration = session.getAttributeNames();//모든 이름을 Enumeration객체를 이용하여 직렬화되게 다 얻어오는것 
		while(enumeration.hasMoreElements()){
			sName = enumeration.nextElement().toString();//다음 요소를 읽어 옴. Iterator의 next()와 같음
			sValue = session.getAttribute(sName).toString();
			
			out.println("sName: " + sName + "<br/>");
			out.println("sValue: " + sValue + "<br/>");
		}
		
		out.println("========================<br/>");
		
		
		String sessionID = session.getId();// 세션에 매칭되는 아이디를 가져올때 사용한다. 
		out.println("sessionID: " + sessionID + "<br/>");
		int sessionInter = session.getMaxInactiveInterval();// 유효시간을 가져올 때 사용한다. 
		out.println("sessionInter: " + sessionInter + "<br/>");
		
		session.removeAttribute("mySessionName");//mySessionName 세션정보를 삭제한다. 
		Enumeration enumeration1 = session.getAttributeNames();
		//세션의 이름들을 가져오는데, mySessionName은 삭제되었기 떄문에 세션 1개 만 남게되고,
		//myNum session만 남아있게 된다.
		
		while(enumeration1.hasMoreElements()){//1개만 있기 때문에 1번만 돌게되고 
			sName = enumeration1.nextElement().toString();// myNum 세션의 요소를 읽어와 그 이름을 넣어주고 (myNum이 들어감)
			sValue = session.getAttribute(sName).toString();// myNum 세션의 값을 가져온다. (12345)
			out.println("sName: " + sName + "<br/>");
			out.println("sValue: " + sValue + "<br/>");
		}
		
		
		out.println("==========================<br/>");
		
		
		session.invalidate();// 세션에 있는 모든 데이터를 삭제한다. 
		if(request.isRequestedSessionIdValid()){//리퀘스트에 유효한 세션이 있는지 확인하는 메소드이다. 
			out.println("session valid");
		}else{
			out.println("session invalid");
		}
	%>
</body>
</html>