<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@include file="Header.jsp" %>

<!-- <h1 class="display-4">About Us Page</h1> -->

<!-- team member -->
  <div class="row team-row">
    <div class="col-md-4 col-sm-6 team-wrap">
      <div class="team-member text-center">
        <div class="team-img">
          <img class="rounded-circle" src="<c:url value="/folder/images/user1.png"/>" alt="image" width="200" height="200">
          <div class="overlay">
            <div class="team-details text-center">
              <p>
                Designed And Developed by Me.
              </p>
            
            </div>
          </div>
        </div>
        <h6 class="team-title">Abhishek Shukla</h6>
        <span>Developer</span>
      </div>
    </div>
  </div>

<!-- end team member -->

<div class="row">
    <div class="col-md-6 col-md-3">
      <h4 align="center">Thanks to our mentors I was able to build this website from very Scartch</h4>

    </div>
  </div>

<%@include file="Footer.jsp" %>