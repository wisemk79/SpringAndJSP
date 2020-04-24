<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><tiles:insertAttribute name="title" /></title>
</head>
<body>
   <table border="1" cellpadding="0" cellspacing="1" 
                                bgcolor="#a0a0a0" width="100%">
    <tr height="100" valign="middle" bgcolor="#ffffff">
        <td colspan="2">
           <tiles:insertAttribute name="header" />
        </td>
    </tr>
    
    <tr height="600" bgcolor="#ffffff">
       <td width="15%" valign="top">
           <tiles:insertAttribute name="menu" />
       </td>
      <td width="85%" valign="top">
          <tiles:insertAttribute name="body" />
       </td>
    </tr>
    
    <tr height="100" valign="middle" bgcolor="#ffffff">
        <td colspan="2">
           <tiles:insertAttribute name="footer" />
        </td>
    </tr>
   </table>
</body>
</html>





