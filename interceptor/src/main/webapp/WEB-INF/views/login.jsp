<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>아이디, 비밀번호 체크</title>
<script>
	$(function(){
		$("#checkValue").on("click",function(){
			$.ajax({
				url:"/interceptor/input",
				type:"POST",
				dataType:"json",
				data:{userId:$("#userId").val(), pwd:$("pwd").val()},
				success:function(){
					alert("fire");
				},
				error:function(error){
					alert("error");
				}
			})
		})
	})
</script>
</head>
<body>
	<table>
		<tr>
			<td>아이디</td>
			<td><input type="text" id="userId"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" id="pwd"></td>
		</tr>
		<tr>
			<td colspan="2"><button id="checkValue">입력</button></td>
		</tr>
	</table>
</body>
</html>