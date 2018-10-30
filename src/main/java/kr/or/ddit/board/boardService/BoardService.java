package kr.or.ddit.board.boardService;

import java.util.List;
import kr.or.ddit.board.boardDao.BoardDao;
import kr.or.ddit.board.boardDao.BoardDaoInf;
import kr.or.ddit.board.model.BoardVo;

public class BoardService implements BoardServiceInf {
	
	private BoardDaoInf boardDao = BoardDao.getInstance();


	/**  * Method   : boardList
	  * 작성자 : PC 
	  * 변경이력 :  
	  * @return
	  * Method 설명 :  게시판 리스트 나오는 부분
	*/
	@Override
	public List<BoardVo> boardList(BoardVo boardVo) {
		return boardDao.boardList(boardVo);
	}

	/**  * Method   : insertUser
	  * 작성자 : PC 
	  * 변경이력 :  
	  * @param boardVo
	  * @return
	  * Method 설명 :  게시판 추가하는 부분
	*/
	@Override
	public int insertBoard(BoardVo boardVo) {
		return boardDao.insertBoard(boardVo);
	}

	/**  * Method   : updateBoard
	  * 작성자 : PC 
	  * 변경이력 :  
	  * @param boardId
	  * @return
	  * Method 설명 :  게시판 정보 수정
	*/
	@Override
	public int updateBoard(BoardVo boardVo) {
		return boardDao.updateBoard(boardVo);
	}
	


}
