package com.patin.srv.api.bot;

import com.patin.srv.api.bot.vo.RequestVO;

/**
 * BotService.java
 * 2018. 8. 12.
 * @author KIM, MinSeob
 */
public interface BotService {
	public String getKeyboard();
	
	public String getMessage(RequestVO requestVO);
}
