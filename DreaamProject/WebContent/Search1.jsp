<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@page import="Model.EmployeeBean"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="SearchServlet" method="post">
<input type="text" name="searchElement">
<input type="submit" value="search">
</form>
<div align="center">

<%
Object obj=session.getAttribute("employeeList");
if(obj!=null)
{
	%>
	<table>
	<tr>
	<th>Employee ID</th>
<th>EmployeeName</th>
<th>Employee Salary</th>	
<th>Employee Location</th>
<th>EmployeeExp</th></tr>
	<%
	ArrayList<EmployeeBean> emplist=(ArrayList)obj;
	Iterator iterator=emplist.iterator();
	EmployeeBean empbean=null;
	while(iterator.hasNext())
	{
		empbean=(EmployeeBean)iterator.next();
		%>
		<tr>
		<td><%= empbean.getEmpid() %></td>
		<td><%=empbean.getEmpname() %></td>
		<td><%=empbean.getEmpsalary() %></td>
		<td><%=empbean.getEmplocation() %></td>
		<td><%=empbean.getEmpexp() %></td>
		
		</tr>
		
		<%
	}
	session.removeAttribute("employeeList");
}

	else
	{
		out.print("NoData");
	}
	
	%>
	
	</table>
</div>
</body>
</html>