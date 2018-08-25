package com.patin.srv.api.bot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.patin.srv.api.bot.vo.RequestVO;
import com.patin.srv.api.common.base.BaseController;

/**
 * BotController.java
 * 2018. 8. 10.
 * @author KIM, MinSeob
 */
@RestController
public class BotController extends BaseController{
	
	@Autowired
	private BotService botService;

	@RequestMapping(value = "/keyboard", method = RequestMethod.GET, produces = "application/json")
	public String getKeyboard() {
		return botService.getKeyboard();
	}

	@RequestMapping(value = "/message", method = RequestMethod.POST, produces = "application/json; charset=utf8", consumes = "application/json")
	public String getMessage(@RequestBody RequestVO requestVO) {
		return botService.getMessage(requestVO);
	}


}
