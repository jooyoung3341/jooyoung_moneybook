package kr.co.moneybook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CalendarController {

	@RequestMapping(value="moneybook/calendar", method=RequestMethod.GET)
	public String calendar() {
		return "moneybook/calendar";
	}
}
