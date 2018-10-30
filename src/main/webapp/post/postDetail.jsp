<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>postDetail.jsp</title>

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
	 	margin-left: 627px;
	 	margin-top: 10px;
	 }
	 
	 #reply{
	 	border-color: pink;
	 	width: 766px;
		margin-left: 240px;
		margin-top: 10px;
	 }
	 
	 .replyTitle{
		text-align: center;
		background-color: pink;
		color: white;
	 }
	 
	 #replyId , #replyUserId , #replyDate  {
	 	text-align: center;
	 }
	 
	 #userReply{
	 	border-color: pink;
	 	margin-left: 240px;
		margin-top: 10px;
		width: 766px;
	 }
	 
	 #userWriteReply{
	 	width: 512px;
	 }
	 
	 #replyWrite{
	 	text-align: center;
	 	background-color: lightgray;
	 	color: white;
	 }

	 

</style>
<%@ include file="/common/basicLib.jsp"%>
</head>
<body>
<%@ include file="/common/header.jsp"%>
			<%-- left --%>
			<%@ include file="/common/left.jsp"%>
			
<div id="title">게시판 글 상세보기</div>
			
<form action="#" method="post" id="frm">

	<table class="boardTitle" border="1">
		<tr>
			<td id="boardTitle2">
				<label id="h5">게시글 제목</label>&nbsp;&nbsp;&nbsp;
			</td>
			<td colspan="3">
				<label id="titleSelect" >${postVo.title}</label>
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
	
	<textarea name="smarteditor" id="smarteditor" rows="10" cols="100" style="width:766px; height:300px;">
	${postVo.cnt}
	</textarea> 
	
	<div id="center">
		<%UserVo userVo = (UserVo)request.getSession().getAttribute("user");%>
		<%String userid = userVo.getUserId();%>
	

		<c:choose>
			<c:when test="${postVo.userid == user.userId}">
				<input id="updateButton" type="button"  value="수정" onClick="location.href='/postUpdate?post_no=${postVo.post_no}'"/>
				<input id="deleteButton" type="button"  value="삭제" />
				<input id="listButton" type="button"  value="목록" onClick="location.href='/postList?page=1&pageSize=10&board_id=${postVo.board_id}'"/>
			</c:when>
			<c:otherwise>
				<input id="listButton" type="button"  value="목록" onClick="location.href='/postList?page=1&pageSize=10&board_id=${postVo.board_id}'"/>
			</c:otherwise>
		</c:choose>
	</div>
	
	
</form>
	<table border="1" id="reply">
		<tr>
			<td class="replyTitle"><h5>번호</h5></td>
			<td class="replyTitle"><h5>댓글내용</h5></td>
			<td class="replyTitle"><h5>댓글아이디</h5></td>
			<td class="replyTitle"><h5>작성일시</h5></td>
		</tr>
		<c:forEach items="${replyVo }" var="reply">
		<tr>
			<td id="replyId">${reply.rownum}</td>
			<td>${reply.comment_cnt}</td>
			<td id="replyUserId">${reply.c_userid}</td>
			<td id="replyDate"><fmt:formatDate value="${postVo.c_date }" pattern="yyyy-MM-dd"></fmt:formatDate></td>
		</tr>
		</c:forEach>
	</table>
	
	
	<form action="/reply" method="post">
		<input type="hidden"  value="${postVo.post_no}" name="post_no" />
		<input type="hidden"  value="${postVo.userid}" name="userid" />
		<table id="userReply">
			<tr>
				<td >
					<input id="replyWrite" value="댓글 입력"/>
					<input name="userWriteReply"  id="userWriteReply"/>
					<button type="submit">댓글달기</button>
				</td>	
			</tr>
		</table>
	</form>
			
			
</body>
</html>