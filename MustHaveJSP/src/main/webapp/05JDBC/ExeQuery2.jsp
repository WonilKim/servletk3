<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="common.JDBCConnect"%>
<%@ page import="java.sql.SQLException"%>
<%@ page import="java.sql.Types"%>
<%@ page import="java.sql.ResultSetMetaData"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%!
	public static void showResultSetTable(JspWriter out, ResultSet rs) {

		try {
			StringBuffer sqlString;
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			String[] columnNames = new String[columnCount];
			for (int i = 0; i < columnNames.length; i++) {
				columnNames[i] = rsmd.getColumnName(i + 1);
			}

			out.print("<table border=1>");

			out.print("<tr>");
			for (String col : columnNames) {
				out.print(String.format("<th>%s</th>", col));
			}
			out.print("</tr>");

			if (rs != null) {
				while (rs.next()) {
					sqlString = new StringBuffer();
					sqlString.append("| ");

					out.print("<tr>");
					for (int i = 1; i <= columnCount; i++) {
						Object obj = rs.getObject(i);

						String value = "";

						if (obj == null) {
							value = "null";
						} else {
							int sqlTypes = rsmd.getColumnType(i);

							switch (sqlTypes) {
							case Types.VARCHAR:
							case Types.CHAR:
								value = String.format("\"%s\"", rs.getString(i));
								break;
							case Types.NULL:
								value = "null";
								break;
							case Types.TIMESTAMP:
								value = String.format("\"%s\"", rs.getTimestamp(i));
								break;
							case Types.DOUBLE:
								value = String.format("%s", rs.getDouble(i));
								break;
							case Types.INTEGER:
							case Types.BIGINT:
							case Types.SMALLINT:
								value = String.format("%s", rs.getInt(i));
								break;
							case Types.DECIMAL:
								value = String.format("%s", rs.getBigDecimal(i));
								break;

							} // switch

						} // else

						out.print(String.format("<th>%s</th>", value));

					} // for

					out.print("</tr>");

				} // while (rs.next())

				out.print("</table>");

			} // if (rs != null)

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	%>
<html>
<head>
<title>JDBC</title>
</head>
<body>
	<h2>회원 목록 조회 테스트(executeQuery() 사용)</h2>
	<%
	// DB에 연결
	JDBCConnect jdbc = new JDBCConnect();
	Connection con = jdbc.getConnection();

	// 쿼리문 생성   
	String sql = "SELECT * FROM member";
	Statement stmt = con.createStatement();

	// 쿼리 수행
	ResultSet rs = stmt.executeQuery(sql);

	out.print("query : " + sql);
	showResultSetTable(out, rs);

	out.print("<br/>");

	// 쿼리문 생성   
	String sql2 = "SELECT * FROM board";
	Statement stmt2 = con.createStatement();

	// 쿼리 수행
	ResultSet rs2 = stmt.executeQuery(sql2);

	out.print("query : " + sql2);
	showResultSetTable(out, rs2);

	// 연결 닫기
	jdbc.closeConnection(con);
	%>
</body>
</html>