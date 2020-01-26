<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adaugare Proprietar</title>
</head>
<body>
<br><b>Add new Owner:</b><br/><br/>
<form:form action="./addOwner.htm" commandName="ownerForm" method="post">
<b>Name:</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <form:input path="name"/><br/><br>
<b>Identification code:</b> <form:input path="identificationCode"/><br/><br>
<b>Phone number:</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <form:input path="phoneNumber"/><br/><br>
<b>Email:</b> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<form:input path="email"/><br/><br>
<input type=submit value="Save"/>
</form:form>
<body style="background-color:powderblue;">
</body>
</html>