<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	insert

	<form:form modelAttribute="modelValid" action="/spring/user/objectinsert"
		method="post">
		name: <input type="text" name="name" value="${modelValid.name}" />
		<div><form:errors path="name" style="color:red"></form:errors></div>
		<br />
	    age:<input type="text" name="age" value="${modelValid.age}" />
		<div style="color:red"><form:errors path="age" ></form:errors></div>
		<br />
		<input type="submit" value="Submit" />
	</form:form>

	<a href="/si/user/topics/10">链接</a>

</body>
</html>