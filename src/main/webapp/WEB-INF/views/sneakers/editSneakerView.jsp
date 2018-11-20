<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Edit Sneakers</h3>

	<h1>Item: ${sneaker.brand}</h1>

	<form method="post"
		action="${pageContext.request.contextPath}/editSneakers">
		<input type="text" name="brand" value="${sneaker.brand}" /> 
		<input type="text" name="model" value="${sneaker.model}" /> 
		<input type="text" name="description" value="${sneaker.description}" /> 
		<input type="text" name="release_year" value="${sneaker.releaseYear}" /> 
		<input type="hidden" name="id" value="${sneaker.id}" />
		<input type="submit" value="Submit" /> 
		<a href="${pageContext.request.contextPath}/productList">Cancel</a>

	</form>

</body>
</html>