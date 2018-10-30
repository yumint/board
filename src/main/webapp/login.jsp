<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">


<title>login.jsp</title>

<style>
	body {
	  padding-top: 40px;
	  padding-bottom: 40px;
	  background-color: #eee;
	}
	
	.form-signin {
	  max-width: 330px;
	  padding: 15px;
	  margin: 0 auto;
	}
	.form-signin .form-signin-heading,
	.form-signin .checkbox {
	  margin-bottom: 10px;
	}
	.form-signin .checkbox {
	  font-weight: normal;
	}
	.form-signin .form-control {
	  position: relative;
	  height: auto;
	  -webkit-box-sizing: border-box;
	     -moz-box-sizing: border-box;
	          box-sizing: border-box;
	  padding: 10px;
	  font-size: 16px;
	}
	.form-signin .form-control:focus {
	  z-index: 2;
	}
	.form-signin input[type="email"] {
	  margin-bottom: -1px;
	  border-bottom-right-radius: 0;
	  border-bottom-left-radius: 0;
	}
	.form-signin input[type="password"] {
	  margin-bottom: 10px;
	  border-top-left-radius: 0;
	  border-top-right-radius: 0;
	}
	
	#button{
		background-color: pink;
		border-color: lightgray;
	}
	
	#image{
		padding-bottom: 20px;
	}
	
	
</style>

 <!-- Bootstrap core CSS -->
    <script type="text/javascript">
    $(document).ready(function(){
    	console.log("test");
    	// remember 쿠키값이 Y이면 
    	var cookieValue = getCookie("remember");
 
    	// remember-me 체크박스 체크 
    	if(cookieValue == "Y"){
    		$("#checkbox").attr("checked", true );
	    	// userId input value 를 userId 쿠키 값으로 설정 
	    	var userId = getCookie("userId");
	    	
	    	$("#userId").attr("value" , userId);
    	}
    	
    	
    });
    
    function getCookie(cookieName){
       //cookieString --> document.cookie
       var cookies = document.cookie.split("; ");
       var getCookieValue = "";
       for(var i=0;i<cookies.length;i++){
          var str = cookies[i];
          if(str.startsWith(cookieName +"=")){
             CookieValue = str.substring((cookieName + "=").length);
          }
       }

       return CookieValue;
    }
    
    // getCookie("userId");
    // getCookie("remember");
    
    </script>

</head>
<body>


	<%@include file="/common/basicLib.jsp" %>
	
    <div class="container">
      <form class="form-signin" action="/login" method="post">
        
        <img alt="noimage" src="/img/catlogo.png" width="300px" id="image">
        <input id="userId" type="text" name="userId" class="form-control" placeholder="UserId" required autofocus value="">
        <input type="password" name="password" class="form-control" placeholder="Password" required value="">
     	<div class="checkbox">
     		<label>
     			<input id="checkbox" type="checkbox" value="remember-me" name="remember-me"/>
     			아이디 기억하기
     		</label>
     		<button id="button" class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
     	</div>
      </form>

    </div> <!-- /container -->

  </body>
</html>
