<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<title>Insert title here</title>
</head>
<body>
我的购物车
<table border="2" >
<tr>
<!--   <td>用户名称</td> -->
  <td>种类编号</td>
  <td>商品编号</td>
  <!-- <td>商品名称</td> -->

  <td>商品数量</td>
   <td>商品总价</td>
   <td align="center">操作</td>
  
</tr>
<c:forEach items="${mycartInfo}" var="listmap">
    <tr>
<%--   <td>${listmap.username}</td> --%>
	<td>${listmap.zlbh}</td>
	<td>${listmap.spbh}</td>
   
   <%-- <td>${listmap.price}</td> --%>
    <td>${listmap.sl}</td>
    <td>${listmap.zj}</td>
    <td><input type="button" value = "-"style="width:40px;height:20px" onclick="window.location.href='http://localhost:8080/spring/shoppingcart/addtocart
spbh=${listmap.spbh} '"/><input type="button" value = "+"style="width:40px;height:20px" onclick="window.location.href='http://localhost:8080/spring/shoppingcart/addtocart
spbh=${listmap.spbh} '"/> </td>
    </tr>
</c:forEach>
</table>

</body>
</html>