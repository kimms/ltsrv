package com.patin.srv.api.bot.vo;

/**
 * BotVO.java
 * 2018. 8. 10.
 * @author KIM, MinSeob
 */
public class ResponseVO {
	private MessageVO message;
	private KeyboardVO keyBoard;

	public MessageVO getMessage() {
		return message;
	}

	public void setMessage(MessageVO message) {
		this.message = message;
	}

	public KeyboardVO getKeyBoard() {
		return keyBoard;
	}

	public void setKeyBoard(KeyboardVO keyBoard) {
		this.keyBoard = keyBoard;
	}
	
}
