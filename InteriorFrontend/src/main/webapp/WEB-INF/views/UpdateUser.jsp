<%@include file="Header.jsp" %>

<div class="container">
<div class="row">
<div class="col-6">
<form action="<c:url value="/updateuserdetail"/>" method="post">
	<table class="table" align="center">
		<tr>
			<th>UserName : </th>
			<td><h5><input class="form-control" type="text" name="uname" value="${userDetail.userName}" readonly></h5></td>
		<tr>
			<th>Mobile No : </th>
			<td><input class="form-control" type="tel" name="mobno" value="${userDetail.mobileNo}"></td>
		</tr>
		<tr>
			<th>Shipping Address : </th>
			<td><input class="form-control" type="text" name="address" value="${userDetail.address}"></td>
		</tr>
		<tr>
			<td align="center"><input type="submit" class="btn btn-outline-primary btn-block" value="Update My Profile" /></td>
		</tr>
	</table>	
</form>
</div>
</div>
</div>

<%@include file="Footer.jsp" %>
