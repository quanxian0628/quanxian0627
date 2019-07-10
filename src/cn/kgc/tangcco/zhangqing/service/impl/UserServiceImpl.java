package cn.kgc.tangcco.zhangqing.service.impl;

import java.util.List;

import cn.kgc.tangcco.zhangqing.common.PropertiesFactory;
import cn.kgc.tangcco.zhangqing.dao.UserDao;
import cn.kgc.tangcco.zhangqing.entity.User;
import cn.kgc.tangcco.zhangqing.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao ud = (UserDao) PropertiesFactory.getInstance("UserDao");

	@Override
	public List<User> selectUser() {
		return ud.selectUser();
	}

	@Override
	public boolean login(String uName, String uPwd) {
		List<String> sList = ud.login(uName, uPwd);

		for (String string : sList) {
			if (string.equals("行政")) {
				return true;// 有此权限
			}
		}
		return false;//没有权限
	}
}
