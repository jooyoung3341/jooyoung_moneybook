package kr.co.moneybook.controller;

import java.util.List;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.moneybook.domain.Expense;
import kr.co.moneybook.service.ExpenseService;

@Controller
public class ExpenseController {
	
	@Autowired
	private ExpenseService expenseService;

	//지출내역 삽입					
	@RequestMapping(value="moneybook/expense/insert", method=RequestMethod.POST)
	@ResponseBody
	public void expense_insert(HttpServletRequest request) throws Exception{
		expenseService.expense_insert(request);
	}
	
	//지출내역 목록
	@RequestMapping(value="moneybook/expense/select", method=RequestMethod.GET)
	@ResponseBody
	public List<Expense> expense_select(HttpServletRequest request){
		return expenseService.expense_select(request);
	}
	
	//정렬된 지출 내역 목록
	@RequestMapping(value="moneybook/expense/select_sort", method=RequestMethod.GET)
	@ResponseBody
	public List<Expense> expense_select_sort(HttpServletRequest request){
		return expenseService.expense_select_sort(request);
	}
	
	
	//지출내역 삭제
	@RequestMapping(value="moneybook/expense/delete", method=RequestMethod.GET)
	@ResponseBody
	public void expense_delete(HttpServletRequest request){
		expenseService.expense_delete(request);
	}
	
	//지출내역 수정 폼
	@RequestMapping(value="moneybook/expense/updateform", method=RequestMethod.GET)
	@ResponseBody
	public Expense expense_updateform(HttpServletRequest request) {
		 return expenseService.expense_updateform(request);
	}
		
	//지출내역 수정
	@RequestMapping(value="moneybook/expense/update", method=RequestMethod.POST)
	@ResponseBody
	public void expense_update(HttpServletRequest request) {
		expenseService.expense_update(request);
	}
}
