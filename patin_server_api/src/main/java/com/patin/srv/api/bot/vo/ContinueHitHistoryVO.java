package com.patin.srv.api.bot.vo;

/**
 * LottoHistoryVO.java
 * 2018. 8. 12.
 * @author KIM, MinSeob
 */
public class ContinueHitHistoryVO {
	private int num;
	private int continueCount;
	private int totalCount;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getContinueCount() {
		return continueCount;
	}
	public void setContinueCount(int continueCount) {
		this.continueCount = continueCount;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
}
