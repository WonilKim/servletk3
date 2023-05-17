<%@page import="javax.security.auth.message.callback.PrivateKeyCallback.Request"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String type = request.getParameter("type");
    String snum = request.getParameter("num");
    
    if(type == null) {
    	type = "list";
    }
    
    int num = 2;
    if(snum != null) {
    	num = Integer.parseInt(snum);
    }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단 서블릿</title>
</head>
<body>
	<h3> 구구단 </h3>
	<h5><%= num %> 단</h5>
	
	<%
	if(type.equals("list")) {
		out.print("<ul>");
		
		for (int i=1; i<9; i++) {
			out.print("<li>");
			out.print(num + " x " + i + " = " + (num * i));
			out.print("</li>");
		}
		out.print("<ul>");
	} else if(type.equals("table")) {
		out.print("<table border=1>");
		
		for (int i=1; i<9; i++) {
			out.print("<tr><td>");
			out.print(num + " x " + i + " = " + (num * i));
			out.print("</td></tr>");
		}
		out.print("</table>");
	}
	
	%>

</body>
</html>