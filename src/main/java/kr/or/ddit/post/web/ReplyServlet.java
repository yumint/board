package kr.or.ddit.post.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.post.model.ReplyVo;
import kr.or.ddit.post.postService.PostService;
import kr.or.ddit.post.postService.PostServiceInf;
import kr.or.ddit.user.model.UserVo;


@WebServlet("/reply")
public class ReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글 깨질떄 
		// post 한글 파라미터 인코딩 처리 
		request.setCharacterEncoding("utf-8");
		
		String post_no = request.getParameter("post_no");
		String comment_cnt = request.getParameter("userWriteReply");
		String userid = request.getParameter("userid");
		
		ReplyVo replyVo = new ReplyVo();
		
		replyVo.setPost_no(post_no);
		replyVo.setComment_cnt(comment_cnt);
		replyVo.setC_userid(userid);
		
		System.out.println(replyVo);
	
		PostServiceInf postService = new PostService();
		
		int postInsert = postService.postReplyWrite(replyVo);
				
		//sendRedirect-> 계속 등록되는 것을 막는것 
		response.sendRedirect("/postDetail?post_no="+post_no);
	
	}

}
