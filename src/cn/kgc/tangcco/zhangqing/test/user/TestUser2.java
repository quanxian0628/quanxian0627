package cn.kgc.tangcco.zhangqing.test.user;

import org.junit.Before;
import org.junit.Test;

import cn.kgc.tangcco.zhangqing.common.PropertiesFactory;
import cn.kgc.tangcco.zhangqing.dao.UserDao;
import cn.kgc.tangcco.zhangqing.service.UserService;

public class TestUser2 {
	private UserDao dao;
	private UserService services;
	@Before
	public void init() {
		dao = (UserDao) PropertiesFactory.getInstance("UserDao");
		this.services = (UserService) PropertiesFactory.getInstance("UserService");
	}
	@Test
	public void testUserDao() throws Exception {
	}
}
