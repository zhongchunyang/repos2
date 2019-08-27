package com.imooc.o2o.service;

import com.imooc.o2o.dto.ProductExecution;
import com.imooc.o2o.exceptions.ProductOperationException;

public interface ProductService {

	ProductExecution addProduct() throws ProductOperationException;
}
