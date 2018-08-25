package com.patin.srv.api.bot.vo;

/**
 * BotVO.java
 * 2018. 8. 10.
 * @author KIM, MinSeob
 */
public class KeyboardVO {
	private String type;
	private String[] buttons;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String[] getButtons() {
		return buttons;
	}
	public void setButtons(String[] buttons) {
		this.buttons = buttons;
	}
	
	
}
