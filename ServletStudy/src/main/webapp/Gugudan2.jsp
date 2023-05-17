<%@page import="javax.security.auth.message.callback.PrivateKeyCallback.Request"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String type = request.getParameter("type");
    String snum = request.getParameter("num");
    String scol = request.getParameter("col");
    
    if(type == null) {
    	type = "list";
    }
    
    int num = 2;
    if(snum != null) {
    	num = Integer.parseInt(snum);
    }

    int col = 3;
    if(scol != null) {
    	col = Integer.parseInt(scol);
    }
    
    int lastNum = num + col - 1;
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단 서블릿 2</title>
</head>
<body>
	<h3> 구구단 v2</h3>
	<h5> <%= num %> ~ <%= lastNum %> 단</h5>
	
	<%
	if(type.equals("list")) {
		out.print("<ul>");

		for (int i=1; i<=9; i++) {
			out.print("<li><pre>");
			for (int d=num; d<=lastNum; d++) {
				out.print(d + " x " + i + " = " + (d * i));
				out.print("\t");
			}			
			out.print("</pre></li>");
		}
		
		out.print("<ul>");
	} else if(type.equals("table")) {
		out.print("<table border=1>");
		
		for (int i=1; i<=9; i++) {
			out.print("<tr>");
			for (int d=num; d<=lastNum; d++) {
				out.print("<td>");
				out.print(d + " x " + i + " = " + (d * i));
				out.print("</td>");
			}			
			out.print("</tr>");
		}

		out.print("</table>");
	}
	
	%>

</body>
</html>