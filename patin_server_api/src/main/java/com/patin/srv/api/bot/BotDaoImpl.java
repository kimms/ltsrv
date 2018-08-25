package com.patin.srv.api.bot;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.patin.srv.api.bot.vo.ContinueHitHistoryVO;
import com.patin.srv.api.bot.vo.LottoHistoryVO;
import com.patin.srv.api.common.base.BaseDao;

/**
 * BotDaoImpl.java
 * 2018. 8. 12.
 * @author KIM, MinSeob
 */
@Repository
public class BotDaoImpl extends BaseDao implements BotDao{
	
	@Override
	public LottoHistoryVO selectLastLottoHistory() {
		return super.getSqlSession().selectOne("lotto.selectLastLottoHistory");
	}
	
	@Override
	public LottoHistoryVO selectLottoHistory(int historyId) {
		LottoHistoryVO lottoHistoryVO = new LottoHistoryVO();
		lottoHistoryVO.setHistoryId(historyId);
		return super.getSqlSession().selectOne("lotto.selectLottoHistory", lottoHistoryVO);
	}
	
	@Override
	public List<ContinueHitHistoryVO> selectContinueHitHistory() {
		return super.getSqlSession().selectList("lotto.selectContinueHitHistory");
	}
}
