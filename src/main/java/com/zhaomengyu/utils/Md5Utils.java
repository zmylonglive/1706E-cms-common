/**
 * 
 */
package com.zhaomengyu.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author zhaomengyu
 *
 */
public class Md5Utils {

	/**
	 * ����
	 */
	private static String saltString="zhaomengyu";
	
	/**
	 * ��������м���
	 */
	public static String md5(String pwd) {
		//��������м���
		return DigestUtils.md5Hex(pwd + saltString);
		
	}
	
	public static String md5(String pwd,String salt) {
		//��������м���
		return DigestUtils.md5Hex( pwd + salt);
	}
}
