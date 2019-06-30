package cn.kgc.tangcco.zhangqing.common;

import java.util.HashMap;
import java.util.Map;

public class PropertiesFactory {
	private static Map<String, Object> map = new HashMap<String, Object>();

	private PropertiesFactory() {

	}

	public static Object getInstance(String key) {
		if (map.containsKey(key)) {
			return map.get(key);
		}
		try {
			String value = PropertiesUtil.getInstance().getValue(key);
			Object obj = Class.forName(value).newInstance();
			map.put(key, obj);
			return obj;
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			System.out.println("温馨提示：反射失败！");
			e.printStackTrace();
		}

		return null;
	}
}
