<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="resource/js/jquery-3.1.0.min.js"></script>

<title>Insert title here</title>
 <style type="text/css">
   body{
     color:#FF9600;
     font-family:黑体;
     font-size:18pt;
     background-image:url(./resource/img/timg.jpg);
     background-repeat:repeat-y;
     background-attachment:fixed;
   }
 </style>
</head>
<body>
<div><%@include file="commodities.jsp" %></div>

<table border="2" >
<tr>
 
  <td>种类编号</td>
  <td>商品编号</td>
  <td>商品名称</td>
  <td>商品价格</td>
  <td>商品数量</td>
   <td align="center">加入购物车</td>
  
</tr>
<c:forEach items="${commInfo}" var="listmap">
<!-- <script type="text/javascript">
function requestData() {
	
	 
	 
	    $.ajax({
//        提交数据的类型 POST GET
	        type:"get",
//	         提交的网址
	        url:"http://localhost:8080/spring/shoppingcart/addtocart?spbh=${listmap.spbh}",
//	        提交的数据
	        data:s1,
	       
//	        返回数据的格式
	        dataType:"text",
	        //在请求之前调用的函数
	        beforeSend:function(){//alert("在请求之前调用的函数");
	        	
	        },
	        //成功返回之后调用的函数            
	        success:function(data){
	        	 alert("1");
	           
	            $("#txt").val(data);
	        },
	        //调用执行后调用的函数
	        complete: function(XMLHttpRequest, textStatus){
	          /*  alert(XMLHttpRequest.responseText);
	           alert(textStatus);
	           alert('调用执行后调用的函数'); */
	            //HideLoading();
	        },
	        //调用出错执行的函数
	        error: function(){
	            //请求出错处理
	            //alert('error');
	        }         
	    });
	}

</script> -->
    <tr>
  
	<td>${listmap.zlbh}</td>
	<td>${listmap.spbh}</td>
    <td>${listmap.name}</td>
    <td>${listmap.price}</td>
    <td>${listmap.sl} </td>
     <%-- <td align ="center">  <input type="button" align="middle"style="background-image:url(../resource/img/gwc2.jpg);
    display:block;width:50px;height:30px"  onclick="window.location.href='http://localhost:8080/spring/shoppingcart/addtocart
spbh=${listmap.spbh} '"/> </td>  --%>
    <!--  <td align ="center">  <input type="button" align="middle"style="background-image:url(../resource/img/gwc2.jpg);
   width:50px;height:30px"  onclick="requestData();"/> </td>
    </tr> -->
    <td><a href="/spring/shoppingcart/addtocart?spbh=${listmap.spbh}">加入我的购物车</a></td>
</c:forEach>
</table>
<div><a href="/spring/shoppingcart/myshoppingcart">查看我的购物车</a></div>
</body>
</html>