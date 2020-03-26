package kr.co.moneybook.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.moneybook.domain.Recommend;
import kr.co.moneybook.mapper.RecommendMapper;
import kr.co.moneybook.service.RecommendService;

@Service
public class RecommendServiceImpl implements RecommendService {

	@Autowired
	private RecommendMapper recommendMapper;
	
	//추천 등록
	@Override
	public void recommend_insert(HttpServletRequest request) {
		String bno = request.getParameter("bno");
		String status = request.getParameter("status");
		String moneybook_name = request.getParameter("moneybook_name");

		Recommend recommend = new Recommend();
		recommend.setBno(Integer.parseInt(bno));
		recommend.setStatus(status);
		recommend.setMoneybook_name(moneybook_name);
		
		recommendMapper.recommend_insert(recommend);
	}

}
