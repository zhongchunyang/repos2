package com.imooc.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.ShopCategory;

public class ShopCategoryDaoTest extends BaseTest {
	@Autowired
	private ShopCategoryDao shopCategoryDao;

	@Test
	public void testQueryShopCategory() {

		List<ShopCategory> shopCategoryList1 = shopCategoryDao.queryShopCategory(new ShopCategory());
		assertEquals(2, shopCategoryList1.size());
		ShopCategory testCategory = new ShopCategory();
		ShopCategory parentCategory = new ShopCategory();
		parentCategory.setShopCategoryId(1L);
		testCategory.setParent(parentCategory);
		 shopCategoryList1 = shopCategoryDao.queryShopCategory(testCategory);
		assertEquals(1, shopCategoryList1.size());
		System.out.println(shopCategoryList1.get(0).getShopCategoryName());
	}
}
