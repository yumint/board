<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>post.jsp</title>



<style type="text/css">

	#btn{
		background-color: pink;
		color: white;
	}
	

	 a:link { color: black; text-decoration: none;}
	 a:visited { color: black; text-decoration: none;}
	
	.list{
		text-align: center;
	}
	 

</style>



<%@ include file="/common/basicLib.jsp"%>
</head>
<body>
	
<%@ include file="/common/header.jsp"%>
			<%-- left --%>
			<%@ include file="/common/left.jsp"%>
		

        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main" style="background-color: white;">
            <div class="row" style="background-color: white;">
				<div class="col-sm-8 blog-main">
					<h2 class="sub-header">게시판</h2>
					<div class="table-responsive">
						<table class="table table-striped table-hover" >
							<tr>
								<th class="list">게시글 번호</th>
								<th class="list">제목</th>
								<th class="list">작성자 아이디</th>
								<th class="list">작성일시</th>
							</tr>
 							<!-- userList loop 이용하여 출력   -->
  							<c:forEach items="${pageList }" var="vo">
 								<tr class="userClick">
  									<td class="list"><a href="/postDetail?post_no=${vo.post_no}">${vo.rnum}</a></td> 
  									<td><a href="/postDetail?post_no=${vo.post_no}">${vo.title}</a></td>
  									<td class="list"><a href="/postDetail?post_no=${vo.post_no}">${vo.userid}</a></td>
  									<td class="list"><a href="/postDetail?post_no=${vo.post_no}"><fmt:formatDate value="${vo.c_date }" pattern="yyyy-MM-dd"></fmt:formatDate></a></td>
  								</tr> 
  						
  							</c:forEach>
						</table>
					</div>

					<a class="btn btn-default pull-right" href="/post/postWrite.jsp?board_id=${board_id }&page=${page}" id="btn">새 게시글 등록</a>

								
					<div class="text-center">
						<ul class="pagination">
	
					<!-- 페이징 처리 -->
<!-- 게시글이 없다면 페이지수가 나오지 않게 설정하는 부분 -->
<c:choose>
	<c:when test="${pageCnt == 0 }">
		
			<!-- 처음페이지 -->
			<li class="disabled"> 
	 			<a tabindex="-1" href="#" aria-label="Previous"> 
	 			<span aria-hidden="true">&laquo;처음페이지</span> 
	 			</a>
			</li> 
			
			<!-- 이전페이지  -->
			<li class="disabled"> 
		 		<a tabindex="-1" href="#" aria-label="Previous"> 
		 		<span aria-hidden="true">&laquo;</span> 
		 		</a>
			</li> 
			
			<!-- 다음페이지 -->
			<li class="disabled"> 
	 			<a tabindex="-1" href="#" aria-label="Next">
	 			<span aria-hidden="true">&raquo;</span> 
				</a> 
 			</li>
 			
 			<!-- 마지막 페이지 -->
 			<li class="disabled"> 
	 			<a tabindex="-1" href="#" aria-label="Next">
	 			<span aria-hidden="true">마지막페이지&raquo;</span> 
				</a> 
	 		</li>				
	
	</c:when>
	
	<c:otherwise>
						<!-- 처음페이지 -->
							<c:choose>
								<c:when test="${page=='1'}">
	 							   <li class="disabled"> 
	 							      <a tabindex="-1" href="#" aria-label="Previous"> 
	 							        <span aria-hidden="true">&laquo;처음페이지</span> 
	 							      </a>
								    </li> 
							    </c:when>
							    <c:otherwise>
							    	<li>
	 							      <a href="/postList?page=1&pageSize=10&board_id=${board_id }" aria-label="Previous"> 
	 							        <span aria-hidden="true">&laquo;처음페이지</span> 
	 							      </a>
								    </li> 							    
							    </c:otherwise>
							</c:choose>
						<!-- 이전페이지 -->
						<!-- 1페이지일경우에는 이전페이지가 없기떄문에 if문을 이용한다 -->
							<c:choose>
								<c:when test="${page=='1'}">
									 <li class="disabled"> 
		 							      <a tabindex="-1" href="#" aria-label="Previous"> 
		 							        <span aria-hidden="true">&laquo;</span> 
		 							      </a>
								   	 </li> 
								</c:when>
								
								<c:otherwise>
								    <li> 
	 							      <a href="/postList?page=${page-1}&pageSize=10&board_id=${board_id }" aria-label="Previous"> 
	 							        <span aria-hidden="true">&laquo;</span> 
	 							      </a>
								    </li> 
							    </c:otherwise>
							</c:choose> 
							
						<!-- 화면에서 페이지수 나오는 부분  -->   
				
 							<c:forEach begin="1" end="${pageCnt }" var="page" > 
		  								<tr>  
		  									<li><a href="/postList?page=${page}&pageSize=10&board_id=${board_id }">${page}</a></li>
		 								</tr>  

  							</c:forEach> 
  							
  						<!-- 다음페이지 -->
  						
  						<c:choose>
							<c:when test="${page == pageCnt}">	
								<li class="disabled"> 
	 						      <a tabindex="-1" href="#" aria-label="Next">
	 						        <span aria-hidden="true">&raquo;</span> 
							      </a> 
 						    	</li>
 						    </c:when>
 						    <c:otherwise>
						 	 <li> 
 						      <a href="/postList?page=${page+1}&pageSize=10&board_id=${board_id }" aria-label="Next">
 						        <span aria-hidden="true">&raquo;</span> 
						      </a> 
 						    </li>
 						    </c:otherwise>
 						    
 						</c:choose>
 						    
						<!-- 마지막페이지 -->
						
						<c:choose>
							<c:when test="${page == pageCnt}">	
	 						    <li class="disabled"> 
	 						      <a tabindex="-1" href="#" aria-label="Next">
	 						        <span aria-hidden="true">마지막페이지&raquo;</span> 
							      </a> 
	 						    </li>				    	
							</c:when>
							<c:otherwise>
								 <li> 
	 						      <a href="/postList?page=${pageCnt}&pageSize=10&board_id=${board_id }" aria-label="Next">
	 						        <span aria-hidden="true">마지막페이지&raquo;</span> 
							      </a> 
	 						    </li>
							</c:otherwise>
						 </c:choose>
						 
	</c:otherwise>					 					  
</c:choose>					 
						 
						   
						</ul>
						
					</div>
				</div>
			</div>
         </div>
</body>
</html>