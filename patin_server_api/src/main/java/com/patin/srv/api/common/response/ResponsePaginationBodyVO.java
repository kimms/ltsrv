package com.patin.srv.api.common.response;

import com.patin.srv.api.common.paging.PaginationVO;

/**
 * ResponsePaginationBodyVO.java
 * 
 * @author KIM, MinSeob
 */
public class ResponsePaginationBodyVO<T> extends ResponseBodyVO<T> {

    private PaginationVO pagination;

    public PaginationVO getPagination() {
        return pagination;
    }

    public void setPagination(PaginationVO pagination) {
        this.pagination = pagination;
    }

    public void setBody(ResponseBodyVO<T> body) {
        super.setDocCnt(body.getDocCnt());
        super.setDocs(body.getDocs());
    }
}
