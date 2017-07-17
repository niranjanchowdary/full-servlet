<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
div.ex {
	text-align: right width:300px;
	padding: 10px;
	border: 5px solid grey;
	margin: 0px;
	margin-top: 350px;
	background-color: gray;
}

form {
	margin-top: 50px;
	text-align: center;
}

body {
	background-image: url("images/download111111.jpg");
	background-position: 54%;
	background-size: 90% auto;
	background-position-y: -399px;
}
</style>
<body>
	<center>
		<h1>welcome to Full creative</h1>
	</center>


	<form action="/full_creative" method="post">
		<div class="ex">
			<label>User Name :</label> <input type="text" name="user_name"
				placeholder="enter your name" /> <br>
			<br>
			<br> <label>password:</label>&nbsp;&nbsp;&nbsp;&nbsp; <input
				type="password" name="user_pass" placeholder="enter your password" />
			<br>
			<br>
			<br> <input type="submit" name="but_1" value="Login" />&nbsp;&nbsp;&nbsp;&nbsp;
			<label>new user </label> <a href="signup.jsp"> <input
				type="button" value="signup">
			</a>
		</div>
	</form>
</body>
</html>