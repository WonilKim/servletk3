<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    request.setCharacterEncoding("UTF-8");  
    String sel = request.getParameter("sel");
    String type = request.getParameter("type");
    String val = request.getParameter("val");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GugudanMain</title>
</head>
<body>
	<h2>GugudanMain</h2>
	<%
	out.print("sel = " + sel);
	out.print("<br/>");
	out.print("val = " + val);
	
	if (sel.equalsIgnoreCase("gugudanType1")) {
	    response.sendRedirect("Gugudan1.jsp?type=" + type + "&num=" + val);
	}
	else if (sel.equalsIgnoreCase("gugudanType2")) {
	    response.sendRedirect("Gugudan2_1.jsp?type=" + type + "&col=" + val);
	}
	%>
</body>
</html>