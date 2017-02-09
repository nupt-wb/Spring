
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="resource/js/jquery-3.1.0.min.js"></script>

<title>Insert title here</title>
</head>
<body>
<form action ="/spring/user/insert" method = "post">
<input type = "text" id ="name" name = "name"/>
<input type = "text" id ="age" name = "age"/>
<input type = "submit" value = "提交"/>
</form>
<form id="form1" method="post"enctype="multipart/form-data"action="fileupload">
<input type="text"name="myText"value="test"/><br/>
<input type="file"name="myFile"id="myFile"/><br/>
<input type="submit"value="提交"/><br/>

  
</form>
<input type = "button" value = "ajax call" onClick="aa();"/>
<script type="text/javascript">
 function aa(){
	 var urlContext ="<%=request.getContextPath()%>";
	 var url = urlContext+"/rest/getName";
	 var data1 = {"userName":"test","address":"zg"};
	 $.ajax({
		 type:"post",
		 url:url,
		 data:JSON.stringify(data1),
		 dataType:"json",
		 contentType:"application/json",
		 beforeSend:function(){
			 
		 },
		 success:function(data){
			alert(data.uuid);
			alert(data.name);
			
		 },
		 complete:function(XMLHttpRequest,textStatus){
			 
		 },
		 error:function(){
			 
		 }
		 
		 
	 });
 }

</script>

</body>
</html>