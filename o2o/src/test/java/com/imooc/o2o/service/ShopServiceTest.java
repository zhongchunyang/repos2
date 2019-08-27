package com.imooc.o2o.service;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.dto.ShopExecution;
import com.imooc.o2o.entity.Area;
import com.imooc.o2o.entity.PersionInfo;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.entity.ShopCategory;
import com.imooc.o2o.enums.ShopStateEnum;
import com.imooc.o2o.exceptions.ShopException;

public class ShopServiceTest extends BaseTest {
	@Autowired
	private ShopService shopService;

	@Test
	public void testModifyShop() throws FileNotFoundException, ShopException {
		Shop shop = new Shop();
		shop.setShopId(1L);
		shop.setShopName("修改后的店铺名称 ");
		File shopImg = new File("C:/Users/zhongchunyang/Pictures/Saved Pictures/1.jpg");
		InputStream is = new FileInputStream(shopImg);

		ShopExecution shopExecution = shopService.modifyShop(shop, is, "dabaibai.jpg");
		System.out.println("新的图片地址" + shopExecution.getShop().getShopImg());
	} 

	@Test
	@Ignore
	public void TestAddShop() throws FileNotFoundException {
		Shop shop = new Shop();
		PersionInfo owner = new PersionInfo();
		Area area = new Area();
		ShopCategory category = new ShopCategory();

		owner.setUserId(1L);
		area.setAreaId(2);
		category.setShopCategoryId(1L);

		shop.setOwner(owner);
		shop.setArea(area);
		shop.setShopCategory(category);

		shop.setShopName("测试店铺3");
		shop.setShopDesc("测试信息3");
		shop.setShopAddr("测试地址3");
		shop.setPhone("测试电话3");
		shop.setCreateTime(new Date());
		shop.setEnableStatus(ShopStateEnum.CHECK.getState());
		shop.setAdvice("审核中");

		File shopImg = new File("C:/Users/zhongchunyang/Pictures/Saved Pictures/1.jpg");
		InputStream is = new FileInputStream(shopImg);
		ShopExecution se = shopService.addShop(shop, is, shopImg.getName());
		assertEquals(ShopStateEnum.CHECK.getState(), se.getState());

	}
}
