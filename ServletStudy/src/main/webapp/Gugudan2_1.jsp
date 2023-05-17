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
    
    int lastNum = 9;
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단 서블릿 2</title>
</head>
<body>
	<h3> 구구단 v2</h3>
	<h5> 2 ~ 9 단</h5>
	
	<%
	int c = 0;
	
	if(type.equals("list")) {
		out.print("<ul>");

		for (int i=1; i<=9; i++) {
			for (int d=num; d<=lastNum; d++) {
				if (c==0) {
					out.print("<li><pre>");
				}
					
				out.print(d + " x " + i + " = " + (d * i));
				out.print("\t");
				
				c++;
				if(c == col) {
					out.print("</pre></li>");
					c=0;
				}
			}				
		}
		
		out.print("<ul>");
	} else if(type.equals("table")) {
		out.print("<table border=1>");
		
		for (int d=num; d<=lastNum; d++) {
			if (c==0) {
				out.print("<tr>");
			}
			
			out.print("<td><ul>");
			for (int i=1; i<=9; i++) {
				out.print("<li>");
				out.print(d + " x " + i + " = " + (d * i));
				out.print("</li>");
			}
			out.print("</ul></td>");
			
			c++;
			if(c == col) {
				out.print("</tr>");
				c=0;
			}
		}				

		out.print("</table>");
	}
	
	%>

</body>
</html>