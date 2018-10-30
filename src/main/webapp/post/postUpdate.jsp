<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>postUpdate.jsp</title>

<style type="text/css">

	#savebutton {
		margin-left: 650px;
		background-color: lightgray;
		color: black;
	}
		
	#title{
		width: 766px;
		font-size: 25px;
		background-color: lightgray;
		color: white;
		margin-top: 50px;
		margin-left: 240px;
	}
	
	#titleSelect{
		margin-left: 10px;
		margin-top: 2px;
	}
	
	#h5{
		width: 82.5px;
		float: left;
		color: #f4428c;
	}
	
	#frm{
		margin-left: 240px;
		margin-top: 15px;
	}
	
	.boardTitle{
		width: 766px;
		margin-bottom: 15px;
		border-color: lightgray;

	}
	
	 #boardTitle2{
	 	width: 100px;
	 	text-align: center;
	 }
	 
	 .postButton{
		width: 80px;

		
	 }
	 
	 #deleteButton , #updateButton , #listButton{
	 	background-color: pink;
		color: black;		
	 }
	 
	 #updateButton{
	 	margin-left: 660px;
	 	margin-top: 10px;
	 }
	 
	 #center{
		float: left;
	 	margin-left: 10px;
	 }

</style>
<%@ include file="/common/basicLib.jsp"%>
</head>
<body>
<%@ include file="/common/header.jsp"%>
			<%-- left --%>
			<%@ include file="/common/left.jsp"%>
			
<div id="title">게시판 글 수정하기</div>
			
<form action="/postSave?post_no=${postVo.post_no}" method="post" id="frm">

	<table class="boardTitle" border="1">
		<tr>
			<td id="boardTitle2">
				<label id="h5">게시글 제목</label>&nbsp;&nbsp;&nbsp;
			</td>
			<td colspan="3">
				<input type="text" id="titleSelect" name="boardTitle" placeholder="${postVo.title}"/>
			</td>
		</tr>
		<tr>
			<td id="boardTitle2">
				<label id="h5">작성일시</label>
			</td>
			<td>
				<label id="titleSelect"><fmt:formatDate value="${postVo.c_date }" pattern="yyyy-MM-dd"></fmt:formatDate></label>
			</td>
			<td id="boardTitle2">
				<label id="h5">작성자</label>
			</td>
			<td>
				<label id="titleSelect">${postVo.userid}</label>
			</td>
		</tr>
	</table>
	
	<textarea name="smarteditor" id="smarteditor" rows="10" cols="100" style="width:766px; height:412px;" placeholder="${postVo.cnt}"></textarea> 

	<div id="center">
		<input id="updateButton" type="submit"  value="저장"/>
		<input id="listButton" type="button"  value="목록"/>
	</div>
</form>
			
			
</body>
</html>