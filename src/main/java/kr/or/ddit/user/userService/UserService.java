package kr.or.ddit.user.userService;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.userDao.UserDao;
import kr.or.ddit.user.userDao.UserDaoInf;

public class UserService implements UserServiceInf {
	
	private UserDaoInf userDao = UserDao.getInstance();

	@Override
	public UserVo selectUser(String userId) {
			return userDao.selectUser(userId);
	}

}
