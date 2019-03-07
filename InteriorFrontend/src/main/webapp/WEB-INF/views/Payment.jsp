<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="Header.jsp" %>

<div class="container">
<form action='<c:url value="/paymentprocess"/>' method="post">
<table class="table table-bordered" align="center">
	<thead class="thead-dark">
	<tr>
		<th>Payment Options</th>
	</tr>
	</thead>
	
	<tbody>
	<tr>
			<td><input type="radio" name="paymenttype" value="CC"/>&nbspCredit Card</td>		
	</tr>
	<tr>	
			<td><input type="radio" name="paymenttype" value="COD"/>&nbspCash On Delivery</td>	
	</tr>
	
	<tr id="details">
			<td>
			<div class="container"><div class="container">
			<article class="card">
<div class="card-body p-5">

<ul class="nav bg-light nav-pills rounded nav-fill mb-3" role="tablist">
	<li class="nav-item">
		<a class="nav-link active bg-success" data-toggle="pill" href="#nav-tab-card">
		<i class="fa fa-credit-card"></i> Credit Card Details</a></li>
</ul>
<div class="tab-content">
<div class="tab-pane fade show active" id="nav-tab-card">
	
	<div class="form-group">
		<label for="username">Full name (on the card)&nbsp&nbsp<i class="fa fa-address-card-o"></i></label>
		<input type="text" class="form-control">
	</div> <!-- form-group.// -->

	<div class="form-group">
		<label for="cardNumber">Card number</label>
		<div class="input-group">
			<input type="text" maxlength="16" class="form-control" name="cardNumber">
			<div class="input-group-append">
				<span class="input-group-text text-muted">
					<i class="fa fa-credit-card"></i> 
				</span>
			</div>
		</div>
	</div> <!-- form-group.// -->

	<div class="row">
	    <div class="col-sm-8">
	        <div class="form-group">
	            <label><span class="hidden-xs">Expiration</span>&nbsp&nbsp<i class="fa fa-calendar"></i> </label>
	        	<div class="input-group">
	        		<input type="number" maxlength="2" class="form-control" placeholder="MM">
		            <input type="number" maxlength="2" class="form-control" placeholder="YY">
	        	</div>
	        </div>
	    </div>
	    <div class="col-sm-4">
	        <div class="form-group">
	            <label data-toggle="tooltip" data-original-title="3 digits code on back side of the card">CVV <i class="fa fa-question-circle"></i></label>
	            <input type="password" maxlength="3" class="form-control">
	        </div> <!-- form-group.// -->
	    </div>
	</div><!-- row.// -->
</div> <!-- tab-pane.// -->
</div>
</div>
			</td>
	</tr>
	<tr>
		<td>
		<input type="submit" class="btn btn-primary btn-block" value="Proceed">
		</td>
	</tr>
	
	</tbody>
</table>
</form>
</div>

<%@include file="Footer.jsp" %>