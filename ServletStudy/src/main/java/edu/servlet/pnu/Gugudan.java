package edu.servlet.pnu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/gugudan")
public class Gugudan extends HttpServlet {


	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("MyServlet05");
		
		resp.setContentType("text/html; charset=utf-8");

		String type = req.getParameter("type");
		String snum = req.getParameter("num");
		
		System.out.println(type);
		
		if (type == null) {
			System.out.println("type == null");
			type = "list";
		}
		
		int num = 2;
		if(snum != null)
			num = Integer.parseInt(snum);
		
		try (PrintWriter out = resp.getWriter();) {
			out.println("<h3>구구단</h3>");
			out.println("<h5>" + num + " 단</h5>");
			
			if(type.equals("list")) {
				System.out.println("type == list");
				out.println("<ul>");
				
				for(int i=1; i<=9; i++) {
					out.println("<li>" + num + " x " + i + " = " + (num * i) + "</li>");
				}
				out.println("</ul>");
			} else if (type.equals("table")) {
				System.out.println("type == table");
				out.println("<table border=1>");
				
				for(int i=1; i<=9; i++) {
					out.println("<tr><td>" + num + " x " + i + " = " + (num * i) + "</td></tr>");
				}
				out.println("</table>");
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
