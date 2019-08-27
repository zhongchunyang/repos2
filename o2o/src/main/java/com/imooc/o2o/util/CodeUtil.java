package com.imooc.o2o.util;

import javax.servlet.http.HttpServletRequest;

public class CodeUtil {
	public static boolean checkVerifyCode(HttpServletRequest request) {
		String verifyCodeExpected = (String) request.getSession()
				.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		String cerifyCodeActual = HttpServletRequstUtil.getString(request, "verifyCodeExpected");
		if (cerifyCodeActual == null || !cerifyCodeActual.equals(verifyCodeExpected)) {
			return false;
		}
		return true;
	}
}
