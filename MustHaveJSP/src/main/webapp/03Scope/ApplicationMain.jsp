<%@ page import="java.util.HashMap"%>
<%@ page import="common.Person"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head><title>application 영역</title></head>
<body>
    <h2>application 영역의 공유</h2>
    <%
    Map<String, Object> maps = new HashMap<>();
    maps.put("actor1", new Person("이수일", 30));
    maps.put("actor2", new Person("심순애", 28));
    maps.put("IntegerValue", 1000);
    maps.put("StringValue", "문자열 데이터");
    
    ArrayList<String> lists = new ArrayList<String>();
    lists.add("리스트");
    lists.add("컬렉션");
    maps.put("ArrayListValue", lists);
    application.setAttribute("maps", maps);
    %>
    application 영역에 속성이 저장되었습니다.
</body>
</html>