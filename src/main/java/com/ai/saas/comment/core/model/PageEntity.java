package com.ai.saas.comment.core.model;


import java.io.Serializable;

public class PageEntity implements Serializable {
	private static final long serialVersionUID = 4933771255759680537L;
	
	private int currentPage; // 请求页数
	
	private int PageSize; // 每页大小
	
	private int limitStart ;
	
	private int limitEnd;	

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
		countLimit();
	}

	public int getPageSize() {
		return PageSize;
	}

	public void setPageSize(int pageSize) {
		PageSize = pageSize;
		countLimit();
	}
	
	private void countLimit(){
		if(this.PageSize != 0 && this.currentPage != 0){
			 this.limitStart = this.PageSize  * (this.currentPage -1);
			 limitEnd = this.PageSize;
		}
	}

	public int getLimitStart() {
		return limitStart;
	}

	public int getLimitEnd() {
		return limitEnd;
	}
		
}

