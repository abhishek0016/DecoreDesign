<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="Header.jsp" %>

<center>
<div class="container">
    <div class="row">
        <div class="container col-xs-10 col-sm-10 col-md-6 col-xs-offset-1 col-sm-offset-1 col-md-offset-3 bg-light">
            <div class="row">
                <div class="col-xs-6 col-sm-6 col-md-6">
                    <address>
                        <strong>NovaDesigns.com</strong>
                        <br>
                        P.O. Box 2012
                        <br>
                        Detroit, Mi 48000
                        <br>
                        <br> P :<br> (213) 484-6829
                    </address>
                </div>
                <div class="col-xs-6 col-sm-6 col-md-6 text-right">
                    <p>
                        <em>Date : ${orderDetail.orderDate}</em>
                    </p>
                    <p>
                        <em>Order Id : ${orderDetail.orderId }</em>
                    </p>
                    <p>
                        <em>User Name : ${userdetail.userName}</em>
                    </p>
                    <p>
                        <em>Shipping Address : ${userdetail.address}</em>
                    </p>
                    <p>
                        <em>Contact No. : ${userdetail.mobileNo}</em>
                    </p>
                </div>
            </div>
            <div class="row">
                <div class="text-center">
        
                    <h3 align="center">Receipt</h3>
                </div>
                </span>
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Product</th>
                            <th>Quantity</th>
                            <th class="text-center">Price</th>
                            <th class="text-center">Total</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${cartitems}" var="cartItem">
                        <tr>
                            <td class="col-md-9"><em>${cartItem.productName}</em></h4></td>
                            <td class="col-md-1" style="text-align: center">${cartItem.quantity}</td>
                            <td class="col-md-1 text-center">Rs ${cartItem.price}/-</td>
                            <td class="col-md-1 text-center">Rs ${cartItem.quantity*cartItem.price}/-</td>
                        </tr>
                        </c:forEach>
                        <tr>
                            <td>   </td>
                            <td>   </td>
                            <td class="text-right">
                            <p>
                                <strong>Subtotal: </strong>
                            </p>
                            </td>
                            <td class="text-center">
                            <p>
                                <strong>Rs ${totalCartAmount}/-</strong>
                            </p>
                            </td>
                        </tr>
                        <tr>
                            <td>   </td>
                            <td>   </td>
                            <td class="text-right"><strong>Total: </strong></td>
                            <td class="text-center text-danger"><strong>Rs ${totalCartAmount}/-</strong></td>
                        </tr>
                    </tbody>
                </table>
                <div>
                    <h1 class="dispaly-4" style="text-align:center;">
                        Thank you for your order !!...
                    </h1>
                    
                </div>
            </div>
        </div>
    </div>
</div>
</center>

<%@include file="Footer.jsp" %>