<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!// 선언부 (HttpServlet 을 상속받은 클래스의 멤버 변수 및 메소드로 정의됨)
	public int add(int num1, int num2) {
		return num1 + num2;
	}%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스크립트 요소</title>
</head>
<body>
	<%
	// 스크립틀릿 (자바 코드)
	// 구현부 (HttpServlet 을 상속받은 클래스의 service 함수 내부에 구현됨.)
	String snum1 = request.getParameter("num1");
	String snum2 = request.getParameter("num2");

	System.out.println(snum1);
	System.out.println(snum2);

	if (snum1 == null)
		snum1 = "10";
	if (snum2 == null)
		snum2 = "20";

	int num1 = Integer.parseInt(snum1);
	int num2 = Integer.parseInt(snum2);

	int result = add(num1, num2);
	%>
	
	<h3>파라미터 테스트</h3>
	덧셈 결과 1 :
	<!-- 표현식 (변수) -->
	<%=result%>
	<br /> 덧셈 결과 2 :
	<!-- 표현식 (함수) -->
	<%=add(result, result + num1)%>
	<br />

</body>
</html>