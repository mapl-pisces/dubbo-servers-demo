package com.ai.saas.comment.core.model;

import java.io.Serializable;


public class RequestMessage<T> implements Serializable{	
	
	private static final long serialVersionUID = 1L;

	private T reqData;

	private PageEntity pageEntity;

	public T getReqData() {
		return reqData;
	}

	public void setReqData(T reqData) {
		this.reqData = reqData;
	}

	public PageEntity getPageEntity() {
		return pageEntity;
	}

	public void setPageEntity(PageEntity pageEntity) {
		this.pageEntity = pageEntity;
	}
}
