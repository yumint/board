package kr.or.ddit.post.postDao;

import java.util.List;

import kr.or.ddit.db.SqlFactoryBuilder;
import kr.or.ddit.post.model.PageVo;
import kr.or.ddit.post.model.PostVo;
import kr.or.ddit.post.model.ReplyVo;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class PostDao implements PostDaoInf {
	
	public PostDao () {}
	private static PostDaoInf postDao = null;
	
	public static PostDaoInf getInstance() {
		if(postDao == null) {
			postDao = new PostDao();
		}
		return postDao;
	}	
	

	// 페이징 처리 
	public List<PageVo> selectBoardPageList(PageVo pageVo) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
	
		List<PageVo> pageList = session.selectList("post.boardPageList", pageVo);
		
		// 명시적으로 처리해 주기 
		//session.rollback();
		//session.commit();
		
		// 세션을 사용했으니깐 닫아준다
		session.close();
		
		// 매개변수가 없어서 값을 주지 않아도 된다 
		// 여러건을 조회할때에는 selectList를 사용한다
		// selectOne : 데이터가 한건 일 떄 
		// 메소드 인자 : 문자열 = 네임스페이스(일반적으로 모듈명을 이용) .쿼리아이디 
		return pageList;
	}
	
	/**  * Method   : getBoardCnt
	  * 작성자 : PC 
	  * 변경이력 :  
	  * @return
	  * Method 설명 :  게시판 전체 건수 조회 
	*/
	public int getBoardCnt(String board_id) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int totalBoardCnt = session.selectOne("post.getBoardCnt" , board_id);
		
		session.close();
		
		return totalBoardCnt;
	}


	/**  * Method   : postInsert
	  * 작성자 : PC 
	  * 변경이력 :  
	  * @return
	  * Method 설명 :  새 게시글 등록 
	*/
	public int postInsert(PostVo postVo) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int boardInsert = session.insert("post.postInsert" , postVo);
		
		// 추가해주는 것이기 때문에 커밋까지 완료해야 한다
		session.commit();
		session.close();
		
		return boardInsert;
	}


	/**  * Method   : postDetail
	  * 작성자 : PC 
	  * 변경이력 :  
	  * @param post_no
	  * @return
	  * Method 설명 : 글 상세보기  
	*/
	public PostVo postDetail(String post_no) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		PostVo postVo = session.selectOne("post.boardDetail" , post_no);
		
		session.close();
		
		return postVo;
	}


	/**  * Method   : postUpdate
	  * 작성자 : PC 
	  * 변경이력 :  
	  * @param post_no
	  * @return
	  * Method 설명 :  글 수정하는 부분
	*/
	public int postUpdate(PostVo postVo) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int postUpdate = session.update("post.boardUpdate" , postVo);
		
		// 추가해주는 것이기 때문에 커밋까지 완료해야 한다
		session.commit();
		session.close();
		
		return postUpdate;
	}

	/**  * Method   : postReply
	  * 작성자 : PC 
	  * 변경이력 :  
	  * @param post_no
	  * @return
	  * Method 설명 :  게시글의 댓글 가지고 오는 쿼리
	*/
	public List<ReplyVo> postReply(String post_no) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		List<ReplyVo> replyVo = session.selectList("reply.postReply" , post_no);
		
		session.close();
		
		return replyVo;
	}

	/**  * Method   : postReplyWrite
	  * 작성자 : PC 
	  * 변경이력 :  
	  * @param replyVo
	  * @return
	  * Method 설명 : 댓글입력하면 추가해주는 부분
	*/
	@Override
	public int postReplyWrite(ReplyVo replyVo) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int replyInsert = session.insert("reply.postReplyWrite" , replyVo);
		
		// 추가해주는 것이기 때문에 커밋까지 완료해야 한다
		session.commit();
		session.close();
		
		return replyInsert;
	}

	/**  * Method   : postDelete
	  * 작성자 : PC 
	  * 변경이력 :  
	  * @param post_no
	  * @return
	  * Method 설명 : 게시글 삭제하는 부분 
	*/
	@Override
	public int postDelete(String post_no) {
		
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int postDelete = session.update("post.postDelete" , post_no);
		
		// 추가해주는 것이기 때문에 커밋까지 완료해야 한다
		session.commit();
		session.close();
		
		return postDelete;
		
	}


}
