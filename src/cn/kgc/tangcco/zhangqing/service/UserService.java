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
}
