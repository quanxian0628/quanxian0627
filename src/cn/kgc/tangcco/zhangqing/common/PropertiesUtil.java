package cn.kgc.tangcco.zhangqing.common;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Properties;

public class PropertiesUtil {
	private static PropertiesUtil propertiesUtil;
	private static Properties prop = null;

	static {
		prop = new Properties();
		InputStream is = PropertiesUtil.class.getClassLoader().getResourceAsStream("applicationContext.properties");
		try {
			prop.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static PropertiesUtil getInstance() {
		if (propertiesUtil == null) {
			propertiesUtil = new PropertiesUtil();
		}
		return propertiesUtil;
	}

	public String getValue(String key) {
		return prop.getProperty(key);
	}

}
