<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="Header.jsp" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container">
<form:form action="/InteriorFrontend/updateproduct" modelAttribute="product" method="post" enctype="multipart/form-data">
<table class="table">
    <tr>
		<td>Product ID</td>
		<td><form:input path="productId" readonly="true"/></td>
    </tr>
	<tr>
		<td>Product Name</td>
		<td><form:input path="productName"/></td>
	</tr>
	<tr>
		<td>Product Description</td>
		<td><form:input path="productDesc"/></td>
	</tr>
	<tr>
	<tr>
		<td>Price</td>
		<td><form:input path="price"/></td>
	</tr>
	<tr>
		<td>Stock</td>
		<td><form:input path="stock"/></td>
	</tr>
	<tr>
		<td>Category</td>
		<td><form:select path="categoryId">
				<form:option value="0" label="--Select Category--"/>
				<form:options items="${categoryList}"/>
			</form:select></td>	
	</tr>
		<tr>
		<td>Supplier</td>
		<td><form:select path="supplierId">
				<form:option value="0" label="--Select Supplier--"/>
				<form:options items="${supplierList}"/>
			</form:select></td>	
	</tr>
	<tr>
		<td>Product Image</td>
		<td><form:input type="file" path="pImage"/></td>
	</tr>
	<tr>
		<td align="center"><input type="submit" class="btn btn-outline-primary" value="Update Product"></td>
	</tr>
</table>
</form:form>
</div>
<%@include file="Footer.jsp" %>
