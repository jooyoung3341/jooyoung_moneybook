package kr.co.moneybook.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import kr.co.moneybook.domain.Recommend;
import kr.co.moneybook.domain.User;
import kr.co.moneybook.mapper.BoardMapper;
import kr.co.moneybook.mapper.RecommendMapper;
import kr.co.moneybook.service.RecommendService;

@Service
public class RecommendServiceImpl implements RecommendService {

	@Autowired
	private RecommendMapper recommendMapper;
	@Autowired
	private BoardMapper boardMapper;
	
	//추천 
	@Override
	public String recommend(HttpServletRequest request) {
		String bno = request.getParameter("bno");
		String status = request.getParameter("status");
		String moneybook_name = request.getParameter("moneybook_name");

		Recommend recommend = new Recommend();
		recommend.setBno(Integer.parseInt(bno));
		recommend.setStatus(status);
		recommend.setMoneybook_name(moneybook_name);
		
		Map<String, Object> hashRecommend = new HashMap<>();
		hashRecommend.put("bno", Integer.parseInt(bno));
		hashRecommend .put("status", status);
		boardMapper.board_recommend(hashRecommend);
		recommendMapper.recommend(recommend);
		
		//추천을 하고 바로 취소를 할 수 있게 추천기본키 값을 controller에 보냄
		String reno = Integer.toString(recommend.getReno());
		return reno;

	}

	//추천 취소
	@Override
	public void recommend_cancel(HttpServletRequest request) {
		String reno = request.getParameter("reno");
		String status = request.getParameter("status");
		String bno = request.getParameter("bno");
		
		//추천 up되있는 추천을 취소하면 -1, down되있는 추천을 취소하면 +1
		if(status.equals("up")){
			status = "down";
		}else if(status.equals("down")) {
			status = "up";
		}
		Map<String, Object> hashRecommend = new HashMap<>();
		hashRecommend.put("status", status);
		hashRecommend.put("bno", Integer.parseInt(bno));
		//추천을 취소 시 게시글 추천 수 변경
		boardMapper.board_recommend(hashRecommend);
		recommendMapper.recommend_cancel(Integer.parseInt(reno));
		
	}

	//추천 확인
	@Override
	public Recommend recommendStatus(HttpServletRequest request) {
		String bno = request.getParameter("bno");
		User user =  (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String moneybook_name = user.getUsername();
		
		Map<String, Object> hashRecommend = new HashMap<String, Object>();
		hashRecommend.put("bno", Integer.parseInt(bno));
		hashRecommend.put("moneybook_name", moneybook_name);
		return recommendMapper.recommendStatus(hashRecommend);
	}

}
