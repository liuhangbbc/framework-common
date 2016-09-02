package com.raindrop.utils;

import java.util.UUID;

/**
 * 
 * @ClassName: RandomUtil
 * @Description: 随机生成工具
 * @author liuhang liuhangbbc@sina.com
 * @date 2016年7月25日 上午10:21:17
 */
public class RandomUtil {
	/**
	 * @Title: getRandomPrimaryKey
	 * @Description: 生成永不重复的uuid
	 * @return String 
	 * @throws
	 */
	public static String getRandomPrimaryKey() {
		String[] strs = UUID.randomUUID().toString().split("-");
		StringBuilder str = new StringBuilder("");
		for (int i = 0; i < strs.length; i++) {
			str.append(strs[i]);
		}
		return str.toString();
	}

	// test
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(getRandomPrimaryKey());
		}
	}
}
