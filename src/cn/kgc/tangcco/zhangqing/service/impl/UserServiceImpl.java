package cn.kgc.tangcco.zhangqing.service.impl;

import java.util.List;

import cn.kgc.tangcco.zhangqing.common.PropertiesFactory;
import cn.kgc.tangcco.zhangqing.dao.UserDao;
import cn.kgc.tangcco.zhangqing.entity.User;
import cn.kgc.tangcco.zhangqing.service.UserService;

public class UserServiceImpl implements UserService {
	
	private UserDao ud =(UserDao) PropertiesFactory.getInstance("UserDao");

	@Override
	public List<User> selectUser() {
		return ud.selectUser();
	}

}
