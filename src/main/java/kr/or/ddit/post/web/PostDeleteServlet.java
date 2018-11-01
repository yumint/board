package kr.or.ddit.post.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.post.postService.PostService;
import kr.or.ddit.post.postService.PostServiceInf;


@WebServlet("/postDelete")
public class PostDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String post_no = request.getParameter("post_no");
		String board_id = request.getParameter("board_id");
		
		System.out.println(post_no);
		System.out.println(board_id);
		
		
		PostServiceInf postService = new PostService();
		
		int postDelete = postService.postDelete(post_no);
		
		//sendRedirect-> 계속 등록되는 것을 막는것 
		//response.sendRedirect("/postList?page=1&pageSize=10&board_id="+board_id); 안됨
		
		request.getRequestDispatcher("/postList?page=1&pageSize=10&board_id="+board_id).forward(request, response);
		
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
