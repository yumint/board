package kr.or.ddit.user.userDao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.db.SqlFactoryBuilder;
import kr.or.ddit.user.model.UserVo;

public class UserDao implements UserDaoInf {
	
	public UserDao () {}
	private static UserDaoInf userDao = null;
	
	public static UserDaoInf getInstance() {
		if(userDao == null) {
			userDao = new UserDao();
		}
		return userDao;
	}	

	
	/**  * Method   : selectUser
	  * 작성자 : PC 
	  * 변경이력 :  
	  * @param userId
	  * @return
	  * Method 설명 :  매개변수를 사용자의 아이디로 받아서 회원 정보를 알려준다
	*/
	@Override
	public UserVo selectUser(String userId) {
	
			SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
			SqlSession session = factory.openSession();
			
			UserVo user = session.selectOne("user.selectUser",userId);
			
			session.close();
			
			// 매개변수가 없어서 값을 주지 않아도 된다 
			// 여러건을 조회할때에는 selectList를 사용한다
			// selectOne : 데이터가 한건 일 떄 
			// 메소드 인자 : 문자열 = 네임스페이스(일반적으로 모듈명을 이용) .쿼리아이디 
			return user;
	}
	

}
