<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GugudanForm</title>
</head>
<body>
	<h2>GugudanForm</h2>
	<form action="GugudanMain.jsp">
		<table>
			<tr>
				<td>
					<fieldset>
						<label for="sel"> 구구단 : <input type="radio" name="sel"
							value="gugudanType1" checked />구구단 1 <input type="radio"
							name="sel" value="gugudanType2" />구구단 2
						</label>
					</fieldset>

				</td>
			</tr>
			<tr>
				<td>
					<fieldset>
						<label for="type"> 타입 : <input type="radio" name="type"
							value="list" checked />list <input type="radio" name="type"
							value="table" />table
						</label>
					</fieldset>
				</td>
			</tr>
			<tr>
				<td><input type="text" name="val" value="2" />단수/열수</td>
			</tr>
			<tr>
				<td><input type="submit" value="선택" /></td>
			</tr>
		</table>
	</form>
</body>
</html>