package kr.co.moneybook.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.moneybook.domain.Moneybook;
import kr.co.moneybook.domain.User;
import kr.co.moneybook.service.MoneybookService;

@Controller
public class MoneybookController {

	@Autowired
	private MoneybookService moneybookService;
	
	//지출내역 이동
	  @RequestMapping(value="moneybook/moneybook", method=RequestMethod.GET) 
	  public String expense(HttpSession session) { 
		  return "moneybook/moneybook"; 
	  }
	 
		
	//가계부 이름 중복 확인
	@RequestMapping(value="moneybook_name_check", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> moneybook_name_check(HttpServletRequest request){
		String moneybook_name = moneybookService.moneybook_name_check(request);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", moneybook_name == null);
		return map;
		
	}
	
	//가계부 등록
	@RequestMapping(value="moneybookRegister", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> register(HttpServletRequest request) throws Exception{
		boolean result = moneybookService.register(request);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
		return map;
	}
	
}
