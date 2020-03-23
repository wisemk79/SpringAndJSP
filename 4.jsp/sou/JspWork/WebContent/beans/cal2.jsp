<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="ca"  class="calc.CalcBean" scope="page" />
<jsp:setProperty  name="ca" property="*" />
<%  ca.calculate();  %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>요청을 하는 페이지(빈즈이용)</title>
</head>
<body>
<center>
  <h3>간단한 계산기(요청,응답을 하나의 페이지에서 작성(Ajax))</h3>
  <!-- <form name="form1" method="post" action="cal2.jsp"> -->
   <form name="form1" method="post">
    <input type="text" name="num1" width="200" size="5">
      <select name="operator">
        <option selected>+</option>
        <option>-</option>
        <option>*</option>
        <option>/</option>
      </select>
    <input type="text" name="num2" width="200" size="5"><p>
    <input type="submit" value="계산">
    <input type="reset" value="다시입력">
  </form>
  <hr>
  계산결과:<%=ca.getResult() %><br>
  계산결과2:<jsp:getProperty name="ca" property="result" />
</center>
</body>
</html>



