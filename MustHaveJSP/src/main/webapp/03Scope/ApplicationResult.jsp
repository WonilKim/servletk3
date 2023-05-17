<%@ page import="java.util.Set"%>
<%@ page import="common.Person"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head><title>application 영역</title></head>
<body>
    <h2>application 영역의 속성 읽기</h2>
    <%
    Map<String, Object> maps
            = (Map<String, Object>)application.getAttribute("maps");
    Set<String> keys = maps.keySet(); 
    for (String key : keys) {
    	Object obj = maps.get(key);
    	if(obj instanceof Person) {
	        Person person = (Person)maps.get(key);
	        out.print(String.format("이름 : %s, 나이 : %d<br/>", 
	                person.getName(), person.getAge()));
	    } else if(obj instanceof ArrayList) {
	    	ArrayList<String> lists = (ArrayList<String>)maps.get(key);
	    	out.print(" key = " + key);
	    	for(String str : lists) {
	    		out.print(", value = " + str);
	    	}
	    	out.print("<br/>");
	    } else {
	    	out.print(" key = " + key + ", value = " + obj + "<br/>");
	    	
	    }
    }  
    %>
</body>
</html>