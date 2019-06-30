package cn.kgc.tangcco.zhangqing.service.impl;

import java.util.List;

import cn.kgc.tangcco.zhangqing.common.PropertiesFactory;
import cn.kgc.tangcco.zhangqing.dao.RoleDao;
import cn.kgc.tangcco.zhangqing.entity.Role;
import cn.kgc.tangcco.zhangqing.service.RoleService;

public class RoleServiceImpl implements RoleService {

	private RoleDao rd = (RoleDao) PropertiesFactory.getInstance("RoleDao");

	@Override
	public List<Role> selectRole() {
		return rd.selectRole();
	}

}
