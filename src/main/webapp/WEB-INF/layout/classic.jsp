<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name="title"></tiles:getAsString></title>



<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<!-- JQuery -->
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>



</head>
<body>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %> 
 <tilesx:useAttribute name="current"/>


  
  <div class="container">
 
       <!-- Static navbar -->
      <div class="navbar navbar-default" role="navigation">
        <div class="container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href=<spring:url value="/" />>Drug Hire</a>
          </div>
          <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li class="${current == 'index' ? 'active' : ''}"><a href='<spring:url value="/" />'>Home</a></li>
              <li class="${current == 'users' ? 'active' : ''}"><a href='<spring:url value="/users.html" />'>Users</a></li>
              <li class="${current == 'register' ? 'active' : ''}"><a href='<spring:url value="/register.html" />'>Register</a></li>
              <li class="${current == 'login' ? 'active' : ''}"><a href='<spring:url value="/login.html" />'>Login</a></li>
              <li><a href='<spring:url value="/Logout" />'>Logout</a></li>
              <li><a href="#">News</a></li>
             </ul>
          </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
      </div>
 
 
 
 
 	<tiles:insertAttribute name="body" />

	<br>
	<br>

	<center>
		<tiles:insertAttribute name="footer" />
	</center>
 </div> <!-- /container -->
</body>
</html>