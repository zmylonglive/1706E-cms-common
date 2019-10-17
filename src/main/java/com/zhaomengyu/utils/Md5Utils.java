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
	 * 加严
	 */
	private static String saltString="zhaomengyu";
	
	/**
	 * 对密码进行加密
	 */
	public static String md5(String pwd) {
		//对密码进行加密
		return DigestUtils.md5Hex(pwd + saltString);
		
	}
	
	public static String md5(String pwd,String salt) {
		//对密码进行加密
		return DigestUtils.md5Hex( pwd + salt);
	}
}
