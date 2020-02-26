package kr.co.moneybook.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.moneybook.domain.Guestbook;
import kr.co.moneybook.domain.User;
import kr.co.moneybook.service.GuestbookService;

@Controller
public class GuestbookController {

	@Autowired
	private GuestbookService guestbookService;
	
	//방명록 이동
	@RequestMapping(value="moneybook/guestbook", method=RequestMethod.GET)
	public String guestbook(Model model) {
		User user =  (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String moneybook_name = user.getUsername();
		model.addAttribute("moneybook_name", moneybook_name);
		return "moneybook/guestbook";
	}
	
	//방명록 등록
	@RequestMapping(value="moneybook/guestbook/insert", method=RequestMethod.POST)
	@ResponseBody
	public void guestbook_insert(HttpServletRequest request) {
		guestbookService.guestbook_insert(request);
	}
	
	//방명록 목록
	@RequestMapping(value="moneybook/guestbook/select", method=RequestMethod.GET)
	@ResponseBody
	public List<Guestbook> guestbook_select(){
		return guestbookService.guestbook_select();
	}
}
