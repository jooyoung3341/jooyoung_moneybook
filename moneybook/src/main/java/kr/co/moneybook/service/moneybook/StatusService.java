package kr.co.moneybook.service.moneybook;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.co.moneybook.domain.moneybook.Expense;
import kr.co.moneybook.domain.moneybook.Status;

public interface StatusService {

	//가계부 현황
	public List<Status> status_select(HttpServletRequest request);
}
