package cn.kgc.tangcco.zhangqing.dao;

import java.util.List;

import cn.kgc.tangcco.zhangqing.entity.User;

public interface UserDao {
	/**
	 *  查询用户
	 * @return
	 */
	List<User> selectUser();
}
