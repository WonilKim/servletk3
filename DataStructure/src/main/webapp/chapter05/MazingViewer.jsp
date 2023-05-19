<%@page import="DataStructure.Point"%>
<%@page import="Mazing.Mazing"%>
<%@page import="java.io.Console"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%!
	int mazeData[][] = {
			{0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 
			{0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1},
			{1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1}, 
			{1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1},
			{1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1}, 
			{1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1}, 
			{1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1},
			{1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1}, 
			{1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1},
			{1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1}, 
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1}
			};
	
	Mazing mazing = new Mazing(mazeData);

	void testFunc(JspWriter out, String msg) {
		try {
			out.print("testFunc");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Maze problem</title>
<style type="text/css">
#divTable {
	border-style: solid;
	border-color: red;
	width: fit-content;
	height: fit-content;
}
</style>
</head>
<body>
	<%
	int row = mazeData.length;
	int column = mazeData[0].length;

	out.print(String.format("<h2>Maze %s x %s</h2>", row, column));
	
	out.print("<div id=\"divTable\">");
	out.print("<table>");
	for (int r = 0; r < row; r++) {
		out.print("<tr height=20>");
		for (int c = 0; c < column; c++) {
			String id = String.format("id_%s_%s", r, c);
			System.out.println(id);

			if (mazeData[r][c] == 1) {
				out.print(String.format(
						"<td id=\"%s\" width=20 bgcolor=\"black\">", id));
			} else {
				out.print(String.format("<td id=\"%s\" width=20>", id));
			}
			out.print("</td>");
		}

		out.print("</tr>");
	}
	out.print("</table>");
	out.print("</div>");
	
	out.print("<button onclick=\"onClickButtonNext();\">Next</button>");
	
	mazing.setStartPoint(new Point(0, 0));
	
	%>
</body>
<script>
function onClickButtonNext() {
	console.log("button click");
	
	
/* 	if ((${mazing}).moveNext() == true) {
 		Point last = mazing.getCurrentLocation();
		String lastId = String.format("id_%s_%s", last.getRow(), last.getCol());
		document.getElementById(lastId).innerHTML = "";
		
		Point current = mazing.getCurrentLocation();
		String newId = String.format("id_%s_%s", current.getRow(), current.getCol());
		document.getElementById(newId).innerHTML = "O";
 	}
*/
}
</script>
</html>