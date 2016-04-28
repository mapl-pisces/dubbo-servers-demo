package com.ai.saas.comment.core.api.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.ai.saas.comment.core.api.IDemoApi;
import com.ai.saas.comment.core.service.IDemoSv;
import com.alibaba.dubbo.config.annotation.Service;
import com.google.gson.Gson;
@Service
public class DemoApiImpl implements IDemoApi {
	
	@Autowired
	private IDemoSv demoSv;
	
	@Override
	public String getDemoTable(String param) {
		//建议参数是json格式字符串
		//返回也是json格式字符串
		
		/* 1 校验参数*/
		/* 2 调用下层业务逻辑 */
		/* 3  日志 */
		Gson  gson = new Gson();		
		return gson.toJson(demoSv.getDemoTable(param));
	}

	@Override
	public String getDemoTableExtra(String param) {
		//建议参数是json格式字符串
		//返回也是json格式字符串
		
		Gson  gson = new Gson();
		return gson.toJson(demoSv.getDemoTableExtra(param));
	}

}
