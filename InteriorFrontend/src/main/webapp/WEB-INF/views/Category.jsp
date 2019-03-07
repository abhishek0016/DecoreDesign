<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@include file="Header.jsp" %>

<div class="container">
  <h2>Manage Category</h2>
  </br>
  <form action="<c:url value="/addcategory"/>" method="post">
    <div class="form-group">
      <label for="text">Category Name :</label>
      <input type="text" class="form-control" placeholder="Enter Category Name" name="cname" required="required">
    </div>
    <div class="form-group">
      <label for="text">Category Description :</label>
      <input type="text" class="form-control" placeholder="Enter Category Description" name="cdesc" required="required">
    </div>
    <button type="submit" class="btn btn-outline-primary">Add Category</button>
  </form>
</div>
</br>

<div class="container">
<table class="table">
    <thead class="thead-light">
      <tr>
        <th>Category ID</th>
        <th>Category Description</th>
        <th>Category Name</th>
        <th>Operations</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${categorylist}" var="category">
      <tr>
		<td>${category.categoryId}</td>
		<td>${category.categoryName}</td>
		<td>${category.categoryDesc}</td>
		<td>
			<a href="<c:url  value='/editcategory/${category.categoryId}'/>" class="btn btn-warning" role="button"><i class="fa fa-pencil" aria-hidden="true"></i></a>
			<a href="<c:url  value='/deletecategory/${category.categoryId}'/>" class="btn btn-danger" role="button"><i class="fa fa-trash-o" aria-hidden="true"></i></a>
		</td>			
	 </tr>
	</c:forEach>
    </tbody>
  </table>
</div>

<%@include file="Footer.jsp" %>