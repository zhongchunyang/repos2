package com.imooc.o2o.dao;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.Area;
import com.imooc.o2o.entity.PersionInfo;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.entity.ShopCategory;

public class ShopDaoTest extends BaseTest {
	@Autowired
	private ShopDao shopDao;

	@Test
	@Ignore
	public void testQueryShopListAndCount() {
		Shop shopCondition = new Shop();
		PersionInfo owner = new PersionInfo();
		owner.setUserId(1L);
		shopCondition.setOwner(owner);
		List<Shop> shopList = shopDao.queryShopList(shopCondition, 0, 2);
		int count = shopDao.queryShopCount(shopCondition);
		System.out.println(shopList.size() + "----------" + count);
	}

	/**
	 * 
	 */
	@Test
	@Ignore
	public void testInsertShop() {
		Shop shop = new Shop();
		PersionInfo info = new PersionInfo();
		Area area = new Area();
		ShopCategory category = new ShopCategory();

		info.setUserId(1L);
		area.setAreaId(2);
		category.setShopCategoryId(1L);

		shop.setOwner(info);
		shop.setArea(area);
		shop.setShopCategory(category);

		shop.setShopName("测试店铺");
		shop.setShopDesc("测试信息");
		shop.setShopAddr("测试地址");
		shop.setPhone("测试电话");
		shop.setShopImg("测试图片");
		shop.setCreateTime(new Date());
		shop.setEnableStatus(1);
		shop.setAdvice("审核中");

		int i = shopDao.insertShop(shop);
		System.out.println(i);
	}

	/**
	 * 测试更新店铺
	 */
	@Test
	@Ignore
	public void testUpdateShop() {
		Shop shop = new Shop();
		shop.setShopId(1L);
		PersionInfo info = new PersionInfo();
		Area area = new Area();
		ShopCategory category = new ShopCategory();

		info.setUserId(1L);
		area.setAreaId(2);
		category.setShopCategoryId(1L);

		shop.setOwner(info);
		shop.setArea(area);
		shop.setShopCategory(category);

		shop.setShopName("测试店铺");
		shop.setShopDesc("更新ok");
		shop.setShopAddr("更新地址");
		shop.setPhone("测试电话");
		shop.setShopImg("测试图片");
		shop.setLastEditTime(new Date());
		shop.setEnableStatus(1);
		shop.setAdvice("审核中");

		int i = shopDao.updateShop(shop);
		assertEquals(1, i);
	}

	@Test
	@Ignore
	public void testQueryByShopId() {
		Shop shop = shopDao.queryByShopId(1);
		System.out.println("areaID" + shop.getArea().getAreaId());
		System.out.println("areaID" + shop.getArea().getAreaName());
	}
}
