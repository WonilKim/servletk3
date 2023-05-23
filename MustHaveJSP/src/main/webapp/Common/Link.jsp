<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

			<!-- 로그인 여부에 따른 메뉴 변화 -->
			<nav><ul>
				<%
				if (session.getAttribute("UserId") == null) {
				%>
				<li><a href="../06Session/LoginForm.jsp">로그인</a></li>
				<%
				} else {
				%>
				<li><a href="../06Session/Logout.jsp">로그아웃</a></li>
				<%
				}
				%>
				<!-- 8장과 9장의 회원제 게시판 프로젝트에서 사용할 링크 -->
				<li><a href="../08Board/List.jsp">게시판(페이징X)</a></li>
				<li><a href="../09PagingBoard/List.jsp">게시판(페이징O)</a></li>
			</ul></nav>
