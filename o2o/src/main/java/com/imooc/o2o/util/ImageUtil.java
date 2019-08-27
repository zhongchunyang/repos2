package com.imooc.o2o.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;

import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

public class ImageUtil {
	private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
	private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	private static final Random r = new Random();

	// spring框架自带文件处理对象 CommonsMultipartFile
	public static String generateThumbnail(InputStream thumbnailInputStream, String fileName, String targetAddr) {
		// 因为传过来的名字可能重复,就随机一个名称
		String realFileName = getRandomFileName();
		// 获取扩展名
		String extension = getFileExtension(fileName);
		// 因为新文件的目录可能不存在,先创建
		makeDirPath(targetAddr);
		String relativeAddr = targetAddr + realFileName + extension;
		File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
		try {
			Thumbnails.of(thumbnailInputStream).size(200, 200)
					.watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/watermar.jpg")), 0.25F)
					.outputQuality(0.8f).toFile(dest);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return relativeAddr;

	}

	/**
	 * 创建目标路径涉及到的目录 /home/work/xiangze/xxx.jpg 那么 home work xiangze这几个文件夹自动创建出来.
	 * 
	 * @param targetAddr
	 */
	private static void makeDirPath(String targetAddr) {
		// TODO Auto-generated method stub
		String realFileParentPath = PathUtil.getImgBasePath() + targetAddr;
		File dirPath = new File(realFileParentPath);
		if (!dirPath.exists()) {
			dirPath.mkdirs();
		}
	}

	/**
	 * 获取输入文件流的扩展名 xxx.jpg
	 * 
	 * @param thumbnail
	 * @return
	 */
	private static String getFileExtension(String fileName) {

		return fileName.substring(fileName.lastIndexOf("."));
	}

	/**
	 * 生成随机文件名,当前年月日小时分钟秒+五位随机数
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static String getRandomFileName() {
		// 获取5位随机
		int rannum = r.nextInt(89999) + 10000;
		String newTimeStr = sDateFormat.format(new Date());

		return newTimeStr + rannum;
	}

	public static void main(String[] args) throws IOException {
		// 根据当前线程逆推出源文件路径 basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();

		/**
		 * of(file)是要处理的图片 .size(xxx,xxx)压缩大小 .watermark(水印位置,水印图片,透明比例)添加水印
		 * .outputQuality(dpuble) 壓縮比例
		 */
		Thumbnails.of(new File("C:/Users/zhongchunyang/Pictures/Saved Pictures/1.jpg")).size(200, 200)
				.watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/watermar.jpg")), 0.25F)
				.outputQuality(0.8f).toFile("C:/Users/zhongchunyang/Pictures/Saved Pictures/2.jpg");
	}

	/**
	 * storePath是文件路径还是目录的路径 . 如果storepath是文件路径则删除该文件.
	 * 如果storepath是目录则删除该目录下的所有文件
	 * 
	 * @param storePath
	 */
	public static void deleteFileOrPath(String storePath) {
		File fileOrPath = new File(PathUtil.getImgBasePath() + storePath);
		if (fileOrPath.exists()) {
			if (fileOrPath.isDirectory()) {
				File[] files = fileOrPath.listFiles();
				for (int i = 0; i < files.length; i++) {
					files[i].delete();
				}
			}
			fileOrPath.delete();
		}

	}

}
