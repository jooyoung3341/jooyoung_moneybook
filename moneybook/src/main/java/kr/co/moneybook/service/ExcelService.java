package kr.co.moneybook.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.co.moneybook.domain.Asset;
import kr.co.moneybook.domain.Earnings;
import kr.co.moneybook.domain.Expense;

public interface ExcelService {

	//지출내역 엑셀
	public List<Expense> expense_excel(HttpServletRequest request);

	//수입내역 엑셀
	public List<Earnings> earnings_excel(HttpServletRequest request);

	//자산내역 엑셀
	public List<Asset> asset_excel(HttpServletRequest request);
}
