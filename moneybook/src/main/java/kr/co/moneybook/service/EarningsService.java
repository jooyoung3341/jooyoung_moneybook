package kr.co.moneybook.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.co.moneybook.domain.Earnings;
import kr.co.moneybook.domain.Expense;

public interface EarningsService {

	//수입내역 삽입
	public void earnings_insert(HttpServletRequest request);
	
	//수입내역 목록
	public List<Earnings> earnings_select(HttpServletRequest request);
	
	//수입내역 삭제
	public void earnings_delete(HttpServletRequest request);
	
	//수입내역 수정 폼
	public Earnings earnings_updateform(HttpServletRequest request);
	
	//수입내역 수정
	public void earnings_update(HttpServletRequest request);
}
