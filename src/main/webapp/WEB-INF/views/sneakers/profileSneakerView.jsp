<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">
	function doDelete(id) {
		if (confirm("This item will be deleted")) {
			window.location.href = "deleteInBrawser?id=" + id;
		}
	}
</script>
</head>
<body>

	<h4>Hey!</h4>
	
	<div>Brand: ${sneakerModel.brand}</div> <br><br>
	<div>Model: ${sneakerModel.model}</div> <br><br>
	<div>Release year: ${sneakerModel.releaseYear}</div> <br><br>
	<div>Description: ${sneakerModel.description}</div> <br><br>
	
	<a href="editSneakers?id=${sneakerModel.id}">Edit</a>	|	<a href="#" onclick="doDelete(${sneakerModel.id})">Delete</a> 

</body>
</html>