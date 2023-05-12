<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	application 객체는 하나의 톰캣 서버라고 생각하면 된다. (was 서버)
	session 영역 : 클라이언트가 처음 접속한 후 웹 브라우저를 닫을 때까지 공유
	request 영역 : 포워드를 하면 request 를 가지고 다음 페이지로 이동한다.
		브라우저(request) -> 서버 페이지 A(forward, request) -> 서버 페이지 B
		
	bean : 작은 객체
		속성은 private 이어야 함, getter setter 로만 접근
</body>
</html>