package com.patin.srv.api.bot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.patin.srv.api.bot.vo.ContinueHitHistoryVO;
import com.patin.srv.api.bot.vo.KeyboardVO;
import com.patin.srv.api.bot.vo.LottoHistoryVO;
import com.patin.srv.api.bot.vo.LottoVO;
import com.patin.srv.api.bot.vo.MessageVO;
import com.patin.srv.api.bot.vo.RequestVO;
import com.patin.srv.api.bot.vo.ResponseVO;

/**
 * BotServiceImpl.java
 * 2018. 8. 12.
 * @author KIM, MinSeob
 */
@Service
public class BotServiceImpl implements BotService{
	
	@Autowired
	private BotDao botDao;
	
	@Override
	public String getKeyboard() {
		Gson gson = new Gson();
		KeyboardVO vo = new KeyboardVO();
		vo.setType("text");

		return gson.toJson(vo); 
	}
	
	@Override
	public String getMessage(RequestVO requestVO) {
		Gson gson = new Gson();
		MessageVO messageVO = new  MessageVO();
		KeyboardVO keyboardVO = new KeyboardVO();
		
		System.out.println(gson.toJson(requestVO));

		String inputMsg = requestVO.getContent();
		
		System.out.println("사용자 입력 : "+inputMsg);
		/* 검증 */
		if(this.getValidation(inputMsg)) {
			String msg = inputMsg.split("@")[1];
			
			String[] msgDivision = msg.split(",");
			
			try {
				messageVO.setText(getMessage(msgDivision[0], msgDivision.length>1 ? msgDivision[1] : null ));
			} catch (Exception e) {
				messageVO.setText("정확한 값을 입력해주세요");
			}
			
		}else {
			messageVO.setText("Hello");
		}
		
		ResponseVO responseVO = new ResponseVO();
		responseVO.setKeyBoard(keyboardVO);
		responseVO.setMessage(messageVO);
		return gson.toJson(responseVO);
	}
	
	/**
	 * 명령어 검증
	 * @param inputText
	 * @return
	 */
	private boolean getValidation(String inputText) {
        boolean result = false;
        String[] format = inputText.split("@");
        if(format.length != 2) {
            return false;
        }
        
        /* 인증번호 체크 */
        String[] authNum = {"1976","2942"};
        for(int i = 0; i < authNum.length; i++) {
            if(format[0].equals(authNum[i])) {
                result = true;
                break;
            }
        }
        
        /* 메시지 포맷 체크 */
        String[] msgFormat = format[1].split(",");
        if(msgFormat.length > 2) {
        	result = false;
        }
        
        return result;
    }
	
	private String getMessage(String msg, String key) throws Exception{
		String result;
		if(msg.equals("?")) {
			
			result = getHelpMsg();
			
		}else if(msg.equals("최신조회")) {
			
			result = getLastLottoHistory();
			
		}else if(msg.equals("회차조회") && key != null) {
			
			result = getLottoHistory(Integer.parseInt(key));
			
		}else if(msg.equals("추천번호") && key != null) {
			
			result = getRecommendNumList(Integer.parseInt(key));
			
		}else if(msg.equals("연속조회")) {
			
			result = getContinueHitHistory();
		}else {
			result = "Hello";
		}
		return result;
	}
	
	private String getHelpMsg() {
		String result = "메시지 형식 id@msg,0\n"
				+ "예) 1234@?\n"
				+ "    1234@추천번호,5\n\n"
				+ "1. ?\n"
	  			+ " - 사용 가능한 명령어를 조회한다.\n"
				+ "2. 최신조회\n"
				+ " - 지난 회차 정보를 조회한다.\n"
				+ "3. 회차조회,0\n"
				+ " - 회차 적중 번호를 조회한다.\n"
				+ "3. 추천번호,0\n"
				+ " - 입력한 숫자만큼의 번호 조합을 조회한다.\n"
				+ "   * 최대 50\n"
				+ "4. 연속조회\n"
				+ " - 번호별 연속 적중 기록을 조회한다.";
		return result;
	}
	
	private String getLastLottoHistory() {
		String result;
		
		LottoHistoryVO lottoHistoryVO = botDao.selectLastLottoHistory();
		if(lottoHistoryVO != null) {
			result = "[ " + lottoHistoryVO.getHistoryId() +" 회차 당첨번호 ]\n"
					+ "[ " +lottoHistoryVO.getNum1() +" ] "
					+ "[ " +lottoHistoryVO.getNum2() +" ] "
					+ "[ " +lottoHistoryVO.getNum3() +" ] "
					+ "[ " +lottoHistoryVO.getNum4() +" ] "
					+ "[ " +lottoHistoryVO.getNum5() +" ]"
					+ "[ " +lottoHistoryVO.getNum6() +" ]\n"
					+ "보너스 번호 [ " +lottoHistoryVO.getbNum() + " ]";
		}else {
			result = "오류 발생";
		}
		
		return result;
	}
	
