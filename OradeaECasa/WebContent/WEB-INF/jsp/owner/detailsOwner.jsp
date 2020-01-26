<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<br><b>The selected owner details : </b><br/><br/>
<table>
<tr>
<td>ID</td><td><td><c:out value="${model.owner.id}"/></td>
</tr>
<tr>
<td>Name</td><td><td><c:out value="${model.owner.name}"/></td>
</tr>
<tr>
<td>Identification Code</td><td><td><c:out value="${model.owner.identificationCode}"/></td>
</tr>
<tr>
<td>Phone Number</td><td><td><c:out value="${model.owner.phoneNumber}"/></td>
</tr>
<tr>
<td>Email</td><td><td><c:out value="${model.owner.email}"/></td>
</tr>
</table>
<a href="<c:url value="/owners.htm"/>">Back to owners list</a>
<body style="background-color:powderblue;">
</body>
</html>