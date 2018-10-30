<%@page import="kr.or.ddit.board.model.BoardVo"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.board.boardService.BoardService"%>
<%@page import="kr.or.ddit.board.boardService.BoardServiceInf"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>left.jsp</title>

<style type="text/css">
	.col-sm-3 col-md-2 sidebar {
		background-color: #fcfcf7;
		color: #9d9d9d;
	}
	
	.active > .active > a:hover,
	.active > .active > a:focus {
	  color: #fff;
	  background-color: #080808;
	}

	.menu:hover{
		color: white !important;
    }
    
    .active {
    	padding-bottom: 5px;
    	height: 40px;
    }

	.menu {
		font-size : 18px;
    	height: 30px;
    	width: 100%;
	}


</style>


</head>
<body>

<div class="col-sm-3 col-md-2 sidebar">
	<ul class="nav nav-sidebar">
		<li class="active" ></li>
		<li class="active" ><a href="/main.jsp" class="sr-only menu">Main</a></li>
		<li class="active" ><a href="/board/boardManage.jsp" class="sr-only menu"> 게시판관리 </a></li>

		<!-- 사용자 리스트 클릭시 : jspuser 전체 정보를 조회하여 화면에 출력 
		
			0. 요청을 처리할 서블릿 생성 : UserServlet
			1. jspuser 전체 정보를 조회 : service.selectUserAll()
			2. 사용자 정보를 화면에 출력할 jsp화면 : userAllList.jsp  
		
		 -->
		 
			 <%
				//서비스 객체 생성 
				BoardServiceInf service = new BoardService();
			 	BoardVo boardVo = new BoardVo();
			 	boardVo.setUseYn("Y");
				List<BoardVo> list = service.boardList(boardVo);
		
				for(int i = 0; i < list.size(); i++){
			%>
					<li class="active boardName"><a href="/postList?page=1&pageSize=10&board_id=<%=list.get(i).getBoardId()%>" class="sr-only menu">
					<%=list.get(i).getBoardNm()%> 
					</a></li>
				
			<% 		
				}
			%>
	</ul>
</div>

</body>
</html>