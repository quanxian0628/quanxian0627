package cn.kgc.tangcco.zhangqing.service.impl;

import java.util.List;

import cn.kgc.tangcco.zhangqing.common.PropertiesFactory;
import cn.kgc.tangcco.zhangqing.dao.User_RoleDao;
import cn.kgc.tangcco.zhangqing.service.User_RoleService;

public class User_RoleServiceImpl implements User_RoleService {

	private User_RoleDao urd = (User_RoleDao) PropertiesFactory.getInstance("User_RoleDao");

	@Override
	public List<Integer> getRIdByUId(int uId) {
		return urd.getRIdByUId(uId);
	}

	@Override
	public boolean isUidByUR(int uId) {
		if (urd.isUidByUR(uId) > 0) {
			return true;// 存在
		}
		return false;// 不存在
	}

	@Override
	public boolean delUidByUR(int uId) {
		if (urd.delUidByUR(uId) > 0) {
			return true;//删除成功
		}
		return false;//删除失败
	}

	@Override
	public boolean addUR(int uId, List<Integer> rIdList) {
		if (urd.addUR(uId, rIdList) > 0) {
			return true;//添加成功
		}
		return false;//添加失败
	}

}
