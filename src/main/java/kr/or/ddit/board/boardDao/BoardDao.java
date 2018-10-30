package kr.or.ddit.board.boardDao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.db.SqlFactoryBuilder;


public class BoardDao implements BoardDaoInf {
	
	public BoardDao () {}
	private static BoardDaoInf boardDao = null;
	
	public static BoardDaoInf getInstance() {
		if(boardDao == null) {
			boardDao = new BoardDao();
		}
		return boardDao;
	}	


	
	/**  * Method   : boardList
	  * 작성자 : PC 
	  * 변경이력 :  
	  * @return
	  * Method 설명 :  게시판 리스트 나오는 부분
	*/
	@Override
	public List<BoardVo> boardList(BoardVo boardVo) {

		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		
		
		List<BoardVo> board = session.selectList("board.boardList" ,boardVo);
		session.close();
		
		// 매개변수가 없어서 값을 주지 않아도 된다 
		// 여러건을 조회할때에는 selectList를 사용한다
		// selectOne : 데이터가 한건 일 떄 
		// 메소드 인자 : 문자열 = 네임스페이스(일반적으로 모듈명을 이용) .쿼리아이디 
		return board;
	}


	/**  * Method   : boardList
	  * 작성자 : PC 
	  * 변경이력 :  
	  * @return
	  * Method 설명 :  게시판 리스트 나오는 부분
	*/
	@Override
	public int insertBoard(BoardVo boardVo) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int insertBoard = session.insert("board.insertBoard", boardVo);
		
		// commit을 해야 데이터가 확정된다 ( 꼭 해주기 !)
		session.commit();
		session.close();
		
		return insertBoard;
	}


	/**  * Method   : updateUser
	  * 작성자 : PC 
	  * 변경이력 :  
	  * @param boardId
	  * @return
	  * Method 설명 :  게시판 정보 수정
	*/
	@Override
	public int updateBoard(BoardVo boardVo) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int updateBoard = session.update("board.updateBoard", boardVo);
		
		// commit을 해야 데이터가 확정된다 ( 꼭 해주기 !)
		session.commit();
		session.close();
		
		return updateBoard;
	}


}
