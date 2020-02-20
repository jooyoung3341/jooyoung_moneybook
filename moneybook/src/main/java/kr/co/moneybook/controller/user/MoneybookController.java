package kr.co.moneybook.controller.user;

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

import kr.co.moneybook.domain.user.Moneybook;
import kr.co.moneybook.domain.user.User;
import kr.co.moneybook.service.user.MoneybookService;

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
	
	//로그인
	/*
	 * @RequestMapping(value="/login", method=RequestMethod.POST) public void
	 * login(HttpServletRequest request, HttpSession session, RedirectAttributes
	 * attr ) { String moneybook_name = request.getParameter("moneybook_name");
	 * Moneybook moneybook = (Moneybook)
	 * moneybookService.loadUserByUsername(moneybook_name); if(moneybook == null) {
	 * attr.addFlashAttribute("loginmsg", "가계부이름, 패스워드가 틀립니다."); }else {
	 * session.setAttribute("moneybook", moneybook);
	 * session.setAttribute("moneybook_name", moneybook.getMoneybook_name()); } }
	 */
	
}
