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

	@Override
	public boolean delRIdByRM(int rId) {
		if (rmd.delRIdByRM(rId) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean addRidForRM(int rId, List<Integer> rList) {
		if (rmd.addRidForRM(rId, rList) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean existsRidForRM(int rId) {
		if (rmd.existsRidForRM(rId) > 0) {
			return true;// 存在
		}
		return false;// 不存在
	}

}
