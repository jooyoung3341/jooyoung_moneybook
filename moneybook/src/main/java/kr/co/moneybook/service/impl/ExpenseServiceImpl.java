package kr.co.moneybook.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import kr.co.moneybook.domain.Expense;
import kr.co.moneybook.domain.User;
import kr.co.moneybook.mapper.ExpenseMapper;
import kr.co.moneybook.service.ExpenseService;

@Service
public class ExpenseServiceImpl implements ExpenseService {

	@Autowired
	private ExpenseMapper expenseMapper;
	 
	//지출내역 삽입
	@Override
	public void expense_insert(HttpServletRequest request){
		//로그인한 사용자 이름 가져오기
		User user =  (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String moneybook_name = user.getUsername();
		String price = request.getParameter("price");
		String type = request.getParameter("type");
		String cartegory = request.getParameter("cartegory");
		String insert_date = request.getParameter("insert_date");
		
		Expense expense = new Expense();
		expense.setMoneybook_name(moneybook_name);
		expense.setPrice(Integer.parseInt(price));
		expense.setType(type);
		expense.setCartegory(cartegory);
		expense.setInsert_date(insert_date);
		
		expenseMapper.expense_insert(expense);
		
	}

	//지출내역 목록
	@Override
	public List<Expense> expense_select(HttpServletRequest request) {
		User user =  (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String moneybook_name = user.getUsername();
		String insert_date = request.getParameter("indate");
		
		//parameter값이 2개이상 맵으로 값을 넘긴다.
		Map<String, Object> hashExpense = new HashMap<String, Object>();
		hashExpense.put("insert_date", insert_date);
		hashExpense.put("moneybook_name", moneybook_name);
	
		return expenseMapper.expense_select(hashExpense);
	}

	//지출내역 삭제
	@Override
	public void expense_delete(HttpServletRequest request) {
		String [] checkArr = request.getParameterValues("checkArr");
		for(String eno : checkArr) {
			expenseMapper.expense_delete(Integer.parseInt(eno));
		}
	}
	
	//지출내역 수정 폼 입력값
	@Override
	public Expense expense_updateform(HttpServletRequest request) {
		String eno = request.getParameter("eno");
		return expenseMapper.expense_updateform(Integer.parseInt(eno));
	}
	
	//지출내역 수정
	public void expense_update(HttpServletRequest request) {
		String price = request.getParameter("price");
		String type = request.getParameter("type");
		String cartegory = request.getParameter("cartegory");
		String insert_date = request.getParameter("insert_date");
		String eno = request.getParameter("eno");
	
		Expense expense = new Expense();
		expense.setPrice(Integer.parseInt(price));
		expense.setType(type);
		expense.setCartegory(cartegory);
		expense.setInsert_date(insert_date);
		expense.setEno(Integer.parseInt(eno));
		
		expenseMapper.expense_update(expense);
		
	}


}
