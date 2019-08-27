package com.imooc.o2o.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.imooc.o2o.entity.Product;

public interface ProductDao {
	/**
	 * 查询上坪列表并分页,可以输入的条件:商品名称(模糊),商品状态,店铺id,商品类别.
	 * 
	 * @param productCondition
	 * @param beginIndex
	 * @param pageSize
	 * @return
	 */
	List<Product> queryProductList(@Param("productCondition") Product productCondition,
			@Param("beginIndex") int beginIndex, @Param("pageSize") int pageSize);

	/**
	 * 按商品id,查询商品
	 * 
	 * @param productId
	 * @return
	 */
	Product queryProductByProductId(long productId);

	/**
	 * 插入商品
	 * 
	 * @param product
	 * @return
	 */
	int insertProduct(Product product);

	/**
	 * 查询商品总数
	 * 
	 * @param product
	 * @return
	 */
	int queryProductCount(Product product);

	/**
	 * 更新商品
	 * 
	 * @param product
	 * @return
	 */
	int updateProduct(Product product);

	int updateProductCategoryToNull(long i);

	int deleteProduct(long productId, long i);

}
