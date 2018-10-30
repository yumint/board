package kr.or.ddit.post.postService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.post.model.PageVo;
import kr.or.ddit.post.model.PostVo;
import kr.or.ddit.post.model.ReplyVo;
import kr.or.ddit.post.postDao.PostDao;
import kr.or.ddit.post.postDao.PostDaoInf;

public class PostService implements PostServiceInf {
	
	public PostService() {}
	private static PostServiceInf postService = null;
	
	public static PostServiceInf getInstance() {
		if(postService == null) {
			postService = new PostService();
		}
		return postService;
	}

	private PostDaoInf postDao = PostDao.getInstance();
	

	/**  * Method   : selectUserPageList
	  * 작성자 : PC 
	  * 변경이력 :  
	  * @param pageVo
	  * @return
	  * Method 설명 :  게시판 페이징 조회
	*/
	public Map<String, Object> selectBoardPageList(PageVo pageVo) {
		// 페이지에 해당 하는 유저 리스트(1~10건) 
		List<PageVo> pageList = postDao.selectBoardPageList(pageVo);
		

		// 페이지 내비게이션을 위한 전체 유저 리스트 조회 
		int totalBoardCnt = postDao.getBoardCnt(pageVo.getBoard_id());
		
		
		//리턴해야 하는게 두건일경우에는 (Map)
		// 결과를 담는 map
		Map<String , Object> resultMap = new HashMap<String , Object>();
		
		resultMap.put("pageList",pageList);
		//Math.ceil가 올림해주는 부분 
		resultMap.put("pageCnt",
				(int)Math.ceil((double)totalBoardCnt / pageVo.getPageSize()));
		
		return resultMap;
	}


	/**  * Method   : postInsert
	  * 작성자 : PC 
	  * 변경이력 :  
	  * @return
	  * Method 설명 :  새 게시글 등록 
	*/
	@Override
	public int postInsert(PostVo postVo) {
		return postDao.postInsert(postVo);
	}
	
	/**  * Method   : postDetail
	  * 작성자 : PC 
	  * 변경이력 :  
	  * @param post_no
	  * @return
	  * Method 설명 : 글 상세보기  
	*/
	@Override
	public PostVo postDetail(String post_no) {
		return postDao.postDetail(post_no);
	}


	/**  * Method   : postUpdate
	  * 작성자 : PC 
	  * 변경이력 :  
	  * @param post_no
	  * @return
	  * Method 설명 :  글 수정하는 부분
	*/
	@Override
	public int postUpdate(PostVo postVo) {
		return postDao.postUpdate(postVo);
	}

	
	/**  * Method   : postReply
	  * 작성자 : PC 
	  * 변경이력 :  
	  * @param post_no
	  * @return
	  * Method 설명 :  게시글의 댓글 가지고 오는 쿼리
	*/
	@Override
	public List<ReplyVo> postReply(String post_no) {
		return postDao.postReply(post_no);
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
		return postDao.postReplyWrite(replyVo);
	}
	
	
	

}
