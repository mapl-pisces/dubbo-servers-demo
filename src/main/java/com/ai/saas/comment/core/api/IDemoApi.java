package com.ai.saas.comment.core.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.saas.comment.core.model.dto.DemoTable;
@Path("/demoApi")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
public interface IDemoApi {
	@Path("/getDemoTable")
	@POST
	public String getDemoTable(String param);
	
		
	/**
	 * 缓存控制台数据查询
	 * @param request
	 * @return
	 */
	@Path("/getDemoTableExtra")
	@POST
	public String getDemoTableExtra(String param);
}
