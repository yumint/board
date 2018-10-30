<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>header.jsp</title>

<style type="text/css">
  #navbar , #header {
  	background-color: pink;
  }
  
  .logo{
  	padding-bottom: 10px;
  	padding-top: 10px;
  }
  
  #headermenu{
  	padding-top: 10px;
  }
  
</style>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
	<div id ="header"class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>

		</div>
		
		<div id="navbar" class="navbar-collapse collapse">
				<img onclick="http://localhost:8081/main.jsp" class="logo" alt="logo" src="/img/catlogo2.jpg" width="200px"/>
			<ul class="nav navbar-nav navbar-right" id="headermenu">
				<li><a href="#">Dashboard</a></li>
				<li><a href="#">Settings</a></li>
				<li><a href="#">Profile</a></li>
				<li><a href="#">Help</a></li>
				<li><a href="/logout">Logout</a></li>
			</ul>
			<form class="navbar-form navbar-right" id="headermenu">
				<input type="text" class="form-control" placeholder="Search...">
			</form>
		</div>
	</div>
</nav>

</body>
</html>