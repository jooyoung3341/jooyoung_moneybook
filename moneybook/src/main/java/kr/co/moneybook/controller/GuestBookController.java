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

import kr.co.moneybook.domain.GuestBook;
import kr.co.moneybook.domain.User;
import kr.co.moneybook.service.GuestBookService;

/*
 * 방명록
*/

@Controller
public class GuestBookController {

	@Autowired
	private GuestBookService guestbookService;
	
	//방명록 이동
	@RequestMapping(value="moneybook/guestbook", method=RequestMethod.GET)
	public String guestbook(Model model) {
		User user =  (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String moneybook_name = user.getUsername();
		//방명록 글 작성한 가계부 이름과 로그인한 가계부 이름 비교하기 위해 로그인세션을 클라이언트로 넘김
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
	public List<GuestBook> guestbook_select(){
		return guestbookService.guestbook_select();
	}
	
	//방명록 삭제 
	@RequestMapping(value="moneybook/guestbook/delete", method=RequestMethod.GET)
	@ResponseBody
	public void guestbook_delete(HttpServletRequest request) {
		guestbookService.guestbook_delete(request);
	}
	
	//방명록 수정 폼
	@RequestMapping(value="moneybook/guestbook/update_form", method=RequestMethod.GET)
	@ResponseBody
	public GuestBook guestbook_update_form(HttpServletRequest request) {
		return guestbookService.guestbook_update_form(request);
	}
	
	//방명록 수정
	@RequestMapping(value="moneybook/guestbook/update", method=RequestMethod.POST)
	@ResponseBody
	public void guestbook_update(HttpServletRequest request) {
		guestbookService.guestbook_update(request);
	}
}
