package kr.co.moneybook.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.co.moneybook.domain.Calendar;

public interface CalendarService {
	
	//달력 월 데이터 가져오기
	public List<Calendar> calendar_select(HttpServletRequest request);

}
