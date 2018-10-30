<%@page import="kr.or.ddit.board.boardService.BoardService"%>
<%@page import="kr.or.ddit.board.boardService.BoardServiceInf"%>
<%@page import="kr.or.ddit.board.model.BoardVo"%>
<%@page import="java.util.List"%>
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

<script src="/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#produce").on( 'click' , function(event){
				
		event.preventDefault();	// 이벤트 제거 하기 
		 var boardName = $("#boardName2").val();
	
			if(boardName == ""){
				alert('빈칸인 부분이 있습니다.\n입력하신후에 생성 버튼을 클릭하시기 바랍니다.'); 	
				return false;
			}
			$("#boardForm").submit();	// 입력되었다면 보내게끔 설정하기
		});	
		
		$(".produce2").on('click' , function(event){
			
			event.preventDefault();	// 이벤트 제거 하기 
			var boardId = $($(this).siblings()[0]).val();
			var boardName = $($(this).siblings()[2]).val();
			var boardDate = $($(this).siblings()[3]).val();
			var boardWrite = $($(this).siblings()[4]).val();
			var boardYn = $($(this).siblings()[5]).val();
			
			$("#boardId").val(boardId);
			$("#boardName3").val(boardName);
			$("#boardYn3").val(boardYn);
			$("#boardDate").val(boardDate);
			$("#boardWrite").val(boardWrite);

			alert('수정되었습니다');
			
			$("#frm").submit();

		});
		
	});
</script>
<style type="text/css">
#produce {
	background-color: lightgray;
	border-color: lightgray;
	width: 70px;
	height: 35px;
	margin-bottom: 10px;
	color: white;
}

.produce2 {
	background-color: lightgray !important;
	border-color: lightgray !important;
	width: 70px !important;
	height: 35px;
	margin-bottom: 10px;
	color: white !important;
}

#selected {
	width: 150px;
	float: left;
	margin-right: 10px;
}

.board {
	float: left;
}

#boardName {
	width: 100px;
	float: left;
	background-color: pink;
	border-color: lightgray;
	height: 35px;
	margin-bottom: 10px;
	margin-right: 10px;
	color: white;
}

#boardName2 {
	width: 200px;
	float: left;
	margin-right: 10px;
}
</style>


<%@ include file="/common/basicLib.jsp"%>
</head>

<body>

<form id="frm" action="/board" method="get" >
	<input type="hidden" id="boardId" name="boardId" />
	<input type="hidden" id="boardName3" name="boardName3" />
	<input type="hidden" id="boardYn3" name="boardYn3" />
	<input type="hidden" id="boardDate" name="boardDate" />
	<input type="hidden" id="boardWrite" name="boardWrite" />
</form>


	<%-- @은 지시자 --%>
	<%-- header --%>
	<%@ include file="/common/header.jsp"%>

	<div class="container-fluid">
		<div class="row">

			<%-- left --%>
			<%@ include file="/common/left.jsp"%>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="blog-header"></div>

				<div class="row">

					<div class="col-sm-8 blog-main">

						<!-- 내용시작 -->

						<table>
							<tr>
								<td width="100px;">
									<h3>게시판 생성하기</h3> <br>
								</td>
							</tr>
							<tr>
								<td>
									<form id="boardForm" action="/board" method="post">

										<div class="board">
											<label id="boardName" class="form-control"> 게시판이름</label> <input
												type="text" id="boardName2" name="boardName"
												class="form-control"> <select name="selected"
												class="form-control" id="selected">
												<option value="Y" class="form-control">:::사용여부선택:::</option>

												<option value="Y" class="form-control">사용</option>
												<option value="N" class="form-control">미사용</option>
											</select>
											<button type="button" id="produce"
												class="btn btn-lg btn-primary btn-block">생성</button>
										</div>
									</form>
								</td>
							</tr>
							<tr>
								<td><br>
									<h4>게시판 관리</h4></td>
							</tr>

							<%
								//서비스 객체 생성 
								BoardServiceInf sv = new BoardService();
								List<BoardVo> boardList = service.boardList(null);

								for (int i = 0; i < boardList.size(); i++) {
							%>
							<tr>
								<td>
									<div class="board">
										<input type="hidden" value="<%=boardList.get(i).getBoardId()%>" id="boardId"/>
										<label id="boardName" class="form-control"> 게시판이름</label> 
										<input class="form-control" type="text" id="boardName2"
											name="boardName" value="<%=boardList.get(i).getBoardNm()%>">
										<input type="hidden" value="<%=boardList.get(i).getcDate()%>" id="boardDate"/>
										<input type="hidden" value="<%=boardList.get(i).getcUserid()%>" id="boardWrite"/>
										<select id="selected" name="selected" class="form-control">

											
											
											<%
												if (boardList.get(i).getUseYn() == "Y"
															|| "Y".equals(boardList.get(i).getUseYn())) {
											%>
											<option value="Y" selected>사용</option>
											<option value="N">미사용</option>
											<%
												} else {
											%>
											<option value="Y">사용</option>
											<option value="N" selected>미사용</option>
											<%
												}
											%>
										</select>
										<button type="button"  class="produce2 btn btn-lg btn-primary btn-block " >수정</button>
									</div>
								</td>
							</tr>

							<%
								}
							%>

						</table>

						<!-- /.blog-main -->
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>