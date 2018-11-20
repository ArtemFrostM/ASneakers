<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here
</title>
<script type="text/javascript">
	function doDelete(id) {
		if (confirm("This item will be deleted")) {
			window.location.href = "delete-user?id=" + id;
		}
	}
</script>
</head>
<body>
	<h3>USERS</h3>
	<c:forEach items="${usersList}" var="user">
		<div>
			${user.nickname} | <a href="ShowUserProfile?id=${user.id}">Go to profile</a>	
			|	<a href="#" onclick="doDelete(${user.id})">Delete</a>
		</div>
	</c:forEach>
</body>
</html>