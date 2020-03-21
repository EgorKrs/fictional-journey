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
<h1>Phones</h1>

<c:url var="addUrl" value="/mobilePhones/add" />
<table style="border: 1px solid; width: 500px; text-align:center">
	<thead style="background:#fcf">
		<tr>
			<th>id</th>
			<th>model</th>
			<th>price</th>
			<th>status</th>
			<th>category</th>
			<th colspan="3"></th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${phones}" var="phone">
			<c:url var="editUrl" value="/mobilePhones/edit?id=${phone.id}" />
			<c:url var="deleteUrl" value="/mobilePhones/delete?category=${phone.category}&model=${phone.model}" />
		<tr>
			<td><c:out value="${phone.id}" /></td>
			<td><c:out value="${phone.model}" /></td>
			<td><c:out value="${phone.price}" /></td>
			<td><c:out value="${phone.status}" /></td>
			<td><c:out value="${phone.category}" /></td>
			<td><a href="${editUrl}">Edit</a></td>
			<td><a href="${deleteUrl}">Delete</a></td>
			<td><a href="${addUrl}">Add</a></td>
		</tr>
	</c:forEach>
	<form action="/mobilePhones/search" method="post">
		<label>
			<input name="price" type="text" placeholder="price"/>
		</label>
		<label>
			<input name="status" type="text" placeholder="status"/>
		</label>
		<input type="submit" value="search" />
	</form>


	</tbody>
</table>

<c:if test="${empty phones}">
	There are currently no phone in the list. <a href="${addUrl}">Add</a> a phones.
</c:if>

</body>
</html>