package kr.or.ddit.post.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.post.model.PostVo;
import kr.or.ddit.post.postService.PostService;
import kr.or.ddit.post.postService.PostServiceInf;


@WebServlet("/postSave")
public class PostSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 한글 깨질떄 
		// post 한글 파라미터 인코딩 처리 
		request.setCharacterEncoding("utf-8");
		
		String post_no = request.getParameter("post_no");
		
		String boardTitle = request.getParameter("boardTitle");
		System.out.println(boardTitle);
		String smarteditor = request.getParameter("smarteditor");
		

		PostServiceInf postService = new PostService();
		
		PostVo postVo = new PostVo();
		postVo.setPost_no(post_no);
		postVo.setTitle(boardTitle);
		postVo.setCnt(smarteditor);
		
		int postUpdate  = postService.postUpdate(postVo);
		
		System.out.println(postVo);
		
		PostVo updateAfter = postService.postDetail(post_no);
		

		// request 객체에 저장 
		request.setAttribute("postVo", updateAfter);
		
		
		// getRequestDispatcher 요청이 한번만 있는것 
		//request.getRequestDispatcher("/post/postDetail?post_no="+post_no).forward(request, response);
		

		//sendRedirect-> 계속 등록되는 것을 막는것   // 이쪽으로 다시 보내주는것
		response.sendRedirect("/postDetail?post_no="+post_no);
	
	}

}
