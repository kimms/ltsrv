package com.patin.srv.api.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.patin.srv.api.common.base.BaseController;
import com.patin.srv.api.common.response.CommonResultDataVO;
import com.patin.srv.api.common.response.ResponseVO;
import com.patin.srv.api.common.type.SampleType;
import com.patin.srv.api.test.vo.TestVO;

/**
 * TestController.java
 * 
 * @author KIM, MinSeob
 */
@RestController
public class TestController extends BaseController{
	
	@RequestMapping(value = "/getboolean", method = RequestMethod.GET, produces = "application/json")
	public ResponseVO<CommonResultDataVO> getBoolean() {
		boolean result = true; 
		
		return super.makeResponseData(HttpStatus.OK, result ? super.getSuccessCode() : super.getFailCode());
	}
	
	@RequestMapping(value = "/getlist", method = RequestMethod.GET, produces = "application/json")
	public ResponseVO<TestVO> getList(
//			@ModelAttribute WasteBasketQueryVO wasteBasketQueryVO,
            @RequestParam(defaultValue = "1", required = false) int pageNum,
            @RequestParam(defaultValue = "0", required = false) int pageSize) {
		int totalCount = 0;
		
		List<TestVO> list = new ArrayList<TestVO>();
		TestVO t1 = new TestVO();
		t1.setName("abc");
		TestVO t2 = new TestVO();
		t2.setName("333");
		list.add(t1);
		list.add(t2);
		totalCount = list.size();
		
		return super.makeResponseData(HttpStatus.OK, list, pageNum, pageSize, totalCount);
	}
	
	@Test
	public void abab() {
		System.out.println(SampleType.TYPE_A.getType());
		System.out.println(SampleType.TYPE_A.getOption());
	}
	
}