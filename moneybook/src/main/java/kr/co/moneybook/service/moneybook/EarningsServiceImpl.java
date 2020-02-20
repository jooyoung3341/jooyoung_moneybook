package kr.co.moneybook.service.moneybook;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import kr.co.moneybook.domain.moneybook.Earnings;
import kr.co.moneybook.domain.user.Moneybook;
import kr.co.moneybook.domain.user.User;
import kr.co.moneybook.mapper.moneybook.EarningsMapper;

@Service
public class EarningsServiceImpl implements EarningsService {
	
	@Autowired
	private EarningsMapper earningsMapper;
	
	//수입내역 삽입
	@Override
	public void earnings_insert(HttpServletRequest request) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String moneybook_name = user.getUsername();
		String price = request.getParameter("price");
		String cartegory = request.getParameter("cartegory");
		String insert_date = request.getParameter("insert_date");

		Earnings earnings = new Earnings();
		earnings.setMoneybook_name(moneybook_name);
		earnings.setPrice(Integer.parseInt(price));
		earnings.setCartegory(cartegory);
		earnings.setInsert_date(insert_date);
		
		earningsMapper.earnings_insert(earnings);
		
	}
	
	//수입내역 목록
	@Override
	public List<Earnings> earnings_select(HttpServletRequest request) {
		User user =  (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String moneybook_name = user.getUsername();
		String insert_date = request.getParameter("indate");
		
		Map<String, Object> hashEarnings = new HashMap<String, Object>();
		hashEarnings.put("moneybook_name", moneybook_name);
		hashEarnings.put("insert_date", insert_date);
		return earningsMapper.earnings_select(hashEarnings);
	}
	
	//수입내역 삭제
	@Override
	public void earnings_delete(HttpServletRequest request) {
		String [] checkArr = request.getParameterValues("checkArr");
		for(String ino : checkArr) {
			earningsMapper.earnings_delete(Integer.parseInt(ino));
		}
	}

	//수입내역 수정 폼
	@Override
	public Earnings earnings_updateform(HttpServletRequest request) {
		String ino = request.getParameter("ino");
		return earningsMapper.earnings_updateform(Integer.parseInt(ino));
	}

	//수입내역 수정
	@Override
	public void earnings_update(HttpServletRequest request) {
		String ino = request.getParameter("ino");
		String price = request.getParameter("price");
		String cartegory = request.getParameter("cartegory");
		String insert_date = request.getParameter("insert_date");
		
		Earnings earnings = new Earnings();
		earnings.setIno(Integer.parseInt(ino));
		earnings.setPrice(Integer.parseInt(price));
		earnings.setCartegory(cartegory);
		earnings.setInsert_date(insert_date);
		
		earningsMapper.earnings_update(earnings);
	}

}
