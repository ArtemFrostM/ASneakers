<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h3>Registration</h3>

	<form action="${pageContext.request.contextPath}/registration"
		method="POST">
		<div>
			Nickname: <input type="text" name="nickname"
				value="${userSn.nickname}" /> <br> 
		    First Name: <input
				type="text" name="firstName" value="${userSn.firstName}" /> <br>
			Last Name: <input type="text" name="lastName"
				value="${userSn.lastName}" /> <br> 
				Password: <input type="text"
				name="password" value="${userSn.password}" /> <br> 
				Email: <input
				type="text" name="email" value="${userSn.email}" /> <br> <input
				type="submit" value="Submit" />
				<input type="hidden" value="${userSn.sneakers}">
		</div>
	</form>

</body>
</html>