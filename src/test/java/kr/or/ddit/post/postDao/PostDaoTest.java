package kr.or.ddit.post.postDao;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import kr.or.ddit.post.model.PageVo;
import kr.or.ddit.post.model.PostVo;

import org.junit.Before;
import org.junit.Test;

public class PostDaoTest {

	PostDaoInf postDao;
	
	@Before
	public void setUp(){
		postDao = new PostDao();
	}
	
	@Test
	public void selectPostListTest() {
		/***Given : 주어진 상황 ***/
		PageVo pageVo = new PageVo();
		pageVo.setPage(1);
		pageVo.setPageSize(10);
		pageVo.setBoard_id("1");
		/***When : 어떤 동작 수행(메소드 호출)***/
		List<PageVo> resultMap = postDao.selectBoardPageList(pageVo);

		/***Then : 결과가 어떠해야하는지 정의 ***/
		assertEquals(10, resultMap.size() );
	}
	
	/**  * Method   : postInsertTest
	  * 작성자 : PC 
	  * 변경이력 :  
	  * Method 설명 :  새글등록하기
	*/
	@Test
	public void postInsertTest() {
		/***Given : 주어진 상황 ***/
		PostVo postVo = new PostVo();
		Date today = new Date();
		
		postVo.setPost_no("31");
		postVo.setBoard_id("1");
		postVo.setTitle("글쓰기 테스트");
		postVo.setCnt("제발 들어가라");
		postVo.setC_date(today);
		postVo.setD_yn("N");
		postVo.setParent_no("1");
		postVo.setUserid("brown");
		
		
		/***When : 어떤 동작 수행(메소드 호출)***/
		int postInsert = postDao.postInsert(postVo);
		
		/***Then : 결과가 어떠해야하는지 정의 ***/
		assertEquals(1, postInsert );
	}

}
