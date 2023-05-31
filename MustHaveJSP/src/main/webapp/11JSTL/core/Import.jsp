<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>JSTL - import</title></head>
<body>
    <c:set var="requestVar" value="MustHave" scope="request" />
    <!-- import 할때 var 속성을 지우면 import 태그 위치에 바로 import 된 페이지가 실행된다.
    var 속성이 있으면 url이 var 로 지정된 변수에 저장된다. el 로 변수를 호출한 곳에 페이지가 실행된다. -->
    <c:import url="/11JSTL/inc/OtherPage.jsp" var="contents">
        <c:param name="user_param1" value="JSP" />
        <c:param name="user_param2" value="기본서" />
    </c:import>       
    
    <h4>다른 문서 삽입하기</h4>
    ${contents }
    
    <h4>외부 자원 삽입하기</h4>    
    <iframe src="../inc/GoldPage.jsp" style="width:100%;height:600px;"></iframe>
</body>
</html>