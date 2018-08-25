package com.patin.srv.api.common.paging;

/**
 * PaginationVO.java
 * 
 * @author KIM, MinSeob
 */
public class PaginationVO{

    private int totalCount;
    private int pageSize;
    private int pageNum;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

//    @JsonIgnore
//    public int getPageOffSet() {
//        return (this.currentPageNum - 1) * this.pageViewSize;
//    }
}
