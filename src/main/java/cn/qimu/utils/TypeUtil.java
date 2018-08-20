package cn.qimu.utils;

public class TypeUtil {
	/**
	 * 转换Int
	 * @param obj
	 * @return
	 */
	public static int toInt(Object obj) {
		try {
			return Integer.parseInt(obj.toString());
		} catch (Exception a) {
			return 0;
		}
	}
	/**
	 * 转换Long
	 * @param obj
	 * @return
	 */
	public static long toLong(Object obj) {
		try {
			return Long.parseLong(obj.toString());
		} catch (Exception a) {
			return 0;
		}
	}
	/**
	 * 转换Double
	 * @param obj
	 * @return
	 */
	public static Double toDouble(Object obj) {
		try {
			return Double.parseDouble(obj.toString());
		} catch (Exception a) {
			return 0.0;
		}
	}
	/**
	 * 转换Float
	 * @param obj
	 * @return
	 */
	public static Float toFloat(Object obj) {
		try {
			return Float.parseFloat(obj.toString());
		} catch (Exception a) {
			return (float) 0;
		}
	}

	/**
	 * 转换String
	 * @param obj
	 * @return
	 */
	public static String toString(Object obj) {
		if (obj == null) {
			return "";
		} else {
			return obj.toString().trim();
		}
	}

	/**
	 * 判断是否为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return str == null || str.length() == 0;
	}

}
