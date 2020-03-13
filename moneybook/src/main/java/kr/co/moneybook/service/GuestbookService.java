package kr.co.moneybook.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.co.moneybook.domain.Guestbook;

public interface GuestbookService {

	//방명록 등록
	public void guestbook_insert(HttpServletRequest request);
	
	//방명록 목록
	public List<Guestbook> guestbook_select();
	
	//방명록 삭제
	public void guestbook_delete(HttpServletRequest request);
	
	//방명록 수정 폼
	public Guestbook guestbook_update_form(HttpServletRequest request);
	
	//방명록 수정
	public void guestbook_update(HttpServletRequest request);
}
