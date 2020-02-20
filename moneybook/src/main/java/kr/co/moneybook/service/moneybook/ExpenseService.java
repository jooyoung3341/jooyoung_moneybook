package kr.co.moneybook.service.moneybook;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.co.moneybook.domain.moneybook.Expense;

public interface ExpenseService {

	//지출내역 삽입
	public void expense_insert(HttpServletRequest request);
	
	//지출내역 목록
	public List<Expense> expense_select(HttpServletRequest request);
	
	//지출내역 삭제
	public void expense_delete(HttpServletRequest request);
	
	//지출내역 수정 폼 입력값 가져오기
	public Expense expense_updateform(HttpServletRequest request);
	
	//지출내역 수정
	public void expense_update(HttpServletRequest reqeust);
}
