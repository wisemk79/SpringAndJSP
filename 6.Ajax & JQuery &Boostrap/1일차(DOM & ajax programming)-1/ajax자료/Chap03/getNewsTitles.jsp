<%@ page contentType="text/plain; charset=euc-kr" %>
<%
	String [] titles = {"��� �ϳ�", "�ι�° ���", "�� �ٸ� ����° ���"};
	String sSStrong = "<strong>";
	String sEStrong = "</strong>";
	for(int i = 0; i <titles.length; ++i)
	{
%>
<% 
		if(i==0) { %>
			<%= sSStrong %>
<% 
		}
%>
		<%= titles[i] %>
<%	
		if(i==0) { %>
			<%= sEStrong %>
<%
		}
%>
		<br>
<%
	} // end of for
%>
