<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="UpdateServlet" method="post">
<table>
<tr>
<td>Enter Employee ID:::</td>
<td><input type="text" name="empid"/></td>
</tr>
<tr>
<td>Enter Employee Name:::</td>
<td><input type="text"  name="empname" /></td>
</tr>
<tr>
<td>Enter Employee Location:::</td>
<td><input  type="text" name="emplocation"/></td>
</tr>
</table>
<input type="submit" value="submit">
</form>
</body>
</html>