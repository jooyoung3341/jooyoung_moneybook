package kr.co.moneybook.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.moneybook.domain.Reply;
import kr.co.moneybook.service.ReplyService;

@Controller
public class ReplyController {

	@Autowired
	private ReplyService replyService;
	
	//댓글 삽입
	@RequestMapping(value="moneybook/reply/insert", method=RequestMethod.POST)
	@ResponseBody
	public void reply_insert(HttpServletRequest request) {
		replyService.reply_insert(request);
	}
	
	//댓글 목록
	@RequestMapping(value="moneybook/reply/select", method=RequestMethod.GET)
	@ResponseBody
	public List<Reply> reply_select(HttpServletRequest request){
		return replyService.reply_select(request);
	}
	
	//댓글 삭제
	@RequestMapping(value="moneybook/reply/delete", method=RequestMethod.GET)
	@ResponseBody
	public void reply_delete(HttpServletRequest request) {
		replyService.reply_delete(request);
	}
	
	//댓글 수정 폼
	@RequestMapping(value="moneybook/reply/update_form", method=RequestMethod.GET)
	@ResponseBody
	public Reply reply_update_form(HttpServletRequest request) {
		return replyService.reply_update_form(request);
	}
}
