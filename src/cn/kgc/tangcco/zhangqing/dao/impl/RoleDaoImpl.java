package cn.kgc.tangcco.zhangqing.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.kgc.tangcco.zhangqing.common.DBUtilC3P0;
import cn.kgc.tangcco.zhangqing.dao.RoleDao;
import cn.kgc.tangcco.zhangqing.entity.Role;

public class RoleDaoImpl implements RoleDao {

	QueryRunner qr = new QueryRunner(DBUtilC3P0.getDataSource());

	@Override
	public List<Role> selectRole() {
		String sql = "select * from `role`;";
		try {
			return qr.query(sql, new BeanListHandler<Role>(Role.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
