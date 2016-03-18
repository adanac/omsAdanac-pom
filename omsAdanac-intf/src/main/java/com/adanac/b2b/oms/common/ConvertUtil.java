package com.adanac.b2b.oms.common;

import org.junit.Test;

public class ConvertUtil {
	public final static int NUMBER_LENGTH = 1000000;

	public static String String2Int(Integer i) {
		return Integer.toString(i);
	}

	/**
	 * 三种方法效率排序为：Integer.toString(int i)   >   String.valueOf(int i)   >  i+"";
	 */
	@Test
	public void test1() {
		int[] intArr = new int[NUMBER_LENGTH];
		String[] strArr1 = new String[NUMBER_LENGTH];// 为了公平分别定义三个数组

		String[] strArr2 = new String[NUMBER_LENGTH];
		String[] strArr3 = new String[NUMBER_LENGTH];
		// 赋值
		Long t1 = System.currentTimeMillis();
		for (int i = 0; i < NUMBER_LENGTH; i++) {
			intArr[i] = i + 1;
		}
		Long t2 = System.currentTimeMillis();
		for (int i = 0; i < NUMBER_LENGTH; i++) {
			strArr1[i] = String.valueOf(intArr[i]);
		}
		Long t3 = System.currentTimeMillis();
		for (int i = 0; i < NUMBER_LENGTH; i++) {
			strArr2[i] = Integer.toString(intArr[i]);
		}
		Long t4 = System.currentTimeMillis();
		for (int i = 0; i < NUMBER_LENGTH; i++) {
			strArr3[i] = intArr[i] + "";
		}
		Long t5 = System.currentTimeMillis();
		System.out.println("t1 = " + t1);
		System.out.println("t2 = " + t2);
		System.out.println("t3 = " + t3);
		System.out.println("t4 = " + t4);
		System.out.println("t5 = " + t5);
		System.out.println("赋值：" + (t2 - t1));
		System.out.println("String.valueOf(i)：" + (t3 - t2));
		System.out.println("Integer.toString(i)：" + (t4 - t3));
		System.out.println("i+\"\"：" + (t5 - t4));
	}

}
