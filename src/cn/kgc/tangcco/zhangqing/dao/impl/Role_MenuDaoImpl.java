package cn.kgc.tangcco.zhangqing.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

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

	@Override
	public int delRIdByRM(int rId) {
		String sql = "delete from role_menu where rid=?";
		try {
			return qr.update(sql, rId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int addRidForRM(int rId, List<Integer> rList) {
		for (int i = 0; i < rList.size(); i++) {
			String sql = "insert role_menu(rid,mid) values(?,?);";
			try {
				qr.update(sql, rId, rList.get(i));
			} catch (SQLException e) {
				e.printStackTrace();
				return 0;// 只要出了bug，就返回0
			}
		}
		return 1;// 否则就是没bug，返回1
	}

	@Override
	public int existsRidForRM(int rId) {
		String sql = "select count(*) from role_menu where rid=?";
		try {
			return qr.query(sql, new ScalarHandler<Long>(), rId).intValue();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
