package com.bbs.bizImpl;

import java.util.List;

import com.bbs.biz.UserBiz;
import com.bbs.dao.UserDao;
import com.bbs.model.User;

/**
 * @author 张建浩、卜凡、卢静、余莎、姚文娜
 * @version 1.0 2016年3月16日下午2:44:35
 */
public class UserBizImpl implements UserBiz{
	private UserDao userDao;

	
	/**
	 * 框架自动注入userDao
	 * @param userDao the userDao to set
	 */
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	/* (non-Javadoc)
	 * @see com.bbs.biz.UserBiz#regist(com.bbs.model.User)
	 */
	@Override
	public int regist(User user) {
		userDao.regist(user);
		return 0;
	}


	/* (non-Javadoc)
	 * @see com.bbs.biz.UserBiz#login(com.bbs.model.User)
	 */
	@Override
	public int login(String username,String password) {
		List<User> users = userDao.login(username,password);
		if (users != null && users.size() > 0){
			if (users.get(0).getPassword().equals(password))
				return 1;
			return -1;
		}else 
			return 0;
	}


	/* (non-Javadoc)
	 * @see com.bbs.biz.UserBiz#isExist(com.bbs.model.User)
	 */
	@Override
	public int isExist(User user) {
		return userDao.isExist(user);
	}


	
	


	/* (non-Javadoc)
	 * @see com.bbs.biz.UserBiz#activeUser(java.lang.String)
	 */
	@Override
	public int activeUser(String code) {
		return userDao.activeUser(code);
	}


	/* (non-Javadoc)
	 * @see com.bbs.biz.UserBiz#updateCode(java.lang.String, java.lang.String)
	 */
	@Override
	public void updateCode(String username, String code) {
		// TODO Auto-generated method stub
		userDao.updateCode(username,code);
		
	}
	
	

}