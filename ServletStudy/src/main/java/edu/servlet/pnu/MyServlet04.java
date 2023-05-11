package edu.servlet.pnu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/myservlet04")
public class MyServlet04 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("MyServlet04");
		
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println("");
		out.println("<table border=\"1\" >");
		out.println("<tr>");
		out.println("	<th>번호</th><th>나라</th><th>수도</th>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("	<td>1</td><td>대한민국</td><td>서울</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("	<td>2</td><td>미국</td><td>워싱턴</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("	<td>3</td><td>일본</td><td>도쿄</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("	<td>4</td><td>중국</td><td>베이징</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("");
//		out.println("<style>");
//		out.println("	table, th, td {");
//		out.println("		border:1px solid black;");
//		out.println("	}");
//		out.println("</style>");
		
		out.close();
	}
}
