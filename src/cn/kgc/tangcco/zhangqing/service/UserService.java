package cn.kgc.tangcco.zhangqing.service;

import java.util.List;

import cn.kgc.tangcco.zhangqing.entity.User;

public interface UserService {
	/**
	 * 查询用户
	 * 
	 * @return
	 */
	List<User> selectUser();
	
	/**
	 * 这个登录有些特殊：如果不是行政的权限，那么将无法进入到此页面。
	 * @param uName
	 * @param uPwd
	 * @return
	 */
	boolean login(String uName,String uPwd);
}
