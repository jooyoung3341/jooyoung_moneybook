package kr.co.moneybook.service;

import javax.servlet.http.HttpServletRequest;

import kr.co.moneybook.domain.Recommend;

public interface RecommendService {

	//추천
	public String recommend(HttpServletRequest request);
	
	//추천 취소
	public void recommend_cancel(HttpServletRequest request);
}
