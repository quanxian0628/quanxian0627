package cn.kgc.tangcco.zhangqing.common;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBUtilC3P0 {
	private static DataSource ds = null;

	static {
		ds = new ComboPooledDataSource();
	}

	public static DataSource getDataSource() {
		return ds;
	}
}
