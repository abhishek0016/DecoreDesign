<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@include file="Header.jsp" %>
<div class="container">
<h5 style="color:green;">Hey! You have been Successfully Registered</h5>
<h5 style="color:green;">Please Login Here...</h5>
</div>
<div class="container">
  <h2>Login Form</h2>
  <form action="perform_login" method="post">
    <div class="form-group">
      <label for="username">UserName :</label>
      <input type="text" class="form-control" placeholder="Enter UserName" name="username">
    </div>
    <div class="form-group">
      <label for="pwd">Password :</label>
      <input type="password" class="form-control" placeholder="Enter password" name="password" id="myInput">
      <input type="checkbox" onclick="myFunction()"> Show Password
    </div>
    
    <button type="submit" class="btn btn-primary">Login</button>
    &nbsp;&nbsp;<span>Not have account ? <a style="color:red;" href="register">Register</a> </span>
  </form>
</div>

<script>
function myFunction() {
  var x = document.getElementById("myInput");
  if (x.type === "password") {
    x.type = "text";
  } else {
    x.type = "password";
  }
}
</script>

<%@include file="Footer.jsp" %>
