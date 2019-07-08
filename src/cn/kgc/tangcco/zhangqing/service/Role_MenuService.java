package cn.kgc.tangcco.zhangqing.service;

import java.util.List;

public interface Role_MenuService {
	/**
	 * 根据rId得到mId
	 * 
	 * @param rid
	 * @return
	 */
	List<Integer> getMidByRid(int rId);

	/**
	 * 在角色权限表，删除角色id及相关
	 * 
	 * @param rId
	 * @return
	 */
	boolean delRIdByRM(int rId);

	/**
	 * 添加角色权限
	 * 
	 * @param rId
	 * @param rList
	 * @return
	 */
	boolean addRidForRM(int rId, List<Integer> rList);
	
	/**
	 * 判断rId在RM表中是否存在
	 * @param rId
	 * @return
	 */
	boolean existsRidForRM(int rId);
}
