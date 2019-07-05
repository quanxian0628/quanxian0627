package cn.kgc.tangcco.zhangqing.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

import cn.kgc.tangcco.zhangqing.common.DBUtilC3P0;
import cn.kgc.tangcco.zhangqing.dao.Role_MenuDao;

public class Role_MenuDaoImpl implements Role_MenuDao {

	QueryRunner qr = new QueryRunner(DBUtilC3P0.getDataSource());

	@Override
	public List<Integer> getMidByRid(int rId) {
		String sql = "select mId from role_menu where rid=?";
		try {
			return qr.query(sql, new ColumnListHandler<Integer>("mId"), rId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
