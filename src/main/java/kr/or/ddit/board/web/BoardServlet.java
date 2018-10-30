package kr.or.ddit.board.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.boardService.BoardService;
import kr.or.ddit.board.boardService.BoardServiceInf;
import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.user.model.UserVo;

@WebServlet("/board")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String board_id= request.getParameter("boardId");
		String board_nm= request.getParameter("boardName3");
		String user_yn = request.getParameter("boardYn3");
		String cDate = request.getParameter("boardDate");
		String cUserid = request.getParameter("boardWrite");
		
	
		BoardVo boardVo = new BoardVo();
			
		boardVo.setBoardId(board_id);
		boardVo.setBoardNm(board_nm);
		boardVo.setUseYn(user_yn);
		boardVo.setcUserid(cUserid);
		boardVo.setcDate(cDate);

		BoardServiceInf boardService = new BoardService();
		int updateBoard = boardService.updateBoard(boardVo);
		

		//	사용자 리스트로 이동해야 한다.(redirect :  서버 상태가 변경되므로 사용자가 새로고침을 통해 재요청시 중복 등록되는 현상을 막는다 
		//  새로고침을 하여도 사용자가 계속 등록되지 않게 하는 방법 
		//db에 상태 변경이 있을때에는 sendRedirect를 사용해야 된다
		
		//sendRedirect-> 계속 등록되는 것을 막는것 
		response.sendRedirect("/board/boardManage.jsp");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글 깨질떄 
		// post 한글 파라미터 인코딩 처리 
		request.setCharacterEncoding("utf-8");
		
		String board_nm= request.getParameter("boardName");
		String user_yn = request.getParameter("selected");
		
		BoardVo boardVo = new BoardVo();
		
		UserVo userVo =  (UserVo)(request.getSession().getAttribute("user")); 
	
		boardVo.setBoardNm(board_nm);
		boardVo.setUseYn(user_yn);
		boardVo.setcUserid(userVo.getUserId());
				
		//변경할 사용자 정보 저장(jsp 화면에서 사용자에게 기존 정보를 표시)
		request.setAttribute("boardVo", boardVo);
	
		BoardServiceInf boardService = new BoardService();
		int insertBoard = boardService.insertBoard(boardVo);
		
		//	사용자 리스트로 이동해야 한다.(redirect :  서버 상태가 변경되므로 사용자가 새로고침을 통해 재요청시 중복 등록되는 현상을 막는다 
		//  새로고침을 하여도 사용자가 계속 등록되지 않게 하는 방법 
		//db에 상태 변경이 있을때에는 sendRedirect를 사용해야 된다
		response.sendRedirect("/board/boardManage.jsp");
		
	}

}
