package com.cmz.myweb.util;

public class XSSUtil {
	
	public static String filter(String orign){
		return orign.replaceAll("<", "&lt;")
				.replaceAll(">", "&gt;")
				.replaceAll("'", "&apos;")
				.replaceAll("\"", "&quot;");
	}
}
