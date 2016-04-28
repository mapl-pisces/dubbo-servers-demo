package com.ai.saas.comment.core.service;

import com.ai.saas.comment.core.model.dto.DemoTable;


/**
 * 
 * ClassName: IDemoSv <br/>
 * Reason: 业务逻辑层. <br/>
 * date: 2016年4月13日 下午3:52:13 <br/>
 *
 * @author mapl
 * @version
 */
public interface IDemoSv {

	DemoTable getDemoTable(String param);

	DemoTable getDemoTableExtra(String param);
	
}
