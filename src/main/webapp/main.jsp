<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>main.jsp</title>

<style type="text/css">
	#userName{
		color: pink;
	}
</style>
	<%@ include file="/common/basicLib.jsp" %> 
</head>

<body>
   <%-- @은 지시자 --%>
   <%-- header --%>
   <%@ include file="/common/header.jsp" %> 
   
   <div class="container-fluid">
      <div class="row">
      
         <%-- left --%>
         <%@ include file="/common/left.jsp" %>
         
         <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <div class="blog-header">
       
            </div>

            <div class="row">

               <div class="col-sm-8 blog-main">

                  <div class="blog-post">
                  <%UserVo userVo = (UserVo)request.getSession().getAttribute("user"); %>
                  		<label id="userName"><%=userVo.getUserId() %>님 안녕하세요</label>
   						<img alt="cat.img" src="/img/cat1.jpg">
                  </div>
               </div>
               <!-- /.blog-main -->
            </div>
         </div>
      </div>
   </div>
</body>
</html>