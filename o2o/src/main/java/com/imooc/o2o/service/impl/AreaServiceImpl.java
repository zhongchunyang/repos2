package com.imooc.o2o.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imooc.o2o.service.AreaService;
import com.imooc.o2o.dao.AreaDao;
import com.imooc.o2o.entity.Area;
@Service
public class AreaServiceImpl implements com.imooc.o2o.service.AreaService {
	@Autowired
	 private AreaDao dao;
	
	@Override
	public List<Area> getAreaList() {
		// TODO Auto-generated method stub
		return dao.queryArea();
	}

}
