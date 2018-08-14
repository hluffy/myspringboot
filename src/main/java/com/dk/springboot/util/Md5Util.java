package com.dk.springboot.util;

import java.security.MessageDigest;
import java.util.Base64;

import org.junit.Test;

public class Md5Util {
	@Test
	public void testMd5(){
		String str = "admin";
		System.out.println(Md5Util.md5String(str));
	}
	
	
	public static String md5String(String str){
		MessageDigest md5;
		try {
			md5 = MessageDigest.getInstance("MD5");
			Base64.Encoder base64 = Base64.getEncoder();
			return base64.encodeToString(md5.digest(str.getBytes("utf-8")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

}
