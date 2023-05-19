<%@page import="java.sql.ResultSet"%>
<%@ page import="common.JDBCConnect"%>
<%@ page import="common.DBConnPool"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>JDBC</title>
</head>
<body>

	<h2>JDBC H2 테스트 2</h2>
	<%
	String driver = application.getInitParameter("H2Driver");
	String url = application.getInitParameter("H2URL");
	String id = application.getInitParameter("H2Id");
	String pwd = application.getInitParameter("H2Pwd");

	JDBCConnect jdbc2 = new JDBCConnect(driver, url, id, pwd);
	
	ResultSet rs = jdbc2.executeSelectQuery("select * from contact limit 10");
	JDBCConnect.showResultSetTable(out, rs);
	
	jdbc2.close();
	%>


</body>
</html>