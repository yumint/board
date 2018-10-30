package kr.or.ddit.post.postDao;

import java.util.List;

import kr.or.ddit.post.model.PageVo;
import kr.or.ddit.post.model.PostVo;
import kr.or.ddit.post.model.ReplyVo;

public interface PostDaoInf {

		
	// 페이징 처리
	public List<PageVo> selectBoardPageList(PageVo pageVo);
	
	/**  * Method   : getBoardCnt
	  * 작성자 : PC 
	  * 변경이력 :  
	  * @return
	  * Method 설명 :  게시판 전체 건수 조회 
	*/
	int getBoardCnt(String board_id);
	
	/**  * Method   : postInsert
	  * 작성자 : PC 
	  * 변경이력 :  
	  * @return
	  * Method 설명 :  새 게시글 등록 
	*/
	int postInsert(PostVo postVo);
	
	
	/**  * Method   : postDetail
	  * 작성자 : PC 
	  * 변경이력 :  
	  * @param post_no
	  * @return
	  * Method 설명 : 글 상세보기  
	*/
	PostVo postDetail(String post_no);
	
	
	/**  * Method   : postUpdate
	  * 작성자 : PC 
	  * 변경이력 :  
	  * @param postVo
	  * @return
	  * Method 설명 :  글 수정하는 부분
	*/
	int postUpdate(PostVo postVo);
	
	
	/**  * Method   : postReply
	  * 작성자 : PC 
	  * 변경이력 :  
	  * @param post_no
	  * @return
	  * Method 설명 :  게시글의 댓글 가지고 오는 쿼리
	*/
	List<ReplyVo> postReply(String post_no);
	
	
	/**  * Method   : postReplyWrite
	  * 작성자 : PC 
	  * 변경이력 :  
	  * @param replyVo
	  * @return
	  * Method 설명 : 댓글입력하면 추가해주는 부분
	*/
	int postReplyWrite(ReplyVo replyVo);
	

}
