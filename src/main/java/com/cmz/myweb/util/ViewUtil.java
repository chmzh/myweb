package com.cmz.myweb.util;

public class ViewUtil {
	public static String getAdminView(String view){
		return "admin/"+view;
	}
	
	public static String getFrontView(String view){
		return "front/"+view;
	}
}
