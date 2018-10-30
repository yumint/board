package kr.or.ddit.board.boardDao;

import java.util.List;
import kr.or.ddit.board.model.BoardVo;

public interface BoardDaoInf {
	

	/**  * Method   : boardList
	  * 작성자 : PC 
	  * 변경이력 :  
	  * @return
	  * Method 설명 :  게시판 리스트 나오는 부분
	*/
	public List<BoardVo> boardList(BoardVo boardVo);
	
	/**  * Method   : insertUser
	  * 작성자 : PC 
	  * 변경이력 :  
	  * @param boardVo
	  * @return
	  * Method 설명 :  게시판 추가하는 부분
	*/
	int insertBoard(BoardVo boardVo);
	
	/**  * Method   : updateBoard
	  * 작성자 : PC 
	  * 변경이력 :  
	  * @param boardId
	  * @return
	  * Method 설명 :  게시판 정보 수정
	*/
	int updateBoard(BoardVo boardVo);
	



}
