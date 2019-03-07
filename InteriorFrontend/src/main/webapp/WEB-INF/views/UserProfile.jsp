<%@include file="Header.jsp" %>

<div class="card" style="box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.8);
  max-width: 300px;
  margin: auto;
  text-align: center;
  font-family: arial;">
  <center><img src="folder/images/user1.png" alt="UserImage" style="width:60%"></center>
  <h3>${userDetail.userName}</h3>
  <p class="title" style="color: grey;font-size: 18px;">${userDetail.emailId}</p>
  <p>Mobile No : ${userDetail.mobileNo}</p>
  <p>Address : ${userDetail.address}</p>
  <p><a href="<c:url  value='/edituserdetail/${userDetail.userName}'/>" class="btn btn-outline-primary" role="button">Edit profile</a></p>
</div>

<%@include file="Footer.jsp" %>
