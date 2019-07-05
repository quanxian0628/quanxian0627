package cn.kgc.tangcco.zhangqing.service.impl;

import java.util.List;

import cn.kgc.tangcco.zhangqing.common.PropertiesFactory;
import cn.kgc.tangcco.zhangqing.dao.Role_MenuDao;
import cn.kgc.tangcco.zhangqing.service.Role_MenuService;

public class Role_MenuServiceImpl implements Role_MenuService {

	private Role_MenuDao rmd = (Role_MenuDao) PropertiesFactory.getInstance("Role_MenuDao");

	@Override
	public List<Integer> getMidByRid(int rId) {
		return rmd.getMidByRid(rId);
	}

}
