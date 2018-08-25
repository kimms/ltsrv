package com.patin.srv.api.common.base;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;

import com.patin.srv.api.common.paging.PaginationVO;
import com.patin.srv.api.common.response.CommonResultDataVO;
import com.patin.srv.api.common.response.ResponsePaginationBodyVO;
import com.patin.srv.api.common.response.ResponseVO;

/**
 * BaseController.java
 * 
 * @author KIM, MinSeob
 */
public abstract class BaseController {
	@Autowired
    @Qualifier("messageSource")
    MessageSource messageSource;
	
	protected CommonResultDataVO getSuccessCode() {
		String msg = messageSource.getMessage("response.code.success", null, new Locale("ko"));
		CommonResultDataVO data = new CommonResultDataVO();
		data.setResult(msg);
		return data;
	}
	
	protected CommonResultDataVO getFailCode() {
		String msg = messageSource.getMessage("response.code.fail", null, new Locale("ko"));
		CommonResultDataVO data = new CommonResultDataVO();
		data.setResult(msg);
		return data;
	}
	
	/**
     * List 타입의 데이터로 구성된 responseData를 생성한다.
     * 
     * @param status
     *            HttpStatus response 상태 코드
     * @param resultDataList
     *            List<T> response할 List 타입의 data
     * @return ResponseVO<T>
     */
    protected <T> ResponseVO<T> makeResponseData(HttpStatus status, List<T> resultDataList) {
        ResponseVO<T> response = new ResponseVO<T>();

        response.getHeader().setStatus(status.value());
        response.getBody().setDocCnt(resultDataList.size());
        response.getBody().setDocs(resultDataList);

        return response;
    }
	
	/**
	 * 성공/실패 response
	 * @param status
	 * @param resultData(메시지String)
	 * @return
	 */
	protected <T> ResponseVO<T> makeResponseData(HttpStatus status, T resultData) {
        ResponseVO<T> response = new ResponseVO<T>();

        response.getHeader().setStatus(status.value());
        response.getBody().setDoc(resultData);
        
        return response;
    }
	
	/**
	 * 리스트 response(페이징)
	 * @param status
	 * @param resultDataList
	 * @param pageNum
	 * @param pageSize
	 * @param totalCount
	 * @return
	 */
	protected <T> ResponseVO<T> makeResponseData(HttpStatus status, List<T> resultDataList, int pageNum, int pageSize,
            int totalCount) {
        ResponseVO<T> response = this.makeResponseData(status, resultDataList);
        ResponsePaginationBodyVO<T> body = new ResponsePaginationBodyVO<T>();

        PaginationVO pagination = new PaginationVO();

        pagination.setTotalCount(totalCount);
        pagination.setPageSize(pageSize);
//        pagination.setPageViewSize(pageSize == 0 ? Integer.parseInt(defaultPageViewSize) : pageSize);
        pagination.setPageNum(pageNum);

        body.setPagination(pagination);
        body.setBody(response.getBody());

        response.setBody(body);

        return response;
    }
}