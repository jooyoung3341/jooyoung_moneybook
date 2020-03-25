package kr.co.moneybook.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.moneybook.domain.Calendar;
import kr.co.moneybook.service.CalendarService;

@Controller
public class CalendarController {

	@Autowired
	private CalendarService calendarService;
	
	//달력으로 이동
	@RequestMapping(value="moneybook/calendar", method=RequestMethod.GET)
	public String calendar() {
		return "moneybook/calendar";
	}
	
	//달력 월 데이터 가져오기
	@RequestMapping(value="moneybook/calendar/select", method=RequestMethod.GET)
	@ResponseBody
	public List<Calendar> calendar_select(HttpServletRequest request){
		return calendarService.calendar_select(request);
	}
}
