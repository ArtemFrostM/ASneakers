<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="POST" action="${pageContext.request.contextPath}/edit-my-profile">
	
		<input type="text" name="nickname" value="${userModel.nickname}"> <br>
		<input type="text" name="firstName" value="${userModel.firstName}"> <br>
		<input type="text" name="lastName" value="${userModel.lastName}"> <br>
		<input type="text" name="password" value="${userModel.password}"> <br>
		<input type="text" name="email" value="${userModel.email}"> <br>
		<input type="hidden" name="id" value="${userModel.id}"> <br>
		<input type="submit" value="Submit">
	
	</form>
</body>
</html>