package kr.or.ddit.user.userDao;

import kr.or.ddit.user.model.UserVo;

public interface UserDaoInf {
	
	/**  * Method   : selectUser
	  * 작성자 : PC 
	  * 변경이력 :  
	  * @param userId
	  * @return
	  * Method 설명 :  매개변수를 사용자의 아이디로 받아서 회원 정보를 알려준다
	*/
	// 매개변수를 아이디로 받아서 해당 대상자 조회하는 쿼리 
	public UserVo selectUser(String userId);
	
	

}
