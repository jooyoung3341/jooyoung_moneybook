package kr.co.moneybook.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import kr.co.moneybook.domain.Calendar;
import kr.co.moneybook.domain.User;
import kr.co.moneybook.mapper.CalendarMapper;
import kr.co.moneybook.mapper.EarningsMapper;
import kr.co.moneybook.mapper.ExpenseMapper;
import kr.co.moneybook.service.CalendarService;

@Service
public class CalendarServiceImpl implements CalendarService {

	@Autowired
	private CalendarMapper calendarMapper;
	
	//달력 월 데이터 가져오기
	@Override
	public List<Calendar> calendar_select(HttpServletRequest request) {
		User user =  (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String moneybook_name = user.getUsername();
		
		String insert_date = request.getParameter("insert_date");
		
		Map<String, Object> hashCalendar = new HashMap<String, Object>();
		hashCalendar.put("insert_date", insert_date);
		hashCalendar.put("moneybook_name", moneybook_name);
		
		
		return calendarMapper.calendar_select(hashCalendar);
	}

	//달력 데이터 삽입하기
	@Override
	public void calendar_insert(HttpServletRequest request) {
		String moneybook_type = request.getParameter("moneybook_type");
		String price = request.getParameter("price");
		String insert_date = request.getParameter("insert_date");
		String cartegory = request.getParameter("cartegory");
		
		Calendar calendar = new Calendar();
		calendar.setCartegory(cartegory);
		calendar.setInsert_date(insert_date);
		calendar.setMoneybook_type(moneybook_type);
		calendar.setPrice(Integer.parseInt(price));
		if(moneybook_type == "expense") {
			String type = request.getParameter("type");
			calendar.setType(type);
		}
	}
}
