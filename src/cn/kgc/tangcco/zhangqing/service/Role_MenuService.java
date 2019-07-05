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
}
