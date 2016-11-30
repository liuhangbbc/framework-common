package com.raindrop.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;

/**
 * @ClassName: reflectiveEntityUtil
 * @Description: 通过request 反射数据到实体
 * @author liuhang liuhangbbc@sina.com
 * @date 2016年11月30日 下午3:27:04
 * 
 */
public class reflectiveEntityUtil {

	@SuppressWarnings("rawtypes")
	public static Object reflectiveEntity(Class clazz,
			HttpServletRequest request) {
		try {
			Object obj = CreatenewInstance(clazz);
			// 获取Class中所有已声明的属性集合
			Field[] fileds = clazz.getDeclaredFields();
			// 遍历属性结合
			for (Field f : fileds) {
				// 过滤被final、static修饰的成员变量
				if ((f.getModifiers() & Modifier.FINAL) > 0
						|| (f.getModifiers() & Modifier.STATIC) > 0) {
					continue;
				}
				// 取消所有私有变量的限制
				f.setAccessible(true);// 取消Field的访问检查
				// 获取属性的名字
				String fieldName = f.getName();
				// 根据属性的名字从request中获取value
				String paramVal = request.getParameter(fieldName);
				// 判断是否存在
				if (!StringUtils.isEmpty(paramVal)) {
					// 判断类型,如果是String
					if (f.getGenericType().toString()
							.equals("class java.lang.String")) {
						f.set(obj, paramVal);
					}
					// 判断类型,int型
					if (f.getGenericType().toString()
							.equals("class java.lang.Integer")
							|| f.getGenericType().toString().equals("int")) {
						f.set(obj, Integer.parseInt(paramVal));
					}
					// 判断类型,double型
					if (f.getGenericType().toString()
							.equals("class java.lang.Double")
							|| f.getGenericType().toString().equals("double")) {
						f.set(obj, Integer.parseInt(paramVal));
					}
					// 判断类型,long型
					if (f.getGenericType().toString()
							.equals("class java.lang.Long")
							|| f.getGenericType().toString().equals("long")) {
						f.set(obj, Long.parseLong(paramVal));
					}
					// 判断类型,short型
					if (f.getGenericType().toString()
							.equals("class java.lang.Short")
							|| f.getGenericType().toString().equals("short")) {
						f.set(obj, Short.parseShort(paramVal));
					}
					// 判断类型,boolean型
					if (f.getGenericType().toString()
							.equals("class java.lang.Boolean")
							|| f.getGenericType().toString().equals("boolean")) {
						f.set(obj, Boolean.parseBoolean(paramVal));
					}
					// 判断类型,date型
					if (f.getGenericType().toString()
							.equals("class java.util.Date")) {
						f.set(obj, parseDate(paramVal));
					}
				}

			}
			return obj;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static Date parseDate(String str) throws ParseException {
		// 将Date 类型str进行逆转化
		return new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US)
				.parse(str);
	}

	/**
	 * 实例化此类
	 */
	@SuppressWarnings("rawtypes")
	private static Object CreatenewInstance(Class clazz) {
		Object obj = null;
		if (clazz != null) {
			try {
				// 实例化
				obj = clazz.newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return obj;
	}
}
