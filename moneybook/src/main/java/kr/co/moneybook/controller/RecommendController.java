package kr.co.moneybook.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.moneybook.service.RecommendService;

@Controller
public class RecommendController {

	@Autowired
	private RecommendService recommendService;
	
	@RequestMapping(value="moneybook/recommend/insert", method=RequestMethod.GET)
	@ResponseBody
	public void recommend_insert(HttpServletRequest request) {
		recommendService.recommend_insert(request);
	}
	
}
