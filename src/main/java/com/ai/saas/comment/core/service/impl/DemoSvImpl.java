package com.ai.saas.comment.core.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.saas.comment.core.dao.extra.BaseDao;
import com.ai.saas.comment.core.dao.mapper.DemoTableMapper;
import com.ai.saas.comment.core.model.dto.DemoTable;
import com.ai.saas.comment.core.service.IDemoSv;
@Service
@Transactional 
public class DemoSvImpl implements IDemoSv {
	@Autowired
	private SqlSessionTemplate template;
	
	@Autowired
	private BaseDao baseDao;

	@Override
	public DemoTable getDemoTable(String param) {
		
		/* 1 日志*/
		/* 2 业务逻辑*/
		/* 2 校验逻辑*/
		
		DemoTableMapper sysConfigMapper =  template.getMapper(DemoTableMapper.class);
		
		int prikey = Integer.parseInt(param);
		
		DemoTable demoTable= sysConfigMapper.selectByPrimaryKey(prikey);
				
		return demoTable;
		
		
	}

	@Override
	public DemoTable getDemoTableExtra(String param) {		
		  Map map = new HashMap();		
		  map.put("demoId", param);
		 List<DemoTable> list = (List<DemoTable>) baseDao.query("demoTableExtra.getDemoTableExtra", map);
		 return list.get(0);
	}
	
	
	

	

}
