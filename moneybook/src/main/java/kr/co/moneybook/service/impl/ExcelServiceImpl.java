package kr.co.moneybook.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import kr.co.moneybook.domain.Asset;
import kr.co.moneybook.domain.Earnings;
import kr.co.moneybook.domain.Expense;
import kr.co.moneybook.domain.User;
import kr.co.moneybook.mapper.AssetMapper;
import kr.co.moneybook.mapper.EarningsMapper;
import kr.co.moneybook.mapper.ExpenseMapper;
import kr.co.moneybook.service.ExcelService;

@Service
public class ExcelServiceImpl implements ExcelService {
	
	@Autowired
	private ExpenseMapper expenseMapper;
	@Autowired
	private EarningsMapper earningsMapper;
	@Autowired
	private AssetMapper assetMapper;
	
	//지출 리스트 가져오기
	@Override
	public List<Expense> expense_excel(HttpServletRequest request) {
		String insert_date = request.getParameter("status_date");
		User user =  (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String moneybook_name = user.getUsername();
		

		Map<String, Object> hashExpense = new HashMap<String, Object>();
		hashExpense.put("insert_date", insert_date);
		hashExpense.put("moneybook_name", moneybook_name);
		return expenseMapper.expense_select(hashExpense);
	}

	//수입 리스트 가져오기
	@Override
	public List<Earnings> earnings_excel(HttpServletRequest request) {
		String insert_date = request.getParameter("status_date");
		User user =  (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String moneybook_name = user.getUsername();
		
		Map<String, Object> hashExpense = new HashMap<String, Object>();
		hashExpense.put("insert_date", insert_date);
		hashExpense.put("moneybook_name", moneybook_name);
		return earningsMapper.earnings_select(hashExpense);
	}

	//자산 리스트 가져오기
	@Override
	public List<Asset> asset_excel(HttpServletRequest request) {
		User user =  (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String moneybook_name = user.getUsername();
		
		return assetMapper.asset_select(moneybook_name);
	}

}
