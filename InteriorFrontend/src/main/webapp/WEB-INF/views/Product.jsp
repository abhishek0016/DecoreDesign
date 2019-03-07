<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="Header.jsp" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<div class="container">
<h2>Manage Product</h2>
</br>
<form:form action="addproduct" modelAttribute="product" method="post" enctype="multipart/form-data">
  <div class="form-group">
    <label>Product Name :</label>
    <form:input path="productName" class="form-control" required="required"/>
  </div>
  <div class="form-group">
    <label>Product Description :</label>
    <form:input path="productDesc" class="form-control" required="required"/>
  </div>
  <div class="form-group">
    <label>Price :</label>
    <form:input path="price" class="form-control" required="required"/>
  </div>
  <div class="form-group">
    <label>Stock :</label>
    <form:input path="stock" class="form-control" required="required"/>
  </div>
  <div class="form-group">
      <label>Select Category(select one) :</label>
      <form:select path="categoryId" class="form-control" required="required">
				<form:option value="0" label="--Select Category--"/>
				<form:options items="${categoryList}"/>
	  </form:select>
  </div>
  <div class="form-group">
      <label>Select Supplier(select one) :</label>
      <form:select path="supplierId" class="form-control" required="required">
				<form:option value="0" label="--Select Supplier--"/>
				<form:options items="${supplierList}"/>
	  </form:select>
  </div>
  <div class="form-group">
  	  <label>Select Product Image :</label>
      <form:input type="file" path="pImage" name="file" class="form-control-file border" required="required"/>
  </div>
  <button type="submit" class="btn btn-outline-primary">Add Product</button>
</form:form>
</div>
</br>


<div class="container">
<table class="table">
    <thead class="thead-light">
      <tr>
        <th>Product ID</th>
        <th>Product Image</th>
        <th>Product Name</th>
        <th>Product Description</th>
        <th>Price</th>
        <th>Stock</th>
        <th>Category Id</th>
        <th>Supplier Id</th>
        <th>Operations</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${productlist}" var="product">
      <tr>
		<td>${product.productId}</td>
		<td><img src="<c:url value="/resources/images/${product.productId}.jpg"/>" alt="Image" style="width:100px;height:100px"></td>
		<td><h5>${product.productName}</h5></td>
		<td>${product.productDesc}</td>
		<td>Rs ${product.price}/-</td>
		<td>${product.stock}</td>
		<td>${product.categoryId}</td>
		<td>${product.supplierId}</td>
		<td>
			<a href='<c:url value="/editproduct/${product.productId}"/>' class="btn btn-warning" role="button"><i class="fa fa-pencil" aria-hidden="true"></i></a>
			<a href='<c:url value="/deleteproduct/${product.productId}"/>' class="btn btn-danger" role="button"><i class="fa fa-trash-o" aria-hidden="true"></i></a>
		</td>			
	 </tr>
	</c:forEach>
    </tbody>
  </table>
</div>

<%@include file="Footer.jsp" %>