<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>StudentRegister</title>
</head>
<body>

<form:form action="insert" method="POST" modelAtrribute="student">
<pre>
Student Name ::	<form:input path="studName"/><form:errors path="studName"/>
	<spring:message path="studName"/>
Enter Password::	<form:password path="studPwd"/><form:errors path="studPwd"/>
	<spring:message path="studPwd"/>
Enter Age:	<form:input path="studAge"/><form:errors path="studAge"/>
<spring:message path="studAge"/>
Enter Gender:<form:radiobutton path="studGen" value="Male" checked/>Male <form:radiobutton path="studGen" value="Female"/>Female<form:errors path="studGen"/>
<spring:message path="studGen"/>
Select Course:<form:checkbox path="course" value="Java Pkg"/>Java Pkg<form:errors path="course"/>
			<form:checkbox path="course" value=".Net Pkg"/>.netPkg
			<form:checkbox path="course" value="UI Pkg"/>UI Pkg
	<spring:message path="course"/>
	
Enter Addreess:<form:textarea path="studAddr"/><form:errors path="studAddr"/>
<spring:message path="studAddr"></spring:message>
Enter Contact Number :<form:input path="studCont"/><form:errors path="studCont"/>
<spring:message path="studCont"/>
	<input type="submit" value="Register"/><input type="reset"/>
	</pre>
	</form:form>
</body>
</html>