package com.patin.srv.api.bot.vo;

/**
 * BotVO.java
 * 2018. 8. 10.
 * @author KIM, MinSeob
 */
public class RequestVO {
	private String user_key;
	private String type;
	private String content;
	
	public String getUser_key() {
		return user_key;
	}
	public void setUser_key(String user_key) {
		this.user_key = user_key;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
}
