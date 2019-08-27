package com.imooc.o2o.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.ShopCategory;

public class ShopCategoryServiceTest extends BaseTest {
	@Autowired
	private ShopCategoryService categoryService;

	@Test
	public void testShopCategoryService() {
		List<ShopCategory> list = categoryService.getShopCategoryList(new ShopCategory());
		System.out.println(list.get(0).getShopCategoryName());
	}

}
