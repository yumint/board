package kr.or.ddit.post.web;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.post.model.PostVo;
import kr.or.ddit.post.postService.PostService;
import kr.or.ddit.post.postService.PostServiceInf;
import kr.or.ddit.user.model.UserVo;

@WebServlet("/postInsert")
public class PostInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 한글 깨질떄 
		// post 한글 파라미터 인코딩 처리 
		request.setCharacterEncoding("utf-8");
		
		String title = request.getParameter("titleSelect");
		String content = request.getParameter("smarteditor");
		String boardId = request.getParameter("board_id");
		
		// 로그인 아이디 가지고 오는것 
		UserVo userVo = (UserVo)request.getSession().getAttribute("user");
		String userid = userVo.getUserId();
	
		PostVo postVo = new PostVo();
		
		postVo.setTitle(title);
		postVo.setCnt(content);
		postVo.setD_yn("N");	// 처음에는 삭제여부 N으로 설정
		postVo.setBoard_id(boardId);
		postVo.setUserid(userid);
		//post_no -> 이부분은 쿼리문에서 해결 
		//c_date -> 이부분은 쿼리문에서 sysdate이용
		//parent_no -> 이부분은 현재는 답글 , 댓글을 하지 않을것이기 때문에 쿼리에서 null처리
	
		PostServiceInf postService = new PostService();
		
		int postInsert = postService.postInsert(postVo);
		
		
		// 이부분을 입력해야 쓴글이 저장된후에 화면이 해당 게시판 페이지로 이동하게 된다
		String boardPage = request.getParameter("page");
		String board_id= request.getParameter("board_id");
		
		//sendRedirect-> 계속 등록되는 것을 막는것 
		response.sendRedirect("/postList?page="+boardPage+"&pageSize=10&board_id="+board_id);
		

	}

}