	private String getLottoHistory(int historyId) {
		String result;
		
		LottoHistoryVO lottoHistoryVO = botDao.selectLottoHistory(historyId);
		if(lottoHistoryVO != null) {
			result = "[ " + lottoHistoryVO.getHistoryId() +" 회차 당첨번호 ]\n"
					+ "[ " +lottoHistoryVO.getNum1() +" ] "
					+ "[ " +lottoHistoryVO.getNum2() +" ] "
					+ "[ " +lottoHistoryVO.getNum3() +" ] "
					+ "[ " +lottoHistoryVO.getNum4() +" ] "
					+ "[ " +lottoHistoryVO.getNum5() +" ]"
					+ "[ " +lottoHistoryVO.getNum6() +" ]\n"
					+ "보너스 번호 [ " +lottoHistoryVO.getbNum() + " ]";
		}else {
			result = "오류 발생";
		}
		
		return result;
	}
	
	private String getContinueHitHistory() {
		String result;
		
		List<ContinueHitHistoryVO> list = botDao.selectContinueHitHistory();
		if(list.size() > 0) {
			result = "[ 연속 적중 된 번호 조회 ]\n";
			for (int i = 0; i < list.size(); i++) {
				ContinueHitHistoryVO vo = list.get(i);
				String num = String.format("%02d", vo.getNum());
				
				if(i > 0) {
					result += "\n";
				}
				result += "["+num+"]번 "+ vo.getContinueCount()+"회차 연속 / 총"+vo.getTotalCount()+"회";
			}
		}else {
			result = "오류 발생";
		}
		return result;
	}
	
	private String getRecommendNumList(int count) {
		ArrayList<LottoVO> list = createLottoNum(count);
		String result;
		if(list.size() > 0) {
			result = "[ 추천 번호 " + count + "세트 ]\n";
			for (int i = 0; i < list.size(); i++) {
				if(i>0) {
					result += "\n";
				}
				result += "[ " +list.get(i).getNum1() +" ] ";
				result += "[ " +list.get(i).getNum2() +" ] ";
				result += "[ " +list.get(i).getNum3() +" ] ";
				result += "[ " +list.get(i).getNum4() +" ] ";
				result += "[ " +list.get(i).getNum5() +" ]";
				result += "[ " +list.get(i).getNum6() +" ]";
			}
		}else {
			result = "오류 발생";
		}
		
		return result;
	}
	
	private ArrayList<LottoVO> createLottoNum(int count) {
		if(count > 50) {
			count = 50;
		}
		HashMap<String, String> tempMap = new HashMap<String, String>(); 
		ArrayList<LottoVO> numList = new ArrayList<LottoVO>(); 
		while(numList.size() < count) {

			int [] num = new int[6];
			int temp;
			int checkNumber;

			//랜덤숫자대입,중복체크
			boolean flag;

			for(int i=0; i<num.length; i++){
				checkNumber = (int)(Math.random()*45)+1;
				flag=false;
				for(int ii=0; ii<i; ii++){
					if(num[ii] == checkNumber){
						flag = true;
						break;
					}
				}

				if(flag == true) {
					i--;
					continue;
				}

				num[i] = checkNumber;
			}

			//정렬

			for(int i=0;i<num.length;i++){
				for(int ii=0;ii<num.length;ii++){
					if(num[i]<num[ii]){
						temp=num[i];
						num[i]=num[ii];
						num[ii]=temp;
					}
				}
			}

			String numAppend = num[0]+"|"+num[1]+"|"+num[2]+"|"+num[3]+"|"+num[4]+"|"+num[5];
			System.out.println(numAppend);
			if(tempMap.get(numAppend) == null) {
				LottoVO lottoVO = new LottoVO();
				lottoVO.setNum1(String.format("%02d", num[0]));
				lottoVO.setNum2(String.format("%02d", num[1]));
				lottoVO.setNum3(String.format("%02d", num[2]));
				lottoVO.setNum4(String.format("%02d", num[3]));
				lottoVO.setNum5(String.format("%02d", num[4]));
				lottoVO.setNum6(String.format("%02d", num[5]));
				numList.add(lottoVO);
			}
		}
		return numList;
	}
}