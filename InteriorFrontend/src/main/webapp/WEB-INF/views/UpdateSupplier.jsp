<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="Header.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<div class="container">
<form action="<c:url value="/updatesupplier"/>" method="post">
	<table class="table">
		<tr>
			<td>Supplier ID</td>
			<td><input type="text" name="sid" value="${supplierData.supplierId}" readonly></td>
		<tr>
			<td>Supplier Name : </td>
			<td><input type="text" name="sname" value="${supplierData.supplierName}"></td>
		</tr>
			<td>Supplier Address : </td>
			<td><input type="text" name="sadd" value="${supplierData.supplierAddress}"></td>
		</tr>
		<tr>
			<td align="center"><input type="submit" class="btn btn-outline-primary" value="update"></td>
		</tr>
	</table>	
</form>
</div>
<%@include file="Footer.jsp" %>