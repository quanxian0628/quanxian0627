package cn.kgc.tangcco.zhangqing.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.kgc.tangcco.zhangqing.common.DBUtilC3P0;
import cn.kgc.tangcco.zhangqing.dao.UserDao;
import cn.kgc.tangcco.zhangqing.entity.User;

public class UserDaoImpl implements UserDao {

	QueryRunner qr = new QueryRunner(DBUtilC3P0.getDataSource());

	@Override
	public List<User> selectUser() {
		String sql = "select * from user";
		try {
			return qr.query(sql, new BeanListHandler<User>(User.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
