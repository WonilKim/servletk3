package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import javax.servlet.ServletContext;
import javax.servlet.jsp.JspWriter;

public class JDBCConnect {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/musthave";
	private String id = "musthave";
	private String pwd = "tiger"; 

    public Connection con;
    public Statement stmt;  
    public PreparedStatement psmt;  
    public ResultSet rs;

    // 기본 생성자
    public JDBCConnect() {
        System.out.println("기본 생성자");
        connectDB();
    }

    // 두 번째 생성자
    public JDBCConnect(String driver, String url, String id, String pwd) {
        System.out.println("인수 생성자 1");
    	this.driver = driver;
    	this.url = url;
    	this.id = id;
    	this.pwd = pwd;
    	
        connectDB();
    }
    

    // 세 번째 생성자
    public JDBCConnect(ServletContext application) {
        System.out.println("인수 생성자 2"); 
        String driver = application.getInitParameter("MysqlDriver"); 
        String url = application.getInitParameter("MysqlURL"); 
        String id = application.getInitParameter("MysqlId");
        String pwd = application.getInitParameter("MysqlPwd");

        connectDB();
    }

    public boolean connectDB() {
		try {
            // JDBC 드라이버 로드
            Class.forName(driver);
            // DB에 연결
            con = DriverManager.getConnection(url, id, pwd); 
			
			System.out.println("데이터베이스가 연결되었습니다.");
			return true;

		} catch(Exception e) {
			e.printStackTrace();
		} 
		return false;
	}

    // 연결 해제(자원 반납)
    public void close() { 
        try {            
            if (rs != null) rs.close(); 
            if (stmt != null) stmt.close();
            if (psmt != null) psmt.close();
            if (con != null) con.close(); 

            System.out.println("JDBC 자원 해제");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ResultSet executeSelectQuery(String query) {

		try {
			stmt = con.createStatement();
			return stmt.executeQuery(query);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

    public static void showResultSet(ResultSet rs) {

		try {
			StringBuffer sqlString;
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			String[] columnNames = new String[columnCount];
			for (int i = 0; i < columnNames.length; i++) {
				columnNames[i] = rsmd.getColumnName(i + 1);
			}

			System.out.println("-".repeat(columnCount * 19));
			System.out.print("| ");
			for (String col : columnNames) {
				// System.out.print(col + "\t");
				System.out.print(String.format("%-17s", col));
				System.out.print("| ");
			}
			System.out.println();
			System.out.println("-".repeat(columnCount * 19));

			if (rs != null) {
				while (rs.next()) {
					sqlString = new StringBuffer();
					sqlString.append("| ");

					for (int i = 1; i <= columnCount; i++) {
						Object obj = rs.getObject(i);

						if (obj == null) {
							sqlString.append("null");
							sqlString.append("\t| ");
						} else {
							int sqlTypes = rsmd.getColumnType(i);
							String temp = "";

							switch (sqlTypes) {
								case Types.VARCHAR:
								case Types.CHAR:
									temp = String.format("\"%s\"", rs.getString(i));
									sqlString.append(String.format("%-17s", temp));
									sqlString.append("| ");
									break;
								case Types.NULL:
									temp = "null";
									sqlString.append(String.format("%-17s", temp));
									sqlString.append("| ");
									break;
								case Types.TIMESTAMP:
									temp = String.format("\"%s\"", rs.getTimestamp(i));
									sqlString.append(String.format("%-17s", temp));
									sqlString.append("| ");
									break;

								case Types.DOUBLE:
									temp = String.format("%s", rs.getDouble(i));
									sqlString.append(String.format("%-17s", temp));
									sqlString.append("| ");
									break;

								case Types.INTEGER:
								case Types.BIGINT:
								case Types.SMALLINT:
									temp = String.format("%s", rs.getInt(i));
									sqlString.append(String.format("%-17s", temp));
									sqlString.append("| ");
									break;
								case Types.DECIMAL:
									temp = String.format("%s", rs.getBigDecimal(i));
									sqlString.append(String.format("%-17s", temp));
									sqlString.append("| ");
									break;

								/*
								 * default:
								 * if (obj != null)
								 * sqlString.append(obj.toString());
								 * 
								 * sqlString.append(",");
								 * break;
								 */
							} // switch

						} // else

					} // for

					System.out.println(sqlString);

				}
				System.out.println("-".repeat(columnNames.length * 19));

			} // if (rs != null)

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

    
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

    public static void main(String[] args) {
    	JDBCConnect conn = new JDBCConnect();
    	
    	
    	
    	conn.close();
    	
	}
}