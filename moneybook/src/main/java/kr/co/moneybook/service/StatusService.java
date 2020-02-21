package kr.co.moneybook.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.co.moneybook.domain.Expense;
import kr.co.moneybook.domain.Status;

public interface StatusService {

	//가계부 현황
	public List<Status> status_select(HttpServletRequest request);
}
