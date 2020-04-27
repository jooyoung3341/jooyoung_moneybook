package kr.co.moneybook.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.moneybook.domain.Recommend;
import kr.co.moneybook.service.RecommendService;

/*
 * 가계부 이야기 게시글 추천 기능
*/

@Controller
public class RecommendController {

	@Autowired
	private RecommendService recommendService;
	
	//추천 
	@RequestMapping(value="moneybook/recommend", method=RequestMethod.GET)
	@ResponseBody
	public String recommend_up(HttpServletRequest request) {
		//추천을 바로 취소 할 수 있게 추천 기본키값을 service에서 받아 리턴
		String reno= recommendService.recommend(request);
		return reno;	
	}

	//추천 취소
	@RequestMapping(value="moneybook/recommend/cancel", method=RequestMethod.GET)
	@ResponseBody
	public void recommend_cancel(HttpServletRequest request) {
		recommendService.recommend_cancel(request);
	}
	
	//추천 확인
	@RequestMapping(value="moneybook/recommend/status", method=RequestMethod.GET)
	@ResponseBody
	public Recommend recommendStatus(HttpServletRequest request) {
		return recommendService.recommendStatus(request);
	}
	
}
