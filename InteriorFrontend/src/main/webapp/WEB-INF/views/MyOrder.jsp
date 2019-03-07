<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="Header.jsp" %>

<div class="container">
<h3 align="center" style="background-color:LightGray;border-radius: 10px;">Your Order Details</h3>
<table class="table table-bordered ">
	<thead class="thead-light">
	<tr>
		<th>Product Image</th>
		<th>Product Name</th>
		<th>Price</th>
		<th>Quantity</th>
		<th>Total Price</th>
	</tr>
	</thead>
	<tbody>
	<c:if test="${empty cartitems}">
	<tr>
		<td colspan="6" align="center">!!! Your Cart is Empty !!!</td>
	</tr>
	</c:if>
	<c:if test="${not empty cartitems}">
	<c:forEach items="${cartitems}" var="cartItem">
	<tr>
	    <td><img src="<c:url value="/resources/images/${cartItem.productId}.jpg"/>" alt="Image" style="width:100px;height:100px"></td>
		<td>${cartItem.productName}</td>
		<td>Rs ${cartItem.price}/-</td>
		<td>${cartItem.quantity}</td>
		<td>Rs ${cartItem.quantity*cartItem.price}/-</td>
	</tr>
	</c:forEach>
	</c:if>
	<c:if test="${not empty cartitems}">
	<tr class="table-success">
		<th colspan="4">Total Purchase Amount : </th>
		<th colspan="2">Rs ${totalCartAmount}/-</th>
	</tr>
	</c:if>
	<tr>
		<td colspan="3"><a href='<c:url value="/continueshopping"/>' class="btn btn-info btn-block" role="button">Continue Shopping</a></td>
		<c:if test="${not empty cartitems}">
		<td colspan="3"><a href='<c:url value="/payment"/>' class="btn btn-info btn-block" role="button">Proceed For Payment</a></td>
		</c:if>
	</tr>
	</tbody>
</table>
</div>

<%@include file="Footer.jsp" %>