<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@include file="Header.jsp" %>

<div class="container">
  <h2>Manage Supplier</h2>
  </br>
  <form action="<c:url value="/addsupplier"/>" method="post">
    <div class="form-group">
      <label for="text">Supplier Name :</label>
      <input type="text" class="form-control" placeholder="Enter Supplier Name" name="sname" required="required">
    </div>
    <div class="form-group">
      <label for="text">Supplier Address :</label>
      <input type="text" class="form-control" placeholder="Enter Supplier Address" name="sadd" required="required">
    </div>
    <button type="submit" class="btn btn-outline-primary">Add Supplier</button>
  </form>
</div>
</br>

<div class="container">
<table class="table">
    <thead class="thead-light">
      <tr>
        <th>Supplier ID</th>
        <th>Supplier Name</th>
        <th>Supplier Address</th>
        <th>Operations</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${supplierlist}" var="supplier">
      <tr>
		<td>${supplier.supplierId}</td>
		<td>${supplier.supplierName}</td>
		<td>${supplier.supplierAddress}</td>
		<td>
			<a href="<c:url  value='/editsupplier/${supplier.supplierId}'/>" class="btn btn-warning" role="button"><i class="fa fa-pencil" aria-hidden="true"></i></a>
			<a href="<c:url  value='/deletesupplier/${supplier.supplierId}'/>" class="btn btn-danger" role="button"><i class="fa fa-trash-o" aria-hidden="true"></i></a>
		</td>			
	 </tr>
	</c:forEach>
    </tbody>
  </table>
</div>

<%@include file="Footer.jsp" %>