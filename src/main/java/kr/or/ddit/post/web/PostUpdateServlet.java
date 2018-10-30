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

@WebServlet("/postUpdate")
public class PostUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String post_no = request.getParameter("post_no");
			
		PostServiceInf postService = new PostService();
		
		PostVo postVo = new PostVo();
		postVo = postService.postDetail(post_no);
		
		// request 객체에 저장 
		request.setAttribute("postVo", postVo);
		
		
		// getRequestDispatcher 요청이 한번만 있는것 
		request.getRequestDispatcher("/post/postUpdate.jsp?post_no="+post_no).forward(request, response);
		

		//sendRedirect-> 계속 등록되는 것을 막는것   // 이쪽으로 다시 보내주는것
		//response.sendRedirect("/post/postDetail.jsp?post_no="+post_no);
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
