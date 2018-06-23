<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Data</title>
</head>
<body>
	<table border="2">
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Age</th>
		<th>Gender</th>
		<th>Course</th>
		<th>Address</th>
		<th>Contact No</th>
		<th>Operation</th>
	</tr>
	<tr>
		<c:forEach items="${stds}" value="s">
			<td><c:out value="${s.studId}"/></td>
			<td><c:out value="${s.studName }"/></td>
			<td><c:out value="${s.studAge }"/></td>
			<td><c:out value="${s.studGen }"/></td>
			<td><c:out value="${s.course}"/></td>
			<td><c:out value="${s.studAddr }"/></td>
			<td><c:out value="${s.studCont }"/></td>
			<td><a href="delete?studId=${s.studId}">delete</a></td>
		</c:forEach>
		
	</tr>
	
	
	</table>
	<a href="StudentRegister.jsp">Home</a>
</body>
</html>