package com.ai.saas.comment.core.model;

import java.io.Serializable;


public class ResponseMessage<T> implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private  String resResult;
	
	private String resMsg;
	
	private T resData;

	public String getResResult() {
		return resResult;
	}

	public void setResResult(String resResult) {
		this.resResult = resResult;
	}

	public String getResMsg() {
		return resMsg;
	}

	public void setResMsg(String resMsg) {
		this.resMsg = resMsg;
	}

	public T getResData() {
		return resData;
	}

	public void setResData(T resData) {
		this.resData = resData;
	}

	
	
	

}
