<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예외처리해주는 액션태그(catch)</title>
</head>
<body>
<%
   /*
     try{ 에러문장  }catch(Exception 예외처리객체명(ex)){ e.getMessage(),e.toString()}
                형식) c:catch var="예외처리객체명"
   */
%>
<c:catch var="ex">
  name의 매개변수명:<%=request.getParameter("name") %>
   <%
        if(request.getParameter("name").equals("test")) { %>
        	${param.name} 은 test 입니다.
     <%   } %>
</c:catch>
<%-- <c:if test="${ex!=null}"> ex==null  (empty ex) --%>
<c:if test="${not empty ex }" >
      예외가 발생하였습니다.<br>
      ${ex}
</c:if>
</body>
</html>









