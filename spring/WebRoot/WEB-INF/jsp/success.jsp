<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
success
<table border="2" width="300">
<tr>
  <td>ID</td>
  <td>姓名</td>
  <td>年龄</td>
  <td>创建时间</td>
</tr>
<c:forEach items="${userInfo}" var="listmap">
    <tr>
    <td>${listmap.i}</td>
	<td>${listmap.n}</td>
    <td>${listmap.a}</td>
     <td width="500">${listmap.s}</td>
    </tr>
</c:forEach>
 

 </table>
</body>
</html>