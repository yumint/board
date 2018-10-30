package kr.or.ddit.post.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.post.model.PageVo;
import kr.or.ddit.post.model.PostVo;
import kr.or.ddit.post.postService.PostService;
import kr.or.ddit.post.postService.PostServiceInf;


@WebServlet("/postList")
public class PostListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 파라미터로 값 받기
		String board_id = request.getParameter("board_id");
		
		PageVo pageVo = new PageVo();
		
		//Integer.parseInt-> 숫자로 변환
		pageVo.setPage(Integer.parseInt(request.getParameter("page")));
		pageVo.setPageSize(Integer.parseInt(request.getParameter("pageSize")));
		pageVo.setBoard_id(board_id);

						
		PostServiceInf postService = new PostService();
		
		Map<String , Object> resultMap = postService.selectBoardPageList(pageVo);

			
		List<PostVo> pageList = (List<PostVo>)resultMap.get("pageList");

		// 페이지 건수 
		int pageCnt = (int)resultMap.get("pageCnt");
		
		// request 객체에 저장 
		request.setAttribute("pageList", pageList);
		request.setAttribute("pageCnt", pageCnt);
		
		// 아이디값 객체에 저장
		request.setAttribute("board_id" , board_id);
		int page = Integer.parseInt(request.getParameter("page"));
		request.setAttribute("page" , page);
		
		// 게시글 보기에서 필요한 post_no를 객체 생성
		request.setAttribute("post_no", pageList.get(0).getPost_no());
		
		RequestDispatcher rd = request.getRequestDispatcher("/post/post.jsp");
		rd.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
