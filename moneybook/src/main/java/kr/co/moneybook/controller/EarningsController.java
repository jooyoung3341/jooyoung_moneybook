package kr.co.moneybook.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.moneybook.domain.Earnings;
import kr.co.moneybook.domain.Expense;
import kr.co.moneybook.service.EarningsService;

@Controller
public class EarningsController {

	@Autowired
	private EarningsService earningsService;
	
	//수입내역 이동
	@RequestMapping(value="moneybook/earnings", method=RequestMethod.GET)
	public String earnings() {
		return "moneybook/earnings";
	}
	
	//수입내역 삽입
	@RequestMapping(value="moneybook/earnings/insert", method=RequestMethod.POST)
	@ResponseBody
	public void earnings_insert(HttpServletRequest request) throws Exception{
		earningsService.earnings_insert(request);
	}
	
	//수입내역 목록
	@RequestMapping(value="moneybook/earnings/select", method=RequestMethod.GET)
	@ResponseBody
	public List<Earnings> earnings_select(HttpServletRequest request){
		return earningsService.earnings_select(request);
	}
	
	//수입내역 삭제
	@RequestMapping(value="moneybook/earnings/delete", method=RequestMethod.POST)
	@ResponseBody
	public void earnings_delete(HttpServletRequest request){
		earningsService.earnings_delete(request);
	}
	
	//수입내역 수정 폼
	@RequestMapping(value="moneybook/earnings/updateform", method=RequestMethod.GET)
	@ResponseBody
	public Earnings earnings_updateform(HttpServletRequest request) {
		return earningsService.earnings_updateform(request);
	}
	
	//수입내역 수정
	@RequestMapping(value="moneybook/earnings/update", method=RequestMethod.POST)
	@ResponseBody
	public void earnings_update(HttpServletRequest request) {
		earningsService.earnings_update(request);
	}
	
}
