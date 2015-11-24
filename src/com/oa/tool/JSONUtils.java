package com.oa.tool;

import com.alibaba.fastjson.JSONObject;

public class JSONUtils {
	/**
	 * 
	 * @author laudukang JSON工具类
	 * 
	 */
	
	public static String toJSONString(boolean success, boolean message) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", success);
		jsonObject.put("message", message);
		return jsonObject.toJSONString();
	}
	
	public static String toJSONString(boolean success, String message) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", success);
		jsonObject.put("message", message);
		return jsonObject.toJSONString();
	}

}
