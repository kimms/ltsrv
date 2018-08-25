package com.patin.srv.api.bot;

import java.util.List;

import com.patin.srv.api.bot.vo.ContinueHitHistoryVO;
import com.patin.srv.api.bot.vo.LottoHistoryVO;

/**
 * BotDao.java
 * 2018. 8. 12.
 * @author KIM, MinSeob
 */
public interface BotDao {
	/**
	 * 최신 회차 조회
	 * @return
	 */
	public LottoHistoryVO selectLastLottoHistory();
	
	/**
	 * 회차 내역 조회
	 * @param historyId
	 * @return
	 */
	public LottoHistoryVO selectLottoHistory(int historyId);
	
	/**
	 * 연속 적중된 번호 조회
	 * @return
	 */
	public List<ContinueHitHistoryVO> selectContinueHitHistory();
}
