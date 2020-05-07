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

}
