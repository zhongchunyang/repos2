package com.imooc.o2o.web.superadmin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imooc.o2o.entity.Area;
import com.imooc.o2o.service.AreaService;

import ch.qos.logback.classic.Logger;

@Controller
@RequestMapping("/superadmin")
public class AreaConteoller {
	 Logger logger=(Logger) LoggerFactory.getLogger(AreaConteoller.class);
	@Autowired
	private AreaService areaService;

	@RequestMapping(value = "/listarea")
	@ResponseBody
	private Map<String, Object> listArea() {
		logger.info("====start===");
		long startTime=System.currentTimeMillis();
		Map<String, Object> modelMap = new HashMap<>();
		List<Area> list = new ArrayList<>();
		try {
			list = areaService.getAreaList();
			modelMap.put("rows", list);
			modelMap.put("total", list.size());
		} catch (Exception e) {
			e.printStackTrace();
			modelMap.put("success", false);
			modelMap.put("errMsg", e.toString());
		}
		logger.error("test. error");
		long endTime=System.currentTimeMillis();
		logger.debug("costTime:[{}ms]",endTime-startTime);
		logger.info("====end====");
		return modelMap;

	}

}
