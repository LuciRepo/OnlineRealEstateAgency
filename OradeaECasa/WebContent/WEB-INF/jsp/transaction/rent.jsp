<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

</head>
<body>
<b>Rent Real Estate:</b><br/><br/>
<form:form action="${pageContext.request.contextPath}/rentRealEstate.htm" commandName="rentEstateForm" method="post">
<b>Change the status of transaction:</b><br> <form:input path="statusOfTransaction"/><br/><br>
<b>Client:</b><br> 
<form:select path="client">
<form:option value="" itemValue="0" itemLabel="Select the Client(if available)"/>
 <form:options items="${dropBoxListClients}" itemValue="id" itemLabel="name"  />
</form:select>
<br/><br>
<b>Id:</b><br> <form:input path="id"/><br/><br>
<input type=submit value="Save"/>
</form:form>
<body style="background-color:powderblue;">
</body>
</html>
