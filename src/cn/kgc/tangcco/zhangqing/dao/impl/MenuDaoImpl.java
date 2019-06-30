package cn.kgc.tangcco.zhangqing.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.kgc.tangcco.zhangqing.common.DBUtilC3P0;
import cn.kgc.tangcco.zhangqing.dao.MenuDao;
import cn.kgc.tangcco.zhangqing.entity.Menu;

public class MenuDaoImpl implements MenuDao {

	QueryRunner qr = new QueryRunner(DBUtilC3P0.getDataSource());

	@Override
	public List<Menu> selectMenu() {
		String sql = "select * from menu";
		try {
			return qr.query(sql, new BeanListHandler<Menu>(Menu.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
