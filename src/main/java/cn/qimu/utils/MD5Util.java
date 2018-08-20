package cn.qimu.utils;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
	private static final String encryModel = "MD5";

	/**
	 * 32λmd5. 32位小写md5加密
	 *
	 * @param str
	 * @return
	 */
	public static String md5(String str) {
		return encrypt(encryModel, str);
	}

	public static String encrypt(String algorithm, String str) {
		try {
			MessageDigest md = MessageDigest.getInstance(algorithm);
			md.update(str.getBytes("UTF-8"));
			StringBuffer sb = new StringBuffer();
			byte[] bytes = md.digest();
			for (int i = 0; i < bytes.length; i++) {
				int b = bytes[i] & 0xFF;
				if (b < 0x10) {
					sb.append('0');
				}
				sb.append(Integer.toHexString(b));
			}
			return sb.toString();
		} catch (Exception e) {
			return "";
		}
	}

	//    加密密码
	public static String encrptyPassword(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest md5=MessageDigest.getInstance("MD5");
		BASE64Encoder base64Encoder=new BASE64Encoder();
		String result=base64Encoder.encode(md5.digest(password.getBytes("utf-8")));

		return result;
	}

	//    比对密码
	public static boolean checkPassword(String inputPwd,String dbPwd) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		String result=encrptyPassword(inputPwd);
		if (result.equals(dbPwd)){
			return true;
		}else {
			return false;
		}

	}
	public static void main(String[] args) {
		try {
			System.out.println(MD5Util.encrptyPassword("123456"));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}