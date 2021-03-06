package kr.or.ddit.post.postService;

import java.util.List;
import java.util.Map;

import kr.or.ddit.post.model.PageVo;
import kr.or.ddit.post.model.PostVo;
import kr.or.ddit.post.model.ReplyVo;

public interface PostServiceInf {
	
	
	/**  * Method   : selectUserPageList
	  * 작성자 : PC 
	  * 변경이력 :  
	  * @param pageVo
	  * @return
	  * Method 설명 :  사용자 페이징 조회
	*/
	// 페이징 처리하는 방법
	Map<String , Object> selectBoardPageList(PageVo pageVo);
	
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
	  * @param post_no
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
	
	
	/**  * Method   : postDelete
	  * 작성자 : PC 
	  * 변경이력 :  
	  * @param post_no
	  * @return
	  * Method 설명 : 게시글 삭제하는 부분 
	*/
	int postDelete(String post_no);

	

}
