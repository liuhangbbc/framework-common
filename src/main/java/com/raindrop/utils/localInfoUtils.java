package com.raindrop.utils;

/**
 * @ClassName: localInfoUtils
 * @Description: 获取本地代码信息
 * @author liuhang liuhangbbc@sina.com
 * @date 2016年11月28日 上午11:39:46
 * 
 */
public class localInfoUtils {

	public static int getCurrentLine() {
		StackTraceElement ste = new Throwable().getStackTrace()[1];
		return ste.getLineNumber();
	}

	public static void main(String[] args) {
		System.out.println("current line is " + getCurrentLine());
	}
}
