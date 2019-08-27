package com.imooc.o2o.util;

import javax.servlet.http.HttpServletRequest;

public class HttpServletRequstUtil {
	public static int getInt(HttpServletRequest quest, String key) {
		try {
			return Integer.decode(quest.getParameter(key));
		} catch (Exception e) {
			return -1;
		}
	}

	public static long getLong(HttpServletRequest quest, String key) {
		try {
			return Long.valueOf(quest.getParameter(key));
		} catch (Exception e) {
			return -1L;
		}
	}

	public static Double getDouble(HttpServletRequest quest, String key) {
		try {
			return Double.valueOf(quest.getParameter(key));
		} catch (Exception e) {
			return -1d;
		}
	}

	public static Boolean getBoolean(HttpServletRequest quest, String key) {
		try {
			return Boolean.valueOf(quest.getParameter(key));
		} catch (Exception e) {
			return false;
		}
	}

	public static String getString(HttpServletRequest quest, String key) {
		try {
			String result = quest.getParameter(key);
			if (result != null) {
				result = result.trim();
			}
			if ("".equals(result)) {
				result = null;
			}
			return result;
		} catch (Exception e) {
			return null;
		}

	}
}
