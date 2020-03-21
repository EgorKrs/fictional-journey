<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Edit Person</h1>

<c:url var="saveUrl" value="/mobilePhones/edit?id=${phone.id}" />
<form action="${saveUrl}" method="post">
	<label>
		<input name="id" type="text" placeholder="id"/>
	</label>
	<label>
		<input name="model" type="text" placeholder="model"/>
	</label>
	<label>
		<input name="category" type="text" placeholder="category"/>
	</label>
	<label>
		<input name="price" type="text" placeholder="price"/>
	</label>
	<label>
		<input name="status" type="text" placeholder="status"/>
	</label>
	<input type="submit" value="Save" />
</form>


</body>
</html>