package kr.co.moneybook.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.moneybook.domain.Recommend;
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
		String reno = Integer.toString(recommend.getReno());
		return reno;

	}

	//추천 취소
	@Override
	public void recommend_cancel(HttpServletRequest request) {
		String reno = request.getParameter("reno");
		String status = request.getParameter("status");
		if(status == "up") {
			status = "down";
		}else if(status == "down") {
			status = "up";
		}
		
		Map<String, Object> hashRecommend = new HashMap<>();
		hashRecommend.put("status", status);
		hashRecommend.put("reno", Integer.parseInt(reno));
		boardMapper.board_recommend(hashRecommend);
		recommendMapper.recommend_cancel(Integer.parseInt(reno));
		
	}

	//게시글에 해당하는 추천이 있는지 조회 확인 
	@Override
	public Recommend recommend_select(HttpServletRequest request) {
		String bno = request.getParameter("bno");
		String moneybook_name = request.getParameter("moneybook_name");
		
		Map<String, Object> hashRecommend = new HashMap<>();
		hashRecommend.put("bno", Integer.parseInt(bno));
		hashRecommend.put("moneybook_name", moneybook_name);
		return recommendMapper.recommend_select(hashRecommend);
		
	}

}
