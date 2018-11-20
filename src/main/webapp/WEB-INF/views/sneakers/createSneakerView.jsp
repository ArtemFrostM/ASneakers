<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Sneakers</title>
</head>
<body>
	<form method="POST"
		action="${pageContext.request.contextPath}/AddSneakerInBrawser">
		Brand:	<input type="text" name="brand" value="${sneaker.brand}" /> <br><br>
		Model:	<input type="text" name="model" value="${sneaker.model}" /> <br><br>
		Description:	<input type="text" name="description" value="${sneaker.description}" /> <br><br>
		Release Year:	<input type="text" name="release_year" value="${sneaker.releaseYear}" /> <br><br>
	<!--  <input type="hidden" name="id" value="${sneaker.id}" /> -->	
		<input type="submit" value="Submit" />
	</form>
</body>
</html>