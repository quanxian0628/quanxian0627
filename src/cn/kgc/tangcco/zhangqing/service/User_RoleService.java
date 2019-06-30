package cn.kgc.tangcco.zhangqing.service;

import java.util.List;

public interface User_RoleService {

	/**
	 * 根据用户编号，查询用户权限Id
	 * 
	 * @param uId
	 * @return
	 */
	List<Integer> getRIdByUId(int uId);

	/**
	 * 判断uId在用户权限表中是否存在
	 * 
	 * @param uId
	 * @return
	 */
	boolean isUidByUR(int uId);
}
