package edu.servlet.pnu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/myservlet05")
public class MyServlet05 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("MyServlet05");
		
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println("");
		out.println("<table border=3>");
		out.println("<tr>");
		out.println("	<th>번호</th><th>나라</th><th>수도</th><th>인구</th>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("	<td>1</td><td>대한민국</td><td>서울</td><td>1000만</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("	<td>2</td><td>미국</td><td>워싱턴</td><td>70만</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("	<td>3</td><td>일본</td><td>도쿄</td><td>1400만</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("	<td>4</td><td>중국</td><td>베이징</td><td>2100만</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("");
		out.println("");
//		out.println("<style>");
//		out.println("	table, th, td {");
//		out.println("		border:1px solid black;");
//		out.println("	}");
//		out.println("</style>");
		
		out.close();
	}
}
