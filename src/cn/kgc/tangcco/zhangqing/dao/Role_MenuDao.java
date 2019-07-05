package cn.kgc.tangcco.zhangqing.dao;

import java.util.List;

public interface Role_MenuDao {
	/**
	 * 根据rId得到mId
	 * 
	 * @param rid
	 * @return
	 */
	List<Integer> getMidByRid(int rId);
}
