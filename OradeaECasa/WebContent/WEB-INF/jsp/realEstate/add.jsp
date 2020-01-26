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
<b>Add new real estate:</b><br/><br/>
<form:form action="./addRealEstate.htm" commandName="realEstateForm" method="post">
<b>Address:</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <form:input path="address"/><br/><br>
<b>Type of transaction:</b> <form:input path="statusOfTransaction"/><br/><br>
<b>Area sqm:</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<form:input path="areaSqm"/><br/><br>
<b>Description:</b> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<form:input path="description"/><br/><br>
<b>Sale price: </b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<form:input path="salePrice"/><br/><br>
<b>Rent price:</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <form:input path="rentPrice"/><br/><br>
<b>Owner :</b> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<form:select path="owner">
<form:option value="" itemValue="0" itemLabel="Select Owner"/>
<form:options items="${dropBoxListOwners}" itemValue="id" itemLabel="name"/>
</form:select>
<br/><br>
<b>Client:</b> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<form:select path="client">
<form:option value="0" itemValue="0" itemLabel="Select the Client(if available)"/>
 <form:options items="${dropBoxListClients}" itemValue="id" itemLabel="name"  />
</form:select>
<br/><br>
<input type=submit value="Save"/>
</form:form>
<body style="background-color:powderblue;">
</body>
</html>
