<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
	 <h3> ${userModel.nickname} </h3>
	 <div>
	 	Name:  ${userModel.firstName} <br>
	 	Last Name: ${userModel.lastName} <br>
	 	Email: ${userModel.email} <br>
	 	<a href="user_s-sneakers?id=${userModel.id}"> Favourite Sneakers </a> <br>
	 	<a href="edit-my-profile?id=${userModel.id}"> Edit profile </a>
	 	
	 
	 </div>
</div>
</body>
</html>