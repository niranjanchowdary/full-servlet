<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
body {
	background-image: url("images/download111111.jpg");
	background-position: 54%;
	background-size: 90% auto;
	background-position-y: -399px;
}
</style>
<body>
	<script type="text/javascript">
	<% HttpSession session1=request.getSession(false);  
     if(session!=null){ %>
		<%String login_details = (String) session1.getAttribute("invalid_login");%>
		var message ="<%=login_details%>";
		alert(message + " successfully logged to your site");
		
			
	<%	}%>
		
	</script>
	<center>
		<h1>welcome ${invalid_login}</h1>
		
		
		<a href="logout.jsp"><button type="button"> logout</button></a>
	</center>
</body>
</html>