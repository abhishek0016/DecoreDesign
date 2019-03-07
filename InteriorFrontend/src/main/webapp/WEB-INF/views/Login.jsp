<%@include file="Header.jsp" %>


<div class="container">
  <h1 class="display-4">Login Form</h1>
  
  <c:if test="${not empty error}">
		<span style="color:red;"><b>${error}</b></span>
  </c:if>
  <c:if test="${not empty msg}">
		<span style="color:green;"><b>${msg}</b></span>
  </c:if>

  <form action="perform_login" method="post">

    <div class="form-group">
      <label for="username">UserName :</label>
      <input type="text" class="form-control" placeholder="Enter UserName" name="username" required="required" >
    </div>
    <div class="form-group">
      <label for="pwd">Password :</label>
      <input type="password" class="form-control" placeholder="Enter password" name="password" required="required" id="myInput">
      <input type="checkbox" onclick="myFunction()"> Show Password
    </div>
    <button type="submit" class="btn btn-primary">Login</button>
    &nbsp;&nbsp;<span>Not have account ? <a style="color:red;" href="register">Register</a> </span>
  </form>
  
</div>

<script>
function myFunction() {
  var x = document.getElementById("myInput");
  if (x.type == "password") {
    x.type = "text";
  } else {
    x.type = "password";
  }
}
</script>

<%@include file="Footer.jsp" %>
