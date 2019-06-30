package cn.kgc.tangcco.zhangqing.dao;

import java.util.List;

import cn.kgc.tangcco.zhangqing.entity.Role;


public interface RoleDao {
	/**
	 * 查询权限
	 * @return
	 */
	List<Role> selectRole();
}
