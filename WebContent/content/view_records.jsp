<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border=4>
		<tr>
			<th>User Name</th>
			<th>Email Address</th>
		</tr>
		<c:forEach items="${records}" var="student">
			<tr>
				<td><c:out value="${student.userName}" /></td>
				<td><c:out value="${student.email}" /></td>
			</tr>
		</c:forEach>
	</table>
	<a href="content/register.jsp">Back To Registration</a>
</body>
</html>