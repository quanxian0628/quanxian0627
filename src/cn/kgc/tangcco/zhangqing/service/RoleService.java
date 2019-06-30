package cn.kgc.tangcco.zhangqing.service;

import java.util.List;

import cn.kgc.tangcco.zhangqing.entity.Role;

public interface RoleService {
	/**
	 * 查询权限
	 * 
	 * @return
	 */
	List<Role> selectRole();
}
