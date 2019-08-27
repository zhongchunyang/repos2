package com.imooc.o2o.util;

public class PathUtil {
	private static String seperator = System.getProperty("file.separator");
	//根路径
	public static String getImgBasePath() {
		String os = System.getProperty("os.name");
		String basePath = "";
		if (os.toLowerCase().startsWith("win")) {
			basePath = "D:/projectdev/image";
		} else {
			basePath = "/home/xiangzi/image";
		}
		basePath = basePath.replace("/", seperator);
		return basePath;
	}
	//店铺图片存储的相对路径
	public static String getShopImgagePath(long shopId) {
		String imagePath = "upload/itme/shop/" + shopId + "/";
		return imagePath.replace("/", seperator);
	}
}
