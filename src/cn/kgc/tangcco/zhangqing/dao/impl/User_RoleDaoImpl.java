package cn.kgc.tangcco.zhangqing.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.kgc.tangcco.zhangqing.common.DBUtilC3P0;
import cn.kgc.tangcco.zhangqing.dao.User_RoleDao;

public class User_RoleDaoImpl implements User_RoleDao {

	QueryRunner qr = new QueryRunner(DBUtilC3P0.getDataSource());

	@Override
	public List<Integer> getRIdByUId(int uId) {
		// ColumnListHandler用于返回一个列的信息，存储集合中。
		String sql = "select r.rid as 'rId' from user_role ur,`user` u,role r where u.uid=? and u.uId=ur.uId and r.rId=ur.rId";
		try {
			return qr.query(sql, new ColumnListHandler<Integer>("rId"), uId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int isUidByUR(int uId) {
		String sql = "select count(*) from user_role where uid=?";
		try {
			return qr.query(sql, new ScalarHandler<Long>(), uId).intValue();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;// 不存在
	}

}
