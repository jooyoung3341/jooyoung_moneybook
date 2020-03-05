package kr.co.moneybook.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.co.moneybook.domain.Reply;

public interface ReplyService {

	//댓글 삽입
	public void reply_insert(HttpServletRequest request);
	
	//댓글 목록 
	public List<Reply> reply_select(HttpServletRequest request);
	
	//댓글 삭제
	public void reply_delete(HttpServletRequest request);
	
	//댓글 수정 폼
	public Reply reply_update_form(HttpServletRequest request);
}
