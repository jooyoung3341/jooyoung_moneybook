package kr.co.moneybook.controller.moneybook;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.moneybook.domain.moneybook.Expense;
import kr.co.moneybook.domain.moneybook.Status;
import kr.co.moneybook.service.moneybook.StatusService;

@Controller
public class StatusController {

	@Autowired
	private StatusService statusService;
	
	//가계부 현황
	@RequestMapping(value="moneybook/status/select", method=RequestMethod.GET)
	@ResponseBody
	public List<Status> status_select(HttpServletRequest request) {
		return statusService.status_select(request);
		
	}
}
